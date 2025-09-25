import pandas as pd
import os
import glob
from datetime import datetime

# ===============================================
# 설정 변수 및 정렬 기준
# ===============================================
OUTPUT_EXCEL_FILENAME = "partner_monthly_connection_summary_sorted.xlsx"
LOGIN_CONTENT = "사용자가 접속하였습니다."
PARTNER_ID_LENGTH = 4

# 제휴사 코드와 이름 매핑 딕셔너리 (이전과 동일)
PARTNER_MAPPING = {
    "M010": "롯데멤버스", "L020": "롯데백화점", "L040": "데슈퍼(직)", "L180": "롯데홈쇼핑",
    "L030": "롯데마트", "L130": "롯데월드", "A600": "대홍기획", "L140": "롯데호텔",
    "L320": "롯데하이마트", "L150": "롯데면세점", "L042": "데슈퍼(CS)", "L050": "롯데닷컴(롯데ON)",
    "L330": "롯데칠성 음료", "L890": "롯데GFR", "L060": "세븐일레븐", "L070": "롯데리아",
    "L190": "롯데제이티비", "L300": "롯데자산개발", "L340": "롯데물산", "L360": "엘푸드", 
    "L370": "그린카", "L380": "롯데렌탈", "L390": "글로벌로케이션", "L400": "롯데정보통신",
    "L900": "이브이시스", "A035": "스푼(주)", "A053": "마트공유", "A056": "엘리 e커머스",
    "A285": "메조미디어", "A530": "파크에스텍", "L010": "롯데카드", "L041": "데슈퍼(가)",
    "L120": "세시테마(티)", "L160": "롯데호텔부산", "L220": "롯데캐피탈", "L230": "롯데자이언츠",
    "L450": "롯데리조트", "L730": "지구복지재단", "L940": "금화영농조합법인",
}

# 요청하신 제휴사 우선 순위 목록 (Partner ID 기준)
PRIORITY_PARTNERS = ["M010", "L020", "L030", "L040", "L060"]

# ===============================================
# 1. 모든 JSON 파일 통합 로드 및 시간 데이터 처리 (이전과 동일)
# ===============================================
all_json_files = glob.glob("*.json")
if not all_json_files:
    print("⚠️ 오류: 현재 디렉터리에서 '.json' 파일을 찾을 수 없습니다.")
    exit()

df_list = []
for file_name in all_json_files:
    try:
        df_list.append(pd.read_json(file_name))
    except Exception as e:
        print(f"⚠️ 오류: {file_name} 로드 중 문제가 발생했습니다. ({e})")
        
if not df_list:
    print("\n⚠️ 유효하게 로드된 데이터가 없습니다.")
    exit()

df_all = pd.concat(df_list, ignore_index=True)
print(f"⭐ 총 {len(df_all)}개의 로그 레코드를 통합했습니다.")

try:
    df_all['datetime'] = pd.to_datetime(df_all['timestamp'], unit='ms')
    df_all['month'] = df_all['datetime'].dt.strftime('%Y-%m월') 
except KeyError:
    print("⚠️ 오류: JSON 파일에 'timestamp' 컬럼이 없거나 형식이 잘못되었습니다.")
    exit()

df_login_events = df_all[df_all['content'] == LOGIN_CONTENT].copy()
if df_login_events.empty:
    print(f"✅ 통합된 데이터에 '{LOGIN_CONTENT}' 이벤트가 없습니다. 빈 결과를 생성합니다.")
    exit()

df_login_events['partnerId'] = df_login_events['userId'].str[:PARTNER_ID_LENGTH]

# ===============================================
# 2. 월별로 그룹화하여 접속 수 계산 및 정렬 적용
# ===============================================
all_dataframes = {}
grouped_by_month = df_login_events.groupby('month')

print("\n2. 월별로 그룹화하여 제휴사 접속 횟수 계산 및 정렬 적용...")

for month_name, group in grouped_by_month:
    
    # 2-1. 접속 횟수 계산 (이전과 동일)
    count_inclusive = group.groupby('partnerId').size().reset_index(name='사용자수(중복포함)')
    count_exclusive = group.groupby('partnerId')['userId'].nunique().reset_index(name='사용자수(중복제거)')
    df_summary = pd.merge(count_inclusive, count_exclusive, on='partnerId', how='outer').fillna(0)
    
    # 0건인 행 필터링
    df_summary = df_summary[df_summary['사용자수(중복포함)'] > 0].copy()

    if df_summary.empty:
        print(f"   -> 필터링 후 {month_name}에 유효한 접속 데이터가 없어 건너뜱니다.")
        continue
        
    # 제휴사 이름 추가 및 컬럼 이름 변경
    df_summary['제휴사'] = df_summary['partnerId'].map(PARTNER_MAPPING).fillna('알 수 없음')
    df_summary.rename(columns={'partnerId': '제휴단위코드'}, inplace=True)
    
    # 2-2. 엑셀 출력 순서 정렬 로직 적용 ⭐
    
    # 1) 우선 순위 제휴사 분류
    # is_priority 열: PRIORITY_PARTNERS 리스트에 있으면 True
    df_summary['is_priority'] = df_summary['제휴단위코드'].isin(PRIORITY_PARTNERS)
    
    # 2) 우선 순위 제휴사에 순서 지정
    # priority_order 열: 우선 순위 리스트의 인덱스를 사용하여 순서를 부여. 리스트에 없으면 큰 숫자(99) 부여.
    priority_map = {pid: i for i, pid in enumerate(PRIORITY_PARTNERS)}
    df_summary['priority_order'] = df_summary['제휴단위코드'].map(priority_map).fillna(99).astype(int)
    
    # 3) 정렬 수행
    # - 1차: is_priority (True가 먼저 오도록 내림차순)
    # - 2차: priority_order (0, 1, 2... 순으로 오름차순)
    # - 3차: 제휴사 이름 (가나다순으로 오름차순, 우선 순위가 아닌 제휴사에만 적용됨)
    df_summary.sort_values(
        by=['is_priority', 'priority_order', '제휴사'],
        ascending=[False, True, True],
        inplace=True
    )
    
    # 정렬에 사용된 임시 컬럼 제거
    df_summary.drop(columns=['is_priority', 'priority_order'], inplace=True)
    
    # 최종 엑셀 컬럼 순서
    df_summary = df_summary[['제휴단위코드', '제휴사', '사용자수(중복제거)', '사용자수(중복포함)']]
    
    # 결과 저장
    all_dataframes[month_name] = df_summary.astype({'사용자수(중복제거)': int, '사용자수(중복포함)': int})

# ===============================================
# 3. 결과를 월별 시트로 엑셀 파일에 저장 (이전과 동일)
# ===============================================
if not all_dataframes:
    print("\n⚠️ 최종적으로 엑셀에 저장할 유효한 데이터가 없습니다.")
    exit()

print(f"\n3. 결과를 월별 시트로 엑셀 파일에 저장: {OUTPUT_EXCEL_FILENAME}")

with pd.ExcelWriter(OUTPUT_EXCEL_FILENAME, engine='openpyxl') as writer:
    sorted_months = sorted(all_dataframes.keys())
    
    for month_name in sorted_months:
        df_to_save = all_dataframes[month_name]
        df_to_save.to_excel(writer, sheet_name=month_name, index=False)
        print(f"   -> 시트 '{month_name}' 저장 완료 (총 {len(df_to_save)}개 제휴사)")

print("-----------------------------------------------------------------")
print(f"✅ 모든 처리가 완료되었습니다. 결과 파일: {OUTPUT_EXCEL_FILENAME}")
print("-----------------------------------------------------------------")

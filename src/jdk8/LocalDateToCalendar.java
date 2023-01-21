package jdk8;

import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LocalDateToCalendar {

    //{"현재일자:day", "채널 배열",{"채널타입","발송건수","성공건수","실패건수"},"오늘날짜여부":true}

    //
// 예약현황 https://isntyet.github.io/java/java-stream-%EC%A0%95%EB%A6%AC(map)/

    /*SELECT SENDSTART_DT ,CHANNEL_TYPE FROM NVCAMPAIGN A
    WHERE SENDSTART_DT LIKE '2019%' AND A.CAMPAIGN_STS='R'
    GROUP BY SENDSTART_DT ,CHANNEL_TYPE
    ORDER BY SENDSTART_DT;*/

    //링크는 현재일자 "
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int year = 2022; //sc.nextInt();
        int month = 12;

        LocalDate startDate = LocalDate.of(year, month, 1);
        LocalDate endDate = LocalDate.of(year, month, startDate.lengthOfMonth());
        System.out.println(startDate.plusMonths(-1));
        System.out.println(startDate.plusMonths((0)));
        System.out.println(startDate.plusMonths((+1)));

        int firstWeek = startDate.get(ChronoField.DAY_OF_WEEK); //해당 월의 첫 번째 요일 확인
        int endWeek = endDate.get(ChronoField.DAY_OF_WEEK); //해당 월의 첫 번째 요일 확인
        System.out.println(firstWeek);
        System.out.println(endWeek);

        System.out.println(startDate.minusDays(firstWeek)); //7이면 빼면안됨
        System.out.println(endDate.plusDays(6-endWeek));

        System.out.println(toList(startDate.minusDays(firstWeek),endDate.plusDays(6-endWeek)));

        System.out.println(LocalDate.now().getYear());
        System.out.println(LocalDate.now().getMonth().getValue());
        System.out.println(LocalDate.of(year, 01, 1).getMonth().getValue());
    }
    public static List<LocalDate> toList(LocalDate startDate, LocalDate endDate) { //could also be built from the stream() method
        List<LocalDate> dates = new ArrayList<>();
        for (LocalDate d = startDate; !d.isAfter(endDate); d = d.plusDays(1)) {
            dates.add(d);
        }
        return dates;
    }
}

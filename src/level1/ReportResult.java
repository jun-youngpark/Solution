package level1;

import java.util.*;

public class ReportResult {


    //신고한사람 , 신고 받은 사람
    public int[] solution(String[] id_list, String[] report, int k) {
       // List<String> list = Arrays.stream(report).distinct().collect(Collectors.toList());
        //System.out.println(list);
        HashMap<String,HashSet<String>> reporterInfoMap =new HashMap<String,HashSet<String>>();
        HashMap<String,Integer> repotedCount =new HashMap<String,Integer>();
        for (String reporter:id_list){
            reporterInfoMap.put(reporter,new HashSet<>());
            repotedCount.put(reporter,0);
        }

        for (String str:report){
            String reporter= str.substring(0,str.indexOf(" "));
            String reported = str.substring(str.indexOf(" ")+1);
            if(reporterInfoMap.get(reporter).add(reported)) {   //존재하지않으면 true
                repotedCount.put(reported, repotedCount.get(reported) + 1);
            }
        }
        int[] answer = new int[id_list.length];

        for(String key : repotedCount.keySet()){
            int value = repotedCount.get(key);
            if(value >= k){
                for (int i=0 ; i<id_list.length ;i++) {
                    if(reporterInfoMap.get(id_list[i]).contains(key)){
                        answer[i] = answer[i] + 1;
                    }
                }

            }
        }
        Arrays.stream(answer).forEach(System.out::println);
        return answer;
    }

    public static void main(String[] args) {
        ReportResult rpt =new ReportResult();
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k=2;
        rpt.solution(id_list,report,k);
        //rpt.solution(["muzi", "frodo", "apeach", "neo"],["muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"],2);
    }
}

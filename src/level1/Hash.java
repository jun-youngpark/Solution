package level1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Hash {



    public String solution(String[] participant, String[] completion) {
        String answer = "";

        Map<String, Integer> hashMap
                = new HashMap<String, Integer>();

        for (int i = 0; i < participant.length; i++) {
            hashMap.put(participant[i],hashMap.getOrDefault(participant[i],0)+1);
        }
        for (int i = 0; i < completion.length; i++) {
            hashMap.put(completion[i],hashMap.get(completion[i])-1);
        }
        for(String key : hashMap.keySet()) {
            if(hashMap.get(key) != 0){
                answer = key;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Hash hash = new Hash();
        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"stanko", "ana", "mislav"};
        System.out.println(hash.solution(participant,completion));

    }
}

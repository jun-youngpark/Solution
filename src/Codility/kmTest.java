package Codility;

import level1.CreateNewId_java;

import java.util.*;

public class kmTest {

    private final String REMOVAL_REGEX = "\\-";
    private final String mailAdditionalData = ".com";
    private final String Separator = "@";

    public static void main(String[] args) {
        kmTest kmtest= new kmTest();
        String S="John Doe, Peter Parker, Mary Jane Watson-Parker, James Doe, John Elvis Doe, Jane Doe, Penny Parker";
        String C="Example";
        String result = kmtest.solution(S,C);
        System.out.println(result);
    }



    private String removeInvalidName(String id) {
        return id.replaceAll(REMOVAL_REGEX, "");
    }



    private String cutNameOfmaxSize(String lastName){
       if(lastName.length() > 8){
           return lastName.substring(0,8);
       }
       return lastName;
    }

    private String makeMailId(String name){
        String firstName;
        String middelName;
        String lastName;
        name = removeInvalidName(name).toLowerCase();
        List<String> separateName = Arrays.asList(name.split("\\s"));

        if( separateName.size() == 2){
            firstName = separateName.get(0);
            lastName = separateName.get(1);
            return firstName.substring(0,1) + cutNameOfmaxSize(lastName);
        }else if (separateName.size() == 3){
            firstName = separateName.get(0);
            middelName = separateName.get(1);
            lastName = separateName.get(2);
            return firstName.substring(0,1) + middelName.substring(0,1) + cutNameOfmaxSize(lastName); 
        }else {
            throw new IllegalArgumentException("잘못된 이름입니다.");
        }
    }

    public String removeInvalidMailAddr(String id) {
        return id.replaceAll(REMOVAL_REGEX, "");
    }

    public String makeMailAddr(String mailAddr){
        return removeInvalidMailAddr(mailAddr.toLowerCase()) + mailAdditionalData;
    }

    public String solution(String S, String C) {
      List<String> nameList = Arrays.asList(S.split("\\s*,\\s*"));
      String EmailAddress = makeMailAddr(C);
      Map<String, Integer> nameListMap = new HashMap<String, Integer>();

      StringBuilder sb = new StringBuilder();

      for(int i=0; i< nameList.size(); i++){
          String name = nameList.get(i);
          String id = makeMailId(name);

          sb.append(name);
          sb.append(" <");
          if(nameListMap.containsKey(id)){
              Integer cnt = nameListMap.get(id) + 1;
              nameListMap.put(id, cnt);
              sb.append(id + cnt);
          }else{
              nameListMap.put(id, 1);
              sb.append(id);
          }
          sb.append(Separator);
          sb.append(EmailAddress);
          sb.append(">");
          if(i != nameList.size()-1){
              sb.append(", ");
          }
      }

      return sb.toString();
    }

}

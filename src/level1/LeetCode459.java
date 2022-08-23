package level1;

public class LeetCode459 {

    public boolean repeatedSubstringPattern(String s) {
        int idx = (s + s).indexOf(s, 1);
        System.out.println(idx);
        return  idx < s.length();

    }
  /*  public boolean repeatedSubstringPattern(String s) {
        String repeat ="";
        System.out.println(s+s);

        int nextPoint = s.substring(1).indexOf(String.valueOf(s.charAt(0)));
        if(nextPoint == -1){
            return false;
        }
        repeat = s.substring(0,nextPoint+1);
        int size = repeat.length();


        for(int i=nextPoint+1;i<s.length();){
            if(i+size>s.length()) return  false;

            String currentChar = s.substring(i,i+size);
            if(!repeat.equals(currentChar)){
                return false;
            }
            i += repeat.length();
        }
        return true;
    }
*/
    public static void main(String[] args) {
        String a= "ba";

        LeetCode459 leetCode459 = new LeetCode459();
        System.out.println(leetCode459.repeatedSubstringPattern(a));
    }
}

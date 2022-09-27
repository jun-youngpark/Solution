package LeetCode;

/*
* 회문
* 거꾸로 읽어도 제대로 읽는 것과 같은 문장이나 낱말, 숫자,
* 우영우
 * */
public class Palindrome {

    public static void main(String[] args) {
        System.out.println(validPalindrome("aba"));
    }

    public static boolean validPalindrome(String s) {

        int start = 0;
        int end = s.length() - 1;

        while (start < end)  {
            // Found a mismatched pair - try both deletions
            if (s.charAt(start) != s.charAt(end)) {
                return (checkPalindrome(s, start, end - 1) || checkPalindrome(s, start + 1, end));
            }
            start++;
            end--;
        }
        return true;
    }
    private static boolean checkPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}

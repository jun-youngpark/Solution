package level1;

import java.util.Arrays;
import java.util.List;

public class Solution {

    /*
    유클리드 호제법 :
     */
    public static void main(String[] args) {
        level1.Solution test = new level1.Solution();
        int gcd = test.gcd(2, 5);
        int lcm = test.lcm(2, 5);
        System.out.println("gcd:"+gcd + "\t" + "lcm:"+lcm);
    }

    public int lcm(int n, int m) { //Least Common Multiple
        int multiple = n * m;
        int tmp;
        while (m != 0) {
            tmp = n % m;
            n = m;
            m = tmp;
        }
        return multiple / n;
    }

    public int gcd(int n, int m) { //Greatest Common Divisor
        int tmp;
        while (m != 0) {
            tmp = n % m;
            n = m;
            m = tmp;
        }
        return n;
    }

}

package math;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Stream;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025/8/18
 */
public class Lc866 {
    public int primePalindrome(int n) {

        for (int x = 2; x <= 200000000; x++) {
            if (isHw(x)) {
                if (String.valueOf(x).length() % 2 == 0) {
                    if (x != 11) {
                        continue;
                    }
                }
                if (isPrime(x)) {
                    return x;
                }
            }
        }
        return -1;
    }

    public boolean isPrime(int n) {

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return n != 1;
    }

    public boolean isHw(int n) {

        String str = String.valueOf(n);
        int l = 0;
        int r = str.length() - 1;
        while (l <= r) {
            if (str.charAt(l) != str.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    public static void main(String[] args) {
        char[] chars = new char[3];
        int[] ints = new int[]{
                1,2,3
        };
        System.out.println(new Lc866().primePalindrome(9989900));
    }
}

package od;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * P00338-全排列
 *
 * @author chenghu
 * @since 2025-08-18 23:58:01
 */
public class Od28AllPermutation {

    static int ans = 0;

    static char[] freq = new char[26];

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        while ((line = reader.readLine()) != null) {
            ans = 0;
//            dfs(line.toCharArray(),0);
            int n = line.length();
            // 计算其中的重复的
            char[] charArray = line.toCharArray();
            for (int i = 0; i < charArray.length; i++) {
                freq[charArray[i] - 'A']++;
            }
            Arrays.sort(freq);
            BigInteger factorial = factorial(n);
            for (int i = 0; i < freq.length; i++) {
                if (freq[i] > 1) {
                    factorial = factorial.divide(factorial(freq[i]));
                }
            }
            System.out.println(factorial.toString());
        }
        reader.close();
    }

    public static void dfs(char[] chars, int i) {
        if (i == chars.length) {
            ans++;
            return;
        }
        Set<Character> set = new HashSet<>();
        for (int j = i; j < chars.length; j++) {
            if (!set.contains(chars[j])) {
                set.add(chars[j]);
                swap(chars, i, j);
                dfs(chars, i + 1);
                swap(chars, i, j);
            }
        }
    }

    public static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    public static BigInteger factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n must be non-negative");
        }
        BigInteger result = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }

}

package od;

import java.util.Scanner;

/**
 * P00001—对称美学
 *
 * @author chenghu
 * @since 2025/8/8
 */
public class Od150SymmetryAesthetics {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t > 0) {
            int n = scanner.nextInt();
            long k = scanner.nextLong();
            String result = findChar(n, k);
            if (result.equals("R")) {
                System.out.println("red");
            } else {
                System.out.println("blue");
            }
            t--;
        }
    }

    public static String findChar(int n, long k) {
        if (n == 1) {
            return "R";
        }
        if (n == 2 && k == 0) {
            return "B";
        }
        if (n == 2 && k == 1) {
            return "R";
        }
        long count = (long) Math.pow(2, n - 2);
        if (k >= count) {
            return findChar(n - 1, k - count);
        } else {
            return reverse(findChar(n - 1, k));
        }
    }

    public static String reverse(String str) {
        if (str.equals("R")) {
            return "B";
        } else {
            return "R";
        }
    }

}

package od;


import java.util.Scanner;

/**
 *  P00308—员工派遣
 *
 * @author chenghu
 * @since 2025-08-23 15:38:45
 */
public class Od445EmployeeDispatch {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            long a = scanner.nextInt();
            long b = scanner.nextInt();
            long cntx = scanner.nextInt();
            long cnty = scanner.nextInt();
            // 答案在 1-- 最大值上面寻找
            long lcm = lcm(a, b);
            long maxRange = lcm * Math.max(cntx, cnty);
            long min = 1;
            long ans = 0;


            while (min <= maxRange) {
                long m = (maxRange - min) / 2 + min;
                if (f(m, a, b, cntx, cnty, lcm)) {
                    ans = m;
                    maxRange = m - 1;
                } else {
                    min = m + 1;
                }
            }
            System.out.println(ans);
        }
    }

    public static boolean f(long range, long a, long b, long cntx, long cnty, long lcm) {
        long at = range / a;
        long bt = range / b;
        long lcmt = range / lcm;
        // 给b分配的
        long atc = at - lcmt;
        // 给a分配的
        long btc = bt - lcmt;
        long can = range - lcmt - atc - btc;
        return (can >= ((cnty - atc < 0 ? 0 : cnty - atc) + (cntx - btc < 0 ? 0 : cntx - btc)));
    }

    public static long lcm(long a, long b) {
        return (long) a * b / gcd(a, b);
    }

    public static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

}

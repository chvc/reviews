package math;


/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025-08-12 12:49:09
 */
public class Lc878 {

    public int nthMagicalNumber(int n, int a, int b) {
        long ans = 0;
        long l = 1;
        long lcm = lcm(a, b);
        long r = (long) Math.min(a, b) * n;
        while (l <= r) {
            long m = (r + l) / 2;
            if (m / a + m / b - m / lcm >= n) {
                ans = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return (int) ans % 100000007;
    }

    public long gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public long lcm(int a, int b) {
        return (long) a * b / gcd(a, b);
    }

    public static void main(String[] args) {
        Lc878 lc878 = new Lc878();
        System.out.println(lc878.nthMagicalNumber(1000000000, 40000, 40000));
    }

}

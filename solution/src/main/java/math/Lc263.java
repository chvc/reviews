package math;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025/8/3
 */
public class Lc263 {
    public boolean isUgly(int n) {
        if (n == 0) {
            return false;
        }
        while (n % 2 == 0) {
            n = n / 2;
        }
        while (n % 3 == 0) {
            n = n / 3;
        }
        while (n % 5 == 0) {
            n = n / 5;
        }
        // 此时n应该是一个质数了

        return n == 1;
    }

    public static void main(String[] args) {
        System.out.println(new Lc263().isUgly(14));
    }
}

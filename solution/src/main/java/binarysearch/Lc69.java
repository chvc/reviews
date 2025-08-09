package binarysearch;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025/7/26
 */
public class Lc69 {


    public int mySqrt(int x) {
        // 牛顿迭代法
//        double xn = (double) x / 2;
//        // xn+1 = (xn+a/xn)/2
//        while (Math.abs(xn * xn - x) > 0.001) {
//            xn = (xn + x / xn) / 2;
//        }
//        return (int) Math.floor(xn);
        // 二分法
        int SQRT_INT_MAX = (int) Math.sqrt(Integer.MAX_VALUE);


        int left = 0;
        int right = Math.min(x, SQRT_INT_MAX) + 1;

        while (left + 1 < right) {
            int a = (left + right) / 2;
            int i = a * a;
            if (i > x) {
                right = a;
            } else {
                left = a;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        System.out.println(new Lc69().mySqrt(1));
    }

}

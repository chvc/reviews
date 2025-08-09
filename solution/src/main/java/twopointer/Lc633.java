package twopointer;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025/7/26
 */
public class Lc633 {

    public boolean judgeSquareSum(int c) {
        double l = 0;
        double sqrt = Math.sqrt(c);
        double r = Math.floor(sqrt);
        while (l <= r) {
            if (sqrt == Math.sqrt(l * l  + r * r)) {
                return true;
            } else if (sqrt < Math.sqrt(l * l  + r * r)) {
                r--;
            } else {
                l++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Lc633().judgeSquareSum(2147483600));
    }


}

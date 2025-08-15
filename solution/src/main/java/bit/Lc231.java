package bit;


/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025-08-15 00:56:49
 */
public class Lc231 {

    public boolean isPowerOfTwo(int n) {

        while (n % 2 == 0) {
            n = n >> 1;
        }
        if (n % 2 != 0) {
            return false;
        }
        return n == 0;
    }


    public static void main(String[] args) {
        Lc231 lc231 = new Lc231();
//        lc231.isPowerOfTwo(16);
        int x = 2 & 2 & 3;
        int y = 5 ^ 3;
        System.out.println(x);
        System.out.println(y);
        System.out.println(6 ^ 3);
    }
}

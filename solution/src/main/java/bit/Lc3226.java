package bit;


/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025-08-10 17:24:26
 */
public class Lc3226 {

    public int minChanges(int n, int k) {
        if (n == k) {
            return 0;
        }
        int base = 1;
        int cnt = 0;
        for (int i = 0; i < 32; i++) {
            int x = n & base;
            int y = k & base;
            if (x == 0 && y == 1) {
                return -1;
            }
            if (x == 1 && y == 0) {
                cnt++;
            }
            base = base << 1;
        }
        return cnt;
    }

    public static void main(String[] args) {
        Lc3226 lc3226 = new Lc3226();
        System.out.println(lc3226.minChanges(13, 4));
    }

}

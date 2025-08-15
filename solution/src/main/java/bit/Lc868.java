package bit;


/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025-08-13 16:07:27
 */
public class Lc868 {

    public int binaryGap(int n) {
        int base = 1;
        int r = -1;
        int l = -1;
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int x = n & base;
            if (x == base) {
                // 找到了1的位置
                if (r == -1) {
                    r = i;
                } else {
                    if (l == -1) {
                        l = i;
                        ans = Math.max(l - r, ans);
                    } else {
                        r = l;
                        l = i;
                        ans = Math.max(l - r, ans);
                    }
                }
            }
        }
        return ans;
    }

}

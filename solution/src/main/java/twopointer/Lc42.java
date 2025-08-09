package twopointer;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025/7/26
 */
public class Lc42 {

    public int trap(int[] height) {
        int[] pre_hi = new int[height.length];
        int[] suf_hi = new int[height.length];
        pre_hi[0] = height[0];
        int len = height.length - 1;
        suf_hi[len] = height[len];
        for (int i = 1; i < height.length; i++) {
            pre_hi[i] = Math.max(pre_hi[i - 1], height[i]);
        }
        for (int i = len - 1; i >= 0; i--) {
            suf_hi[i] = Math.max(suf_hi[i + 1], height[i]);
        }
        int sum = 0;
        for (int i = 0; i < height.length; i++) {
            int res = Math.min(suf_hi[i], pre_hi[i]) - height[i];
            if (res > 0) {
                sum = sum + res;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] trap = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(new Lc42().trap(trap));
    }
}

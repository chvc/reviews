package stackqueue;


/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025-09-08 12:56:05
 */
public class Lc85MaximalRectangle {

    static int MAXN = 201;

    static int[] stack = new int[MAXN];

    static int r;

    static int[] nums;

    static int m;

    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        m = matrix[0].length;
        // 加工数组
        nums = new int[m];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                nums[j] = matrix[i][j] == '0' ? 0 : nums[j] + matrix[i][j] - '0';
            }
            // 对 nums 做处理
            ans = Math.max(ans, largestRectangleArea());
        }
        return ans;
    }

    public int largestRectangleArea() {
        r = 0;
        int ans = 0;
        for (int i = 0; i < m; i++) {
            if (r == 0) {
                stack[r++] = i;
            } else {
                // 违背了 大压小 弹出栈顶元素
                while (r > 0 && nums[stack[r - 1]] >= nums[i]) {
                    int cur = stack[--r];
                    int l = r == 0 ? -1 : stack[r - 1];
                    ans = Math.max(ans, (i - l - 1) * nums[cur]);
                }
                stack[r++] = i;
            }
        }
        while (r > 0) {
            int cur = stack[--r];
            int l = r == 0 ? -1 : stack[r - 1];
            ans = Math.max(ans, (m - l - 1) * nums[cur]);
        }
        return ans;
    }

    public static void main(String[] args) {
        Lc85MaximalRectangle lc85MaximalRectangle = new Lc85MaximalRectangle();

        System.out.println(lc85MaximalRectangle.maximalRectangle(new char[][]{
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        }));
    }

}

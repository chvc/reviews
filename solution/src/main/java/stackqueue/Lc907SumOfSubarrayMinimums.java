package stackqueue;


/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025-09-09 01:25:16
 */
public class Lc907SumOfSubarrayMinimums {

    int MAXN = 30001;
    int MOD = (int) 1e9 + 7;

    int[] stack = new int[MAXN];

    public int sumSubarrayMins(int[] arr) {
        int r = 0;
        long ans = 0;
        for (int i = 0; i < arr.length; i++) {
            if (r == 0) {
                stack[r++] = i;
            } else {
                // 如果违反了大压小
                while (r > 0 && arr[stack[r - 1]] >= arr[i]) {
                    // 弹出
                    int cur = stack[--r];
                    int left = r > 0 ? stack[r - 1] : -1;
                    // right = i;
                    ans = (ans +((long) (cur - left) * (i - cur) * arr[cur])) % MOD;
                }
                stack[r++] = i;
            }
        }
        while (r > 0) {
            int cur = stack[--r];
            int left = r > 0 ? stack[r - 1] : -1;
            // right = i;
            ans = (ans + ((long) (cur - left) * (arr.length - cur) * arr[cur])) % MOD;
        }
        return (int) ans;
    }

    public static void main(String[] args) {
        Lc907SumOfSubarrayMinimums lc907SumOfSubarrayMinimums = new Lc907SumOfSubarrayMinimums();
        System.out.println(lc907SumOfSubarrayMinimums.sumSubarrayMins(new int[]{
                3, 1, 2, 4
        }));
    }

}

package slidewindow;


/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025-08-13 20:50:55
 */
public class Lc1343 {

    public int numOfSubarrays(int[] arr, int k, int threshold) {

        int sum = 0;
        int cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (i < k - 1) {
                continue;
            }
            // 统计结果
            if (sum >= threshold) {
                cnt++;
            }
            // 出窗口 移除元素
            sum -= arr[i - k + 1];
        }
        return cnt;
    }

}

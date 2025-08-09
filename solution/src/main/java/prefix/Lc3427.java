package prefix;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025/8/9
 */
public class Lc3427 {

    public int subarraySum(int[] nums) {
        int[] prefixSum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            int start = Math.max(0, i - nums[i]);
            int end = i;
            sum += prefixSum[end + 1] - prefixSum[start];
        }
        return sum;
    }

}

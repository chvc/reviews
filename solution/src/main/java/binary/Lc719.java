package binary;


import java.util.Arrays;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025-08-23 19:40:30
 */
public class Lc719 {

    public int smallestDistancePair(int[] nums, int k) {
        // 找范围
        int maxDistance = Integer.MIN_VALUE;
        Arrays.sort(nums);
        maxDistance = Math.max(nums[nums.length - 1] - nums[0], maxDistance);
        // 在 0...max上寻找答案
        int left = 0;
        int right = maxDistance;
        int ans = 0;
        while (left <= right) {
            int m = (right - left) / 2 + left;
            if (f(nums, m, k)) {
                ans = m;
                // 如果满足了 说明 要往左边移动
                right = m - 1;
            } else {
                left = m + 1;
            }
        }
        return ans;
    }

    // 距离不大于mid时满足的对数是否大于等于k
    public boolean f(int[] nums, int mid, int k) {
        int count = 0;

        for (int l = 0, r = 0; l < nums.length; l++) {
            while (r + 1 < nums.length && nums[r + 1] - nums[l] <= mid) {
                r++;
            }
            count += r - l;
        }

        return count >= k;
    }

    public static void main(String[] args) {
        Lc719 lc719 = new Lc719();
        System.out.println(lc719.smallestDistancePair(new int[]{
                38, 33, 57, 65, 13, 2, 86, 75, 4, 56
        }, 26));
    }

}

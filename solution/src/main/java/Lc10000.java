import java.util.Arrays;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025/7/30
 */
public class Lc10000 {


    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        long ans = 0;
        for (int j = 0; j < nums.length; j++) {
            // 注意要在 [0, j-1] 中二分，因为题目要求两个下标 i < j
            int target = upper - nums[j] + 1;
            int target1 = lower - nums[j];
            int r = lowerBound(nums, j, target);
            int l = lowerBound(nums, j, target1);
            ans += r - l;
        }
        return ans;
    }

    // 原理请看 https://www.bilibili.com/video/BV1AP41137w7/
    private int lowerBound(int[] nums, int right, int target) {
        int left = -1;
        while (left + 1 < right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return right;
    }

    public static void main(String[] args) {
        System.out.println(new Lc10000().countFairPairs(new int[]{
                0, 1, 7, 4, 4, 5
        }, 3, 6));
    }


}

package binarysearch;

import java.util.Arrays;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025/7/29
 */
public class Lc2563 {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        int res = 0;
        for (int j = 0; j < nums.length; j++) {
            // 0 1 4 4 5 7
            // nums[i] 大于等于 lower-nums[i]的第一个数 3
            // nums[i] 小于等于 upper-nums[i]的第一个数 6
            int lower_target = lower - nums[j];
            int upper_target = upper - nums[j];
            int l = lower(nums, j, lower_target);
            int r = lower2(nums, j, upper_target);
            res = res + (r - l);
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(new Lc2563().countFairPairs(new int[]{
                1, 7, 9, 2, 5
        }, 11, 11));
    }
    //

    public int lower(int[] nums, int r, int target) {
        // [l,r) 之间
        int l = 0;
        while (l < r) {
            int mid = (r - l) / 2 + l;
            if (nums[mid] >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public int lower2(int[] nums, int r, int target) {
        // [l,nums.length)
        int l = 0;
        while (l < r) {
            int mid = (r - l) / 2 + l;
            if (nums[mid] <= target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }

}

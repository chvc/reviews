package binarysearch;

import java.util.Arrays;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025/7/28
 */
public class Lc34 {

    public int[] searchRange(int[] nums, int target) {
        return null;
    }

    public int findFirst(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            // 取中间值
            int mid = (r - l) / 2 + l;
            if (nums[mid] >= target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return 0;
    }

    public int findLast(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            // 取中间值
            int mid = (r - l) / 2 + l;
            if (nums[mid] <= target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return 0;
    }

    public int upper(int[] nums, int target) {
        int l = 0;
        int r = nums.length;
        // 大于8的最小值
        while (l < r) {
            // 取中间值
            int mid = (r - l) / 2 + l;
            if (nums[mid] <= target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        if (l - 1 == -1) {
            return nums[l] == target ? l : -1;
        }
        return nums[l - 1] == target ? l - 1 : -1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(Arrays.toString(new Lc34().searchRange(nums, 2)));
    }
}

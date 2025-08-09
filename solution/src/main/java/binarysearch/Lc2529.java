package binarysearch;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025/7/28
 */
public class Lc2529 {

    public int maximumCount(int[] nums) {

        return Math.max(lower(nums), nums.length - upper(nums));
    }
    // 大于0的最小的那个数

    public static int upper(int[] nums) {
        int l = 0;
        int r = nums.length;
        while (l < r) {
            int mid = (r - l) / 2 + l;
            int midVal = nums[mid];
            if (midVal <= 0) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }

    public static int lower(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = (r - l) / 2 + l;
            int midVal = nums[mid];
            if (midVal >= 0) {
                r = mid - 1;
            } else {
                l = mid + 1  ;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        System.out.println(new Lc2529().maximumCount(new int[]{
                -3,-2,-1,0,0,1,2
        }));
    }

}

package slidewindow;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025/7/26
 */
public class Lc209 {

    public int minSubArrayLen(int target, int[] nums) {
        int l = 0;
        int r = -1;
        int res = nums.length+1;
        int sum = 0 ;
        while (l < nums.length) {
            if (r +1 < nums.length && sum < target) {
                r++;
                sum = sum + nums[r];
            } else {
                res = Math.min(res, r - l + 1);
                sum = sum - nums[l];
                l++;
            }

        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Lc209().minSubArrayLen(7, new int[]{
                2,3,1,2,4,3
        }));
    }

}

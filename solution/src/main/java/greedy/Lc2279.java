package greedy;


import java.util.Arrays;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025-08-14 22:08:06
 */
public class Lc2279 {

    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int[] nums = new int[capacity.length];
        for (int i = 0; i < capacity.length; i++) {
            nums[i] = capacity[i] - rocks[i];
        }
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count++;
            } else {
                if (additionalRocks < nums[i]) {
                    break;
                } else {
                    additionalRocks = additionalRocks - nums[i];
                    count++;
                }
            }
        }
        return count;
    }

}

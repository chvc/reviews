package prefix;


import java.awt.geom.GeneralPath;
import java.util.HashMap;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025-08-14 23:39:38
 */
public class Lc930 {

    public int numSubarraysWithSum(int[] nums, int goal) {
        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(0, 1);
        int sum = 0;
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            ans += map.getOrDefault(sum - goal, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return ans;
    }

}

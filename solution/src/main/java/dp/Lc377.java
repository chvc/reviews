package dp;


import java.util.ArrayList;
import java.util.List;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025-08-14 23:50:51
 */
public class Lc377 {

    List<List<Integer>> ans = new ArrayList<>();

    public int combinationSum4(int[] nums, int target) {
        int ans = dfs(nums, target);
        System.out.println(ans);
        return ans;
    }

    public int dfs(int[] nums, int target) {

        if (target == 0) {
            return 1;
        }
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= target) {
                ans += dfs(nums, target-nums[i]);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Lc377 lc377 = new Lc377();
        System.out.println(lc377.combinationSum4(new int[]{
                1, 2, 3
        }, 4));
    }

}

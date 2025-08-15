package backtrack;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025-08-10 21:55:48
 */
public class Lc47 {


    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) {
            return res;
        }
        boolean[] used = new boolean[nums.length];
        dfs(nums, 0, new ArrayList<>(), used);
        return res;
    }

    public void dfs(int[] nums, int j, List<Integer> list, boolean[] used) {

        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!used[i] && !set.contains(nums[i])) {
                set.add(nums[i]);
                list.add(nums[i]);
                used[i] = true;
                dfs(nums, j + 1, list, used);
                list.remove(list.size() - 1);
                used[i] = false;
            }
        }

    }

    public static void main(String[] args) {
        Lc47 lc47 = new Lc47();
        lc47.permute(new int[]{
                1, 1, 2
        });
    }

}

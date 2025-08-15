package backtrack;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025-08-11 22:26:41
 */
public class Lc39 {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        dfs(candidates, target, 0, new ArrayList<>());
        return res;
    }

    public void dfs(int[] candidates, int target, int i, List<Integer> pickList) {

        if (target == 0) {
            res.add(new ArrayList<>(pickList));
            return;
        }

        if (i == candidates.length || target < 0) {
            return;
        }
        // 不选i
        dfs(candidates, i + 1, target, pickList);
        // 选 i
        pickList.add(candidates[i]);
        dfs(candidates, i, target - candidates[i], pickList);
        pickList.remove(pickList.size() - 1);
        //
    }

    public static void main(String[] args) {
        Lc39 lc39 = new Lc39();
        System.out.println(lc39.combinationSum(new int[]{
                2, 3, 6, 7
        }, 7));
    }

}

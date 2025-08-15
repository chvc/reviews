package backtrack;


import java.util.ArrayList;
import java.util.List;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025-08-12 09:28:20
 */
public class Lc78 {

    List<List<Integer>> ans = new ArrayList<>();


    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0) {
            return ans;
        }
        dfs(nums, 0, 0, new int[nums.length]);
        return ans;
    }

    public void dfs(int[] nums, int i, int size, int[] path) {

        if (i == nums.length) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < size; j++) {
                list.add(path[j]);
            }
            ans.add(list);
            return;
        }

        // 不要当前元素
        dfs(nums, i + 1, size, path);
        //要当前元素
        path[size++] = nums[i];
        dfs(nums, i + 1, size, path);
    }


    public static void main(String[] args) {
        Lc78 lc78 = new Lc78();
        System.out.println(lc78.subsets(new int[]{
                1, 2, 3
        }));
    }

}

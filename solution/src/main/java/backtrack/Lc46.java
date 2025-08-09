package backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025/7/30
 */
public class Lc46 {
//    public List<List<Integer>> permute(int[] nums) {
//        List<List<Integer>> res = new ArrayList<>();
//        boolean[] used = new boolean[nums.length];
//        permute(nums, 0, new ArrayList<>(), res, used);
//        return res;
//    }
//
//    public void permute(int[] nums, int index, List<Integer> list, List<List<Integer>> res, boolean[] used) {
//        if (index == nums.length) {
//            System.out.printf("当前层数{%s},添加的结果是%s%n", index, list);
//            res.add(new ArrayList<>(list));
//            return;
//        }
//        for (int i = 0; i < nums.length; i++) {
//            if (!used[i]) {
//                list.add(nums[i]);
//                used[i] = true;
//                System.out.printf("进入递归前:当前层数{%s},正在处理索引%s,已添加的路径是%s%n", index, i, list);
//                permute(nums, index + 1, list, res, used);
//                System.out.printf("进入递归后:当前层数{%s},正在处理索引%s,已添加的路径是%s%n", index, i, list);
//                used[i] = false;
//                list.remove(list.size() - 1);
//                System.out.printf("数据清理后:当前层数{%s},正在处理索引%s,已添加的路径是%s%n", index, i, list);
//            }
//
//        }
//    }

    static List<List<Integer>> res = new ArrayList<>();

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
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                list.add(nums[i]);
                used[i] = true;
                dfs(nums, j + 1, list, used);
                list.remove(list.size() - 1);
                used[i] = false;
            }
        }

    }

    public static void main(String[] args) {
        System.out.println(new Lc46().permute(new int[]{
            0,1
        }));
    }


}

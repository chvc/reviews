package tree.binary;

import structure.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025/8/7
 */
public class Lc508 {

    Map<Integer, Integer> map = new HashMap<>();

    List<Integer> list = new ArrayList<>();

    public int[] findFrequentTreeSum(TreeNode root) {
        if (root == null) {
            return null;
        }
        dfs(root);

        // 2 --->  2
        List<List<Integer>> sortedGroups = list.stream()
                .collect(Collectors.groupingBy(Function.identity()))
                .values().stream()
                .sorted(Comparator.comparingInt((List<Integer> group) -> group.size()).reversed()
                        .thenComparing(group -> group.get(0)))
                .collect(Collectors.toList());
        List<Integer> res = new ArrayList<>();
        int size = 0;
        for (int i = 0; i < sortedGroups.size(); i++) {
            List<Integer> s = sortedGroups.get(i);
            if (i == 0) {
                size = s.size();
                res.add(s.get(0));
            } else {
                if (size == s.size()) {
                    res.add(s.get(0));
                }
            }
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int cur = root.val + dfs(root.left) + dfs(root.right);
        map.put(cur, map.getOrDefault(cur, 0) + 1);
        return cur;
    }

    public static void main(String[] args) {
        Lc508 lc508 = new Lc508();
        System.out.println(Arrays.toString(lc508.findFrequentTreeSum(TreeNode.createTree(new Integer[]{
                5, 14, null, 1
        }))));
    }


}

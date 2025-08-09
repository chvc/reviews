/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025/8/7
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

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
//        Main lc508 = new Main();
//        System.out.println(Arrays.toString(lc508.findFrequentTreeSum(new TreeNode().createTree(new Integer[]{
//                5, 14, null, 1
//        }))));

        Scanner scanner = new Scanner(System.in);
        String i = scanner.nextLine();
        System.out.println(i);
    }

   static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {
        }
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public    TreeNode createTree(Integer[] nums) {
            if (nums.length == 0) {
                return null;
            }
            TreeNode root = new TreeNode(nums[0]);
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            int index = 1;
            while (!queue.isEmpty() && index < nums.length) {
                TreeNode node = queue.poll();
                // 处理左子节点
                if (index < nums.length && nums[index] != null) {
                    node.left = new TreeNode(nums[index]);
                    queue.add(node.left);
                }
                index++;

                // 处理右子节点
                if (index < nums.length && nums[index] != null) {
                    node.right = new TreeNode(nums[index]);
                    queue.add(node.right);
                }
                index++;
            }
            return root;
        }


    }

}



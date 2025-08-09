package tree.binary;

import structure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025/8/7
 */
public class Lc1161 {

    public int maxLevelSum(TreeNode root) {

        if (root == null) {
            return 1;
        }
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        int level = 1;
        int max_sum_level = 1;
        int max_sum = root.val;
        while (!q.isEmpty()) {
            int size = q.size();
            int sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                int val = node.val;
                sum += val;
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            }
            if (sum > max_sum) {
                max_sum_level = level;
            } else if (max_sum == sum) {
                max_sum_level = Math.min(level, max_sum_level);
            }
            level++;
        }
        return max_sum_level;
    }

    public static void main(String[] args) {
        Lc1161 lc1161 = new Lc1161();
        System.out.println(lc1161.maxLevelSum(TreeNode.createTree(new Integer[]{
                989, null, 10250, 98693, -89388, null, null, null, -32127
        })));
    }

}

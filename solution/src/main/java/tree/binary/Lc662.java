package tree.binary;

import structure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025/8/7
 */
public class Lc662 {

   public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        root.val = 1;
        q.add(root);
        int max_val = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            int min_index = Integer.MAX_VALUE;
            int max_index = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                int index = node.val;
                min_index = Math.min(index, min_index);
                max_index = Math.max(index, max_index);
                if (node.left != null) {
                    node.left.val = 2 * index;
                    q.add(node.left);

                }
                if (node.right != null) {
                    node.right.val = 2 * index + 1;
                    q.add(node.right);
                }
            }
            max_val = Math.max(max_val, max_index - min_index + 1);
        }
        return max_val;
    }

    public static void main(String[] args) {
        Lc662 lc662 = new Lc662();
        System.out.println(lc662.widthOfBinaryTree(TreeNode.createTree(new Integer[]{
                1, 3, 2, 5, null, null, 9, 6, null, 7
        })));
    }

}

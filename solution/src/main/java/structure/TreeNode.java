package structure;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025/8/1
 */
public class TreeNode {


    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }


    public static void printTree(TreeNode tree) {
        if (tree == null) {
            return;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(tree);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                System.out.print(node.val + ", ");
                queue.add(node.left);
                queue.add(node.right);
            } else {
                System.out.print("null, ");
            }
        }
    }

    public static TreeNode createTree(Integer[] nums) {
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


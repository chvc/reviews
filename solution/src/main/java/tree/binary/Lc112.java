package tree.binary;

import structure.TreeNode;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025/8/5
 */
public class Lc112 {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        return dfs(root, targetSum);
    }

    public boolean dfs(TreeNode node, int sub) {
        if (node.left == null && node.right == null) {
            return node.val == sub;
        }
        if (node.left == null) {
            return dfs(node.right, sub - node.val);
        }
        if (node.right == null) {
            return dfs(node.left, sub - node.val);
        }
        return dfs(node.left, sub - node.val) || dfs(node.right, sub - node.val);
    }

    public static void main(String[] args) {
        Lc112 lc112 = new Lc112();
        System.out.println(lc112.hasPathSum(TreeNode.createTree(new Integer[]{
                1, 2
        }), 0));
    }

}

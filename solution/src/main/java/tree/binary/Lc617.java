package tree.binary;

import structure.TreeNode;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025/8/7
 */
public class Lc617 {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        TreeNode dfs = dfs(root1, root2);
        return dfs;
    }

    public TreeNode dfs(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return null;
        }
        if (root1 == null && root2 != null) {
            return new TreeNode(root2.val);
        }
        if (root1 != null && root2 == null) {
            TreeNode treeNode = new TreeNode(root1.val);
            return dfs(treeNode.left,null);
        }
        TreeNode treeNode = new TreeNode(root1.val + root2.val);
        treeNode.left = dfs(root1.left, root2.left);
        treeNode.right = dfs(root1.right, root2.right);
        return treeNode;
    }

    public static void main(String[] args) {
        Lc617 lc617 = new Lc617();
        System.out.println(lc617.mergeTrees(TreeNode.createTree(new Integer[]{
                1, 2, null, 3
        }), TreeNode.createTree(new Integer[]{
                1, null, 2, null, 3
        })));
    }


}

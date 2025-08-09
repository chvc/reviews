package tree.binary;

import structure.TreeNode;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025/8/7
 */
public class Lc110 {

    int ans = 0;

    public boolean isBalanced(TreeNode root) {
        dfs(root, 0);
        return ans < 1;
    }

    public int dfs(TreeNode root, int depth) {
        if (root == null) {
            return depth;
        }
        depth++;
        int left_depth = dfs(root.left, depth );
        int right_depth = dfs(root.right, depth );
        ans = Math.max(ans, Math.abs(left_depth - right_depth));
        return depth;
    }

    public static void main(String[] args) {
        Lc110 lc110 = new Lc110();
        System.out.println(lc110.isBalanced(TreeNode.createTree(new Integer[]{
                1, 2, 2, 3, 3, null, null, 4, 4
        })));
    }

}

package tree.binary;

import structure.TreeNode;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025/8/8
 */
public class Lc104 {

    int ans = 0;

    public int maxDepth(TreeNode root) {
        dfs(root, 0);
        return ans;
    }

    public void dfs(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        depth++;
        dfs(root.left, depth);
        dfs(root.right, depth);
        ans = Math.max(ans, depth);
    }

}

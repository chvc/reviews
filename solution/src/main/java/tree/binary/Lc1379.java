package tree.binary;

import structure.TreeNode;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025/8/7
 */
public class Lc1379 {

    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
       return dfs(cloned, target);
    }

    public  TreeNode dfs(TreeNode cloned, final TreeNode target) {
        if (cloned == null) {
            return null;
        }
        if (cloned.val == target.val) {
            return cloned;
        }
        dfs(cloned.left, target);
        dfs(cloned.right, target);
        return null;
    }

}

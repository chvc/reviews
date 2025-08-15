package tree;


import structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025-08-13 22:36:06
 */
public class Lc129 {

    int ans = 0;

    public int sumNumbers(TreeNode root) {
        dfs(root, new ArrayList<>());
        return ans;
    }

    public void dfs(TreeNode root, List<Integer> path) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        if (root.left == null && root.right == null) {
            int num = 0;
            for (int i = 0; i < path.size(); i++) {
                num = num * 10 + path.get(i);
            }
            ans += num;
        }
        // 左子树 或者右子树
        dfs(root.left, path);
        dfs(root.right, path);
        path.remove(path.size() - 1);
    }

}

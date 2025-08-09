package tree.binary;

import matrix.Lc56;
import structure.TreeNode;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025/8/8
 */
public class Lc563 {
    int ans = 0;

    public int findTilt(TreeNode root) {
        dfs(root);
        return ans;
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //
        int cur = root.val;
        int l = cur + dfs1(root.left);
        int r = cur + dfs2(root.right);
        ans += Math.abs((l - r));
        return cur;
    }

    public int dfs1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //
        int cur = root.val;
        int l = cur + dfs1(root.left);
        return l;
    }
    public int dfs2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //
        int cur = root.val;
        int r = cur + dfs2(root.right);
        return r;
    }


    public static void main(String[] args) {
        Lc563 lc563 = new Lc563();
        System.out.println(lc563.findTilt(TreeNode.createTree(new Integer[]{
                4, 2, 9, 3, 5, null, 7
        })));
    }
}

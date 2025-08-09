package tree.binary;

import structure.TreeNode;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025/8/7
 */
public class Lc671 {

    int min_val = Integer.MAX_VALUE;
    int second_val = Integer.MAX_VALUE;

    public int findSecondMinimumValue(TreeNode root) {
        dfs(root);
        return second_val == min_val ? -1 : second_val;
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        int val = root.val;
        if (val < min_val) {
            second_val = min_val;
            min_val = val;
        } else {
            if (second_val == min_val) {
                second_val = val;
            } else {
                if (val < second_val) {
                    second_val = val;
                }
            }
        }
        dfs(root.left);
        dfs(root.right);
    }

    public static void main(String[] args) {
        Lc671 lc671 = new Lc671();
        System.out.println(lc671.findSecondMinimumValue(TreeNode.createTree(new Integer[]{
                5, 8, 5
        })));
    }

}

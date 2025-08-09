package tree.bst;

import structure.TreeNode;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025/8/1
 */
public class Lc108 {

    public TreeNode sortedArrayToBST(int[] nums) {
        return buildNode(nums, 0, nums.length - 1);
    }

    public TreeNode buildNode(int[] nums, int l, int r) {
        if (l > r) {
            return null;
        }
        int mid = (r - l) / 2 + l;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = buildNode(nums, l, mid - 1);
        node.right = buildNode(nums, mid + 1, r);
        return node;
    }


    public static void main(String[] args) {
        TreeNode treeNode = new Lc108().sortedArrayToBST(new int[]{
                -10, -3, 0, 5, 9
        });
        TreeNode.printTree(treeNode);
    }

}

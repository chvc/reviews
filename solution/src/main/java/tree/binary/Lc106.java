package tree.binary;

import stackqueue.Lc1006;
import structure.TreeNode;

import java.util.Arrays;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025/8/4
 */
public class Lc106 {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || postorder.length == 0) {
            return null;
        }
        int rootValue = postorder[postorder.length - 1];
        int index = -1;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootValue) {
                index = i;
                break;
            }
        }
        TreeNode root = new TreeNode(rootValue);
        // 构建左子树和右子树
        root.left = buildTree(Arrays.copyOfRange(inorder, 0, index), Arrays.copyOfRange(postorder, 0, index));
        root.right = buildTree(Arrays.copyOfRange(inorder, index + 1, inorder.length - 1),
                Arrays.copyOfRange(postorder, index, postorder.length - 2));
        return root;
    }

    public static void main(String[] args) {
        Lc106 lc106 = new Lc106();
        System.out.println(lc106.buildTree(new int[]{
                9, 3, 15, 20, 7
        }, new int[]{
                9, 15, 7, 20, 3
        }));
    }
}

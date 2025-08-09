package tree.binary;

import structure.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025/8/3
 */
public class Lc105 {

    Map<Integer, Integer> indexMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] postorder) {
        //  [3,9,20,15,7] 根 一定是第一个元素

        //  [9,3,15,20,7]找到 根节点的位置 其左边就是左子树 右边就是右子树

        for (int i = 0; i < postorder.length; i++) {
            indexMap.put(postorder[i], i);
        }
        int n = preorder.length;
        return buildTree(preorder, postorder, 0, n - 1, 0, n - 1);
    }

    public TreeNode buildTree(int[] preorder, int[] postorder, int preL, int preR, int inl, int inR) {
        if (preL >= preorder.length) {
            return null;
        }
        if (preL > preR) {
            return null;
        }
        int rootVal = preorder[preL];
        TreeNode rootNode = new TreeNode(rootVal);
        if (preL == preR) {
            return rootNode;
        }
        //
        Integer postOrderIndex = indexMap.get(rootVal);
        rootNode.left = buildTree(preorder, postorder, preL + 1, postOrderIndex - inl + preL, inl, postOrderIndex - 1);
        rootNode.right = buildTree(preorder, postorder, postOrderIndex - inl + preL + 1, preR, postOrderIndex + 1, inR);
        return rootNode;
    }

    public static void main(String[] args) {
        Lc105 lc105 = new Lc105();
        TreeNode.printTree(lc105.buildTree(new int[]{
                1, 2
        }, new int[]{
                1, 2
        }));
    }


}

package bst;

import structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025/8/1
 */
public class Lc98 {

    List<Integer> list = new ArrayList<>();
    int index = 0;

    public boolean isValidBST(TreeNode root) {
        return midOrder(root);
    }


    public boolean midOrder(TreeNode node) {
        if (node == null) {
            return true;
        }
        midOrder(node.left);
        if (index == 0) {
            list.add(node.val);
        } else {
            if (list.get(index - 1).compareTo(node.val) >= 0) {
                return false;
            }
        }
        midOrder(node.right);
        return true;
    }

}

package tree.binary;

import structure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025/8/2
 */
public class Lc199 {


    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            Integer val = null;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node != null) {
                    queue.add(node.left);
                    queue.add(node.right);
                    val = node.val;
                }
            }
            if (val != null) {
                list.add(val);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(new Lc199().rightSideView(TreeNode.createTree(new Integer[]{
                1, 2, 3, 4, null, null, null, 5
        })));
    }

}

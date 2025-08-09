package tree.binary;

import structure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025/8/2
 */
public class Lc102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        // 层序遍历
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> res = new ArrayList<>();
            int size = queue.size();
            // 添加左 添加右
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node != null) {
                    res.add(node.val);
                    queue.add(node.left);
                    queue.add(node.right);
                }
            }
            if (!res.isEmpty()){
                list.add(res);
            }

        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(new Lc102().levelOrder(TreeNode.createTree(new Integer[]{
                3, 9, 20, 21, 12, 15, 7
        })));
    }


}

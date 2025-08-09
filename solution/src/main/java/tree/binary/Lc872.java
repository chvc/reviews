package tree.binary;


import structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025/8/3
 */
public class Lc872 {

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List res1 = leafOrder(root1);
        List res2 = leafOrder(root2);
        if (res1.size() != res2.size()) {
            return false;
        }
        int index = 0;
        while (index < res1.size()) {
            if (res1.get(index) != res2.get(index)) {
                return false;
            }
            index++;
        }
        return true;
    }

    public List<Integer> leafOrder(TreeNode tree) {
        List<Integer> res = new ArrayList<Integer>();
        leafOrder(tree, res);
        return res;
    }

    public List<Integer> leafOrder(TreeNode tree, List<Integer> res) {
        if (tree == null) {
            return res;
        }
        if (tree.left == null && tree.right == null) {
            res.add(tree.val);
        }
        leafOrder(tree.left, res);
        leafOrder(tree.right, res);
        return res;
    }

    public static void main(String[] args) {
        Lc872 lc872 = new Lc872();
        lc872.leafSimilar(TreeNode.createTree(new Integer[]{
                1, 2, 200
        }), TreeNode.createTree(new Integer[]{
                1, 2, 200
        }));
    }
}

package od;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025-09-08 17:14:30
 */
public class Od75ABinaryTreeLevelOrderTraversal {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] orders = s.split(" ");
        String postOrder = orders[0];
        String middleOrder = orders[1];
        TreeNode recover = recover(postOrder, middleOrder);
        levelTraversal(recover);
    }

    public static TreeNode recover(String post, String middle) {

        if (post.isEmpty() || middle.isEmpty()) {
            return null;
        }
        int n = post.length();
        // 找到根节点
        char root = post.charAt(post.length() - 1);
        int index = -1;
        for (int i = 0; i < middle.length(); i++) {
            if (middle.charAt(i) == root) {
                index = i;
                break;
            }
        }
        TreeNode treeNode = new TreeNode(root);
        // 找到左节点
        treeNode.left = recover(post.substring(0, index), middle.substring(0, index));
        treeNode.right = recover(post.substring(index, n - 1), middle.substring(index + 1, n));
        return treeNode;
    }

    public static void levelTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode[] q = new TreeNode[1000];
        int l = 0;
        int r = 0;
        q[r++] = root;
        while (r > l) {
            for (int i = l; i < r; i++) {
                TreeNode node = q[l++];
                System.out.print(node.val);
                if (node.left != null) {
                    q[r++] = node.left;
                }
                if (node.right != null) {
                    q[r++] = node.right;
                }
            }
        }
    }

    static class TreeNode {
        Character val;
        TreeNode left;
        TreeNode right;

        public TreeNode(Character c) {
            this.val = c;
        }
    }

}

package tree.binary;

import structure.TreeNode;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025/8/7
 */
public class Lc988 {

    String ans = "";

    public String smallestFromLeaf(TreeNode root) {
        dfs(root, new StringBuffer());
        return ans;
    }

    public void dfs(TreeNode node, StringBuffer sb) {
        if (node == null) {
            return;
        }
        int val = node.val;
        char c = (char) (val + 'a');
        sb.append(c);
        // 左右子树均为空 说明是叶子节点 此时计算结果
        if (node.left == null && node.right == null) {
            // 说明是初始化的 需要初始化结果
            if (ans.isEmpty()) {
                StringBuilder temp = new StringBuilder(sb.toString());
                ans = temp.reverse().toString();
            } else {
                // 需要比较字典大小
                StringBuilder temp = new StringBuilder(sb.toString());
                String str = temp.reverse().toString();
                if (str.compareTo(ans) < 0) {
                    ans = str;
                }
            }
        }
        // 否则就要看左右两边的结果了

        dfs(node.left, sb);
        dfs(node.right, sb);
        sb.deleteCharAt(sb.length()-1);
    }

    public static void main(String[] args) {
        Lc988 lc988 = new Lc988();
        System.out.println(lc988.smallestFromLeaf(TreeNode.createTree(new Integer[]{
                25,1,3,1,3,0,2
        })));

    }

}

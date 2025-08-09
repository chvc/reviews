package tree.binary;

import structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025/8/9
 */
public class Lc257 {

    List<String> paths = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        dfs(root,new ArrayList<>());
        return paths;
    }

    public void dfs(TreeNode root, List<String> path) {
        if (root == null) {
            return;
        }
        path.add(String.valueOf(root.val));
        if (root.left == null && root.right == null) {
            // 收集结果
            String ans = String.join("->", new ArrayList<>(path));
            paths.add(ans);
            path.remove(path.size() - 1);
            return;
        }
        // 如果是中间路径 说明要继续遍历

        dfs(root.left, path);
        dfs(root.right,path);
        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {
        Lc257 lc257 = new Lc257();
        System.out.println(lc257.binaryTreePaths(TreeNode.createTree(new Integer[]{
                1, 2, 3, null, 5
        })));
    }

}

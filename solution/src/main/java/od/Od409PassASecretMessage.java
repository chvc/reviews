package od;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * P00164—悄悄话 / 传递悄悄话
 *
 * @author chenghu
 * @since 2025-09-23 23:15:38
 */
public class Od409PassASecretMessage {

    static int len;

    static int[] nums;

    static int res = Integer.MIN_VALUE;


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] input = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] xs = new int[input.length + 1];
        System.arraycopy(input, 0, xs, 1, input.length);
        System.out.println(dfs3(1, xs, 0));
    }

    public static void dfs2(int idx, int sum) {
        // 超出数组或空节点直接返回
        if (idx >= len || nums[idx] == -1) return;

        sum += nums[idx];

        int left = 2 * idx + 1;
        int right = 2 * idx + 2;

        // 如果是叶子节点（左右子节点都不存在或为空）
        if ((left >= len || nums[left] == -1) && (right >= len || nums[right] == -1)) {
            res = Math.max(res, sum);
            return;
        }

        // 递归遍历左右子树
        dfs(left, sum);
        dfs(right, sum);
    }

    public static void dfs(int x, int sum) {
        if (x >= len) {
            return;
        }
        sum += nums[x];
        // 如果是叶子节点 那么就结算结果 否则就加入
        if (isLeaf(x)) {
            res = Math.max(res, sum);
        }
        dfs(2 * x + 1, sum);
        dfs(2 * x + 2, sum);
    }

    public static boolean isLeaf(int x) {
        // 左子树或者右子树的索引都不存在 或者值都为-1
        int left = x * 2 + 1;
        int right = x * 2 + 2;
        if (left >= len || right >= len) {
            return true;
        }
        return nums[left] == -1 && nums[right] == -1;
    }

    private static int dfs3(int index, int[] xs, int sum) {
        if (index >= xs.length || xs[index] == -1) {
            return sum;
        }
        int left = dfs3(index * 2, xs, sum + xs[index]);
        int right = dfs3(index * 2 + 1, xs, sum + xs[index]);
        return Math.max(left, right);
    }

}

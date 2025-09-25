package od;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * #P00089—构造数列
 *
 * @author chenghu
 * @since 2025-09-23 22:43:16
 */
public class Od89ASerialNum {

    /**
     * 小明在做构造数列的题目，题目要求数列中第一个数为n，且数列后面的每一个数字都不能大于前一个数字的一半，数列的元素都是正整数，请问在给定n的情况下，最多能构造多少合法且不同的数列？ 输入描述 输入一个n 备注 1 <= n< 10000 输出描述 输出可以构造的序列个数
     * 示例1：
     * 输入：
     * 7
     * 输出：
     * 6
     * 说明：
     * 可以构成 [7], [7,3],[7,2],[7,1],[7,3,1],[7,2,1]
     * 示例2：
     * 输入：
     * 5
     * 输出：
     * 4
     * 说明：
     * 可以构成 [5],[5,2],[5,1],[5,2,1]
     *
     * @param args
     */

    static int[] memo;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        memo = new int[n + 1];
        memo[0] = 1;
        dp(n);
        System.out.println(memo[n]);
    }

    public static int dp(int x) {
        if (memo[x] != 0) {
            return memo[x];
        }
        int m = x / 2;
        int ans = 0;
        for (int i = 0; i <= m; i++) {
            ans += dp(i);
        }
        memo[x] = ans;
        return ans;
    }

    public static void dfs(int x, List<Integer> path, Set<List<Integer>> set) {
        if (x == 0) {
            set.add(path);
            return;
        }
        path.add(x);
        int m = x / 2;
        for (int i = 0; i <= m; i++) {
            dfs(i, path, set);
        }
        path.remove(path.size() - 1);
    }

}

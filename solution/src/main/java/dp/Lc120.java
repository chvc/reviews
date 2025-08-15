package dp;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025-08-10 19:14:32
 */
public class Lc120 {

    int[][] memo;

    public int minimumTotal(List<List<Integer>> triangle) {
        memo = new int[triangle.size()][triangle.size() + 1];
        for (int i = 0; i < memo.length; i++) {
            Arrays.fill(memo[i], Integer.MAX_VALUE);
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < triangle.size(); i++) {
            List<Integer> nums = triangle.get(i);
            for (int j = 0; j < nums.size(); j++) {
                int ans = f(i, j, triangle);
                if (i == triangle.size() - 1) {
                    res = Math.min(res, ans);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Lc120 lc120 = new Lc120();
        List<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.asList(-1));
        list.add(Arrays.asList(2, 3));
        list.add(Arrays.asList(1, -1, -3));
//        list.add(Arrays.asList(4, 1, 8, 3));
        System.out.println(lc120.minimumTotal(list));
    }

    public int f(int i, int j, List<List<Integer>> triangle) {
        if (i == 0 && j == 0) {
            memo[i][j] = triangle.get(0).get(0);
            return memo[i][j];
        }
        if (i == 1 && j == 0) {
            return triangle.get(1).get(0) + memo[0][0];
        }
        if (i == 1 && j == 1) {
            return triangle.get(1).get(1) + memo[0][0];
        }
        if (memo[i][j] != Integer.MAX_VALUE) {
            return memo[i][j];
        }
        if (j == 0) {
            memo[i][j] = f(i - 1, 0, triangle) + triangle.get(i).get(j);
            return memo[i][j];
        }
        if (j == triangle.get(i).size() - 1) {
            memo[i][j] = f(i - 1, j - 1, triangle) + triangle.get(i).get(j);
            return memo[i][j];
        }
        memo[i][j] = Math.min(f(i - 1, j - 1, triangle), f(i - 1, j, triangle)) + triangle.get(i).get(j);
        return memo[i][j];
    }


}

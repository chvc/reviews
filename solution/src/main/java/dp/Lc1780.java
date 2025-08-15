package dp;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025-08-14 18:20:16
 */
public class Lc1780 {

    boolean answer = false;

    public boolean checkPowersOfThree(int n) {
        int x = 1;
        List<Integer> nums = new ArrayList<>();
        while (x <= n) {
            nums.add(x);
            x = x * 3;
        }
        dfs(nums, 0, 0, n);
        return answer;
    }

    public void dfs(List<Integer> nums, int i, int sum, int n) {
        if (sum == n) {
            answer = true;
            return;
        }
        if (i == nums.size()) {
            return;
        }
        if (sum > n) {
            return;
        }
        dfs(nums, i + 1, sum, n);
        // 选当前的
        sum += nums.get(i);
        dfs(nums, i + 1, sum, n);
        // 撤回
    }


    public static void main(String[] args) {
        Lc1780 lc1780 = new Lc1780();
        System.out.println(lc1780.checkPowersOfThree(12));
    }

}

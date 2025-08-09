import java.util.HashMap;
import java.util.Map;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025/8/9
 */
public class Lc2815 {

    Map<Integer, Integer> map = new HashMap<>();
    int ans = -1;

    public int maxSum(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            int n = maxNumber(nums[i]);
            // 如果存在
            if (map.containsKey(n)) {
                Integer index = map.get(n);
                int m = nums[index];
                ans = Math.max(ans, nums[index] + nums[i]);
                map.put(n, m > nums[i] ? index : i);
            } else {
                map.put(n, i);
            }
        }
        return ans;
    }

    public int maxNumber(int n) {
        int ans = 0;
        while (n != 0) {
            int x = n % 10;
            n = n / 10;
            ans = Math.max(x, ans);
        }
        return ans;
    }

    public static void main(String[] args) {
        Lc2815 lc2815 = new Lc2815();
        System.out.println(lc2815.maxSum(new int[]{
                2536, 1613, 3366, 162
        }));
    }

}

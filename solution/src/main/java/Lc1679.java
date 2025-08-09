import java.util.HashMap;
import java.util.Map;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025/8/9
 */
public class Lc1679 {

    Map<Integer, Integer> map = new HashMap<>();
    int cnt = 0;

    public int maxOperations(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(k - nums[i])) {
                // 找出了数据 将数据删除掉
                if (map.get(k - nums[i]) >= 1) {
                    cnt++;
                    map.put(k - nums[i], map.get(k - nums[i]) - 1);
                } else {
                    map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
                }
            } else {

                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Lc1679 lc1679 = new Lc1679();
        System.out.println(lc1679.maxOperations(new int[]{
                2, 5, 4, 4, 1, 3, 4, 4, 1, 4, 4, 1, 2, 1, 2, 2, 3, 2, 4, 2
        }, 3));
    }
}

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025/8/8
 */
public class Lc2441 {

    Map<Integer, Integer> map = new HashMap<>();

    public int findMaxK(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i] * -1)) {
                return Math.abs(map.get(nums[i] * -1));
            }
            map.put(nums[i], i);
        }
        return -1;
    }


    public static void main(String[] args) {
        Lc2441 lc2441 = new Lc2441();
        System.out.println(lc2441.findMaxK(new int[]{
                -1, 2, -3, 3
        }));
    }
}

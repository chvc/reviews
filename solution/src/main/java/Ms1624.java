import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025/8/9
 */
public class Ms1624 {

    Map<Integer, Integer> map = new HashMap<Integer, Integer>();

    List<List<Integer>> res = new ArrayList<>();

    List<Integer> tmp = new ArrayList<>();

    public List<List<Integer>> pairSums(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {

            // 如果可以找得到的话 就是一组结果了
            if (map.getOrDefault(target - nums[i], 0) >= 1) {
                List<Integer> tmp = new ArrayList<>();
                int cnt = map.get(target - nums[i]);
                tmp.add(target - nums[i]);
                tmp.add(nums[i]);
                res.add(tmp);
                map.put(target - nums[i], cnt - 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Ms1624 ms1624 = new Ms1624();
        System.out.println(ms1624.pairSums(new int[]{
                6, 1, 7, 6, 5, 1, 0, 0, 5, -1
        }, 6));
    }

}

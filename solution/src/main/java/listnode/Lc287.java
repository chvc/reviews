package listnode;

import java.util.HashSet;
import java.util.Set;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025/8/8
 */
public class Lc287 {

    Set<Integer> set = new HashSet<>();

    public int findDuplicate(int[] nums) {
        int n = 0;
        while (true) {
            n = f(n, nums);
            if (set.contains(n)) {
                return n;
            }
        }
    }

    public int f(int n, int[] nums) {
        set.add(n);
        return nums[n];
    }

    public static void main(String[] args) {
        Lc287 lc287 = new Lc287();
        System.out.println(lc287.findDuplicate(new int[]{
                1, 3, 4, 2, 2
        }));
    }


}

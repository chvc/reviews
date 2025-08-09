package prefix;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025/8/9
 */
public class Lc303 {

    static class NumArray {

        List<Integer> prefixSum = new ArrayList<>();

        public NumArray(int[] nums) {
            int sum = 0;
            prefixSum.add(0);
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
                prefixSum.add(sum);
            }
        }

        public int sumRange(int left, int right) {
            return prefixSum.get(right + 1) - prefixSum.get(left);
        }
    }

    public static void main(String[] args) {
        Lc303 lc303 = new Lc303();
        NumArray numArray = new NumArray(new int[]{
                -2, 0, 3, -5, 2, -1
        });
        System.out.println(numArray.sumRange(0, 2));
        System.out.println(numArray.sumRange(0, 5));
        System.out.println(numArray.sumRange(2, 5));
        System.out.println(numArray.prefixSum);
    }

}

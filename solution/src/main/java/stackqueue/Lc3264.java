package stackqueue;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025/8/3
 */
public class Lc3264 {

    public int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for (int num : nums) {
            pq.add(num);
        }

        for (int i = 0; i < k; i++) {
            int number = pq.poll();
            // 最小值
            int newValue = number * multiplier;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] == number) {
                    nums[j] = newValue;
                    break;
                }
            }
            pq.add(newValue);
        }
        return nums;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Lc3264().getFinalState(new int[]{
                2, 1, 3, 5, 6
        }, 5, 2)));
    }

}

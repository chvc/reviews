package stackqueue;


import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025-08-13 14:01:52
 */
public class Lc215 {

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < nums.length; i++) {
            pq.add(nums[i]);
        }
        for (int i = 0; i < k-1; i++) {
            pq.poll();
        }
        return pq.peek();
    }

}

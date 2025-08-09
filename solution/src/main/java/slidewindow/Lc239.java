package slidewindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025/7/27
 */
public class Lc239 {

    Deque<Integer> dq = new LinkedList<>();

    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            if (dq.isEmpty()) {
                dq.addLast(i);
            } else {
                int num = nums[i];
                while (!dq.isEmpty() && nums[dq.getLast()] <= num) {
                    dq.removeLast();
                }
                dq.addLast(i);
            }
            if (i < k - 1) {
                continue;
            }
            // 更新结果
            Integer index = dq.getFirst();
            int j = i - k + 1;
            res[j] = nums[index];
            // 出队列
            if (j == index) {
                dq.removeFirst();
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Lc239().maxSlidingWindow(new int[]{
                1, 3, -1, -3, 5, 3, 6, 7
        }, 3)));
        List<Integer> res = new ArrayList<>();

    }

}

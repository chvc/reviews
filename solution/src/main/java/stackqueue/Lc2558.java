package stackqueue;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025/8/3
 */
public class Lc2558 {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < gifts.length; i++) {
            pq.add((long)gifts[i]);
        }
        for (int i = 0; i < k; i++) {
            Long num = pq.poll();
            num = (long) Math.sqrt(num);
            pq.add(num);
        }
        Long sum = pq.stream().reduce(Long::sum).get();
        return sum;
    }
}

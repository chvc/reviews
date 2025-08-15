package hash;


import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025-08-13 17:07:52
 */
public class Lc3412 {
    Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();

    public long calculateScore(String s) {
        char[] arr = s.toCharArray();
        long ans = 0;
        for (int i = 0; i < arr.length; i++) {
            int key = arr[i] - 'a';
            if (map.containsKey(key)) {
                // 如果找到了 就找最近的下标
                PriorityQueue<Integer> pq = map.get(key);
                if (pq.isEmpty()) {
                    PriorityQueue<Integer> q = map.getOrDefault(25 - key, new PriorityQueue<>(Comparator.reverseOrder()));
                    q.add(i);
                    map.put(25 - key, q);
                } else {
                    Integer index = pq.poll();
                    ans += i - index;
                }
            } else {
                PriorityQueue<Integer> pq = map.getOrDefault(25 - key, new PriorityQueue<>(Comparator.reverseOrder()));
                pq.add(i);
                map.put(25 - key, pq);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Lc3412 lc3412 = new Lc3412();
        System.out.println(lc3412.calculateScore("grhshyssy"));
    }

}

package math;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025/8/3
 */
public class Lc264 {

    public int nthUglyNumber(int n) {
        if (n == 1) {
            return 1;
        }
        long[] answer = new long[n];
        PriorityQueue<Long> pq = new PriorityQueue<>();
        pq.add(1L);
        for (int i = 0; i < n; i++) {
            Long poll = pq.poll();
            if (poll == 1) {
                pq.add(poll * 2);
                pq.add(poll * 3);
                pq.add(poll * 5);
            } else {
                if (poll % 2 == 0) {
                    pq.add(poll * 2);
                    pq.add(poll * 3);
                    pq.add(poll * 5);
                } else if (poll % 3 == 0) {
                    pq.add(poll * 3);
                    pq.add(poll * 5);
                } else if (poll % 5 == 0) {
                    pq.add(poll * 5);
                }
            }
            // 只要整除2 就 *2 *3 *5 加进去

            answer[i] = poll;
        }

        return (int) answer[n - 1];
    }


    public boolean isUgly(int n) {
        if (n == 0) {
            return false;
        }
        while (n % 2 == 0) {
            n = n / 2;
        }
        while (n % 3 == 0) {
            n = n / 3;
        }
        while (n % 5 == 0) {
            n = n / 5;
        }
        // 此时n应该是一个质数了

        return n == 1;
    }

    public static void main(String[] args) {
        System.out.println(new Lc264().nthUglyNumber(1407));
//        System.out.println(6 % 2);
    }
}

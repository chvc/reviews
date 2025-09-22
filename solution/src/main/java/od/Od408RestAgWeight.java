package od;


import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * P00305—剩余银饰的重量
 *
 * @author chenghu
 * @since 2025-09-14 12:12:08
 */
public class Od408RestAgWeight {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // 加入到堆中
        PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < n; i++) {
            heap.add(sc.nextInt());
        }
        while (heap.size() >= 3) {
            Integer z = heap.poll();
            Integer y = heap.poll();
            Integer x = heap.poll();
            if (Objects.equals(z, y) && Objects.equals(y, x)) {

            } else if (Objects.equals(x, y) && !Objects.equals(y, z)) {
                heap.add(z - y);
            } else if (!Objects.equals(x, y) && Objects.equals(y, z)) {
                heap.add(y - x);
            } else if (!Objects.equals(x, y) && !Objects.equals(y, z)) {
                heap.add(Math.abs((y-x) - (z - y)));
            }
        }
        if (!heap.isEmpty()) {
            Integer x = heap.poll();
            System.out.println(x);
        } else {
            System.out.println(0);
        }
    }
}

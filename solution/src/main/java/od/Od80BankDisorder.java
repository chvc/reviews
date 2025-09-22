package od;


import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * P00443—银行插队 / 业务优先级
 *
 * @author chenghu
 * @since 2025-09-14 11:52:07
 */
public class Od80BankDisorder {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        PriorityQueue<int[]> heap = new PriorityQueue<>((o1, o2) -> {
            if (o1[1] != o2[1]) {
                return o1[1] - o2[1];
            }
            return o1[2] - o2[2];
        });
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            if (s.startsWith("p")) {
                if (!heap.isEmpty()) {
                    System.out.println(heap.poll()[0]);
                }
            }
            if (s.startsWith("a")) {
                String[] split = s.split(" ");
                int x = Integer.parseInt(split[2]);
                if (x > 5 || x < 1) {
                    continue;
                }
                int id = Integer.parseInt(split[1]);
                heap.add(new int[]{
                        id, x, i
                });
            }
        }
    }
}

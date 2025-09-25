package od;


import java.util.Arrays;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * #P00274—预订酒店
 *
 * @author chenghu
 * @since 2025-09-25 21:54:20
 */
public class Od97BookingHotel {

    static int n;
    static int k;
    static int x;
    static Integer[] nums;
    static Integer[] res;


    public static void main(String[] args) {
        in();
        // f1();
        f2();
        out();
    }

    public static void in() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        x = sc.nextInt();
        nums = new Integer[n];
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            nums[i] = num;
        }
        res = new Integer[k];
    }

    public static void out() {
        System.out.println(Arrays.stream(res).map(String::valueOf).collect(Collectors.joining(" ")));
    }

    // 堆
    public static void f1() {
        PriorityQueue<int[]> heap = new PriorityQueue<>((o1, o2) -> {
            if (o1[1] != o2[1]) {
                return o1[1] - o2[1];
            }
            return o1[2] - o2[2];
        });
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            heap.add(new int[]{
                    i, Math.abs(num - x), num
            });
        }
        for (int i = 0; i < k; i++) {
            int[] poll = heap.poll();
            res[i] = poll[2];
        }
        Arrays.sort(res);
    }

    // 自定义排序
    public static void f2() {
        Arrays.sort(nums, (a, b) -> {
            int aa = Math.abs(a - x);
            int ba = Math.abs(b - x);
            if (aa != ba) {
                return aa - ba;
            }
            return a - b;
        });
        res = Arrays.copyOfRange(nums, 0, k);
        Arrays.sort(res);
    }


}

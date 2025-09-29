package od;


import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * #P00106—最短木板长度
 *
 * @author chenghu
 * @since 2025-09-27 19:55:36
 */
public class Od137MinLengthBoard {

    /**
     * 小明有 n 块木板，第 i ( 1 ≤ i ≤ n ) 块木板长度为 ai。
     * 小明买了一块长度为 m 的木料，这块木料可以切割成任意块，
     * 拼接到已有的木板上，用来加长木板。
     * 小明想让最短的木板尽量长。
     * 请问小明加长木板后，最短木板的长度可以为多少？
     * <p>
     * 输入描述
     * 输入的第一行包含两个正整数，n(1≤n≤10^3),m(1≤m≤10^6)
     * n表示木板数，m表示木板长度。输入的第二行包含n个正整数，a1,a2,...an(1≤ai≤10^6)。
     * 输出描述
     * 输出的唯一一行包含一个正整数，表示加长木板后，最短木板的长度最大可以为多少？
     * <p>
     * 示例一：
     * 输入：
     * <p>
     * 5 3
     * 4 5 3 5 5
     * 输出：
     * <p>
     * 5
     * <p>
     * 说明：
     * 给第1块木板长度增加1，给第3块木板长度增加2后，
     * 这5块木板长度变为[5,5,5,5,5]，最短的木板的长度最大为5。
     * <p>
     * 示例二：
     * 输入：
     * <p>
     * 5 2
     * 4 5 3 5 5
     * 输出：
     * <p>
     * 4
     * <p>
     * 给第3块木板长度增加1后，
     * 这5块木板长度变为[4,5,4,5,5]，剩余的木料长度为1。此时剩余木料无论给哪块木板加长，最短木料的长度都为4。
     *
     * @param args
     */


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.println(f2(nums, m));
    }

    public static int f(int[] nums, int m) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            heap.add(nums[i]);
        }
        for (int i = 0; i < m; i++) {
            Integer poll = heap.poll();
            heap.add(poll + 1);
        }
        return heap.peek();
    }

    public static int f2(int[] nums, int m) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            min = Math.min(x, min);
            max = Math.max(x, max);
        }
        max = m + max;
        int ans = min;
        while (min <= max) {
            int mid = (min + max) / 2;
            // 已经合格了 看一下能不能更大
            if (ok(nums, m, mid)) {
                ans = mid;
                min = mid + 1;
            } else {
                // 不合格
                max = mid - 1;
            }
        }
        return ans;
    }

    public static boolean ok(int[] nums, int m, int mid) {
        int increase = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < mid) {
                increase += mid - nums[i];
            }
        }
        return increase <= m;
    }


}



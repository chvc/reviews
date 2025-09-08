package od;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * #P00314—灰度图存储
 *
 * @author chenghu
 * @since 2025-09-08 14:35:54
 */
public class Od461GrayscaleImageStatistics {

    static int MAXN = 10000;
    static int[] gray = new int[MAXN];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<Integer> nums = new ArrayList<>();
        while (nums.size() < m * n) {
            int v = sc.nextInt();
            int num = sc.nextInt();
            for (int i = 0; i < num; i++) {
                nums.add(v);
            }
        }
        int r = sc.nextInt();
        int c = sc.nextInt();
        System.out.println(nums.get(r*m+c-1));
    }

}

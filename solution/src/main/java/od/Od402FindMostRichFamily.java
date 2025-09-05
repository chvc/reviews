package od;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * P00192—最富裕的小家庭
 *
 * @author chenghu
 * @since 2025-09-05 06:04:53
 */
public class Od402FindMostRichFamily {


    static int n;
    static int[] nums;

    static List<List<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        nums = new int[n + 1];
        for (int i = 0; i < n; i++) {
            nums[i + 1] = sc.nextInt();
        }
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            int p = sc.nextInt();
            int c = sc.nextInt();
            graph.get(p).add(c);
        }
        // 建图建立完了
        long ans = 0;
        for (int i = 1; i < graph.size(); i++) {
            List<Integer> children = graph.get(i);
            long sum = nums[i];
            for (int j = 0; j < children.size(); j++) {
                sum += nums[children.get(j)];
            }
            ans = Math.max(ans, sum);
        }
        System.out.println(ans);
    }

}

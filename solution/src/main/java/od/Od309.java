package od;


import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025-08-26 03:07:15
 */
public class Od309 {

    static int[] nums;

    static int[] count;

    static Set<Integer> ans = new HashSet<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        nums = new int[n];
        count = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            count[i] = sc.nextInt();
        }
        //
        ans.clear();
        ans.add(0);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            Set<Integer> temp = new HashSet<>(ans);
            for (Integer t : temp) {
                for (int j = 0; j <= count[i]; j++) {
                    int x = j * nums[i] + t;
                    ans.add(x);
                }
            }
        }
        System.out.println(ans.size());
    }


}

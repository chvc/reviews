package od;


import java.util.Arrays;
import java.util.Scanner;

/**
 * P00312—Wonderland游乐园
 *
 * @author chenghu
 * @since 2025-09-13 12:57:11
 */
public class Od312AWonderLand {

    static int[] duration = new int[]{
            1, 3, 7, 10
    };

    static int[] costs;
    static int[] days;
    static int[] memo;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        costs = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        days = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        memo = new int[365];
        Arrays.fill(memo, -1);
        int ans = f(0);
        System.out.println(ans);
    }

    public static int f(int i) {
        if (i == days.length) {
            return 0;
        }
        if (memo[i] != -1) {
            return memo[i];
        }
        // days
        int j = i + 1;
        int ans = Integer.MAX_VALUE;
        for (int k = 0; k < 4; k++) {
            while (j < days.length && duration[k] + days[i] > days[j]) {
                j++;
            }
            ans = Math.min(ans, costs[k] + f(j));
        }
        memo[i] = ans;
        return ans;
    }

}

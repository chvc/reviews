package od;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *  P00178—分糖果
 *
 * @author chenghu
 * @since 2025/8/8
 */
public class Od45AssigningSugar {


    static Map<Integer, Integer> memo = new HashMap<Integer, Integer>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int res = minStepToOne(n);
        System.out.println(res);
    }

    public static int minStepToOne(int n) {
        if (n == 2) {
            memo.put(2, 1);
            return 1;
        }
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        if (n % 2 == 0) {
            int res = minStepToOne(n / 2) + 1;
            memo.put(n, res);
            return res;
        } else {
            int res = Math.min(minStepToOne(n + 1) + 1, minStepToOne(n - 1) + 1);
            memo.put(n, res);
            return res;
        }

    }

}

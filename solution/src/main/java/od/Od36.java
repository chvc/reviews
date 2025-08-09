package od;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025/8/8
 */
public class Od36 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int ans = find(n, m);
            System.out.println(ans);
        } catch (InputMismatchException e) {
            System.out.println(-1);
        }


    }

    public static int find(int n, int m) {
        if (n <= 2 || n > 7) {
            return -1;
        }
        if (m < 0) {
            return -1;
        }
        int min = (int) Math.pow(10, n - 1);
        int max = (int) Math.pow(10, n);
        List<Integer> list = new ArrayList<>();
        for (int i = min; i < max; i++) {
            int sum = 0;
            int j = i;
            while (j != 0) {
                int x = j % 10;
                sum = sum + (int) Math.pow(x, n);
                j = j / 10;
            }
            if (sum == i) {
                list.add(i);
            }
        }
        if (m < list.size()) {
            return list.get(m);
        } else {
            return list.get(list.size() - 1) * m;
        }
    }

}



package od;


import java.util.Arrays;
import java.util.Scanner;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025-08-23 14:16:10
 */
public class Od399 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            int[] bricks = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
            if (bricks.length > 8) {
                System.out.println(-1);
                return;
            }
            //
            int min = 1;
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < bricks.length; i++) {
                max = Math.max(max, bricks[i]);
            }
            int ans = -1;
            while (min <= max) {
                int m = min + (max - min) / 2;
                if (f(m, bricks) <= 8) {
                    // 速度比较大 答案可能还在更左边
                    ans = m;
                    max = m - 1;
                } else {
                    min = m + 1;
                }
            }
            System.out.println(ans);
        }
    }

    public static int f(int speed, int[] bricks) {
        int time = 0;
        for (int i = 0; i < bricks.length; i++) {
            time += (bricks[i] + speed - 1) / speed;
        }
        return time;
    }
}

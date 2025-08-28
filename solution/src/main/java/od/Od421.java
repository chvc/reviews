package od;


import java.util.Scanner;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025-08-23 17:39:18
 */
public class Od421 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int k = scanner.nextInt();
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            if (m <= 1) {
                System.out.println(0);
                return;
            }
            int count = 0;
            while (k != 0) {
                int mod = k % m;
                k = k / m;
                if (mod == n) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }

}

package od;


import java.util.Map;
import java.util.Scanner;

/**
 * P00143—靠谱的车
 *
 * @author chenghu
 * @since 2025-09-08 16:24:38
 */
public class Od300RightCar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(f1(n));
    }

    public static int f1(int n) {
        int pow = 0;
        int ans = 0;
        while (n > 0) {
            int mod = n % 10;
            ans += (int) (Math.pow(9, pow) * (mod <= 4 ? mod : mod - 1));
            n = n / 10;
            pow++;
        }
        return ans;
    }

}

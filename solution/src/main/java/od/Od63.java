package od;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025-08-27 22:37:31
 */
public class Od63 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        // 从 1 到 T上面进行滑动
        List<String> list = new ArrayList<>();

        int sum = 0;

        for (int r = 1, l = 1; r <= T; r++) {
            sum += r;
            // 如果比他大 就不停地收缩
            while (sum > T) {
                sum -= l;
                l++;
            }
            if (sum == T) {
                List<String> temp = new ArrayList<>();
                for (int i = l; i <= r; i++) {
                    temp.add(String.valueOf(i));
                }
                list.add(T + "=" + String.join("+", temp));
            }
        }
        list.sort(Comparator.comparingInt(String::length));
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println("Result:" + list.size());
    }

}

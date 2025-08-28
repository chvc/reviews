package od;


import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025-08-26 21:41:24
 */
public class Od202 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] split = s.split(" ");
        int[] arr = Arrays.stream(split).mapToInt(e -> {
            if (e.contains("Y")) {
                return Integer.parseInt(e.substring(0, e.length() - 2));
            } else {
                return 7 * Integer.parseInt(e.substring(0, e.length() - 2));
            }
        }).toArray();
        int cost = Integer.MAX_VALUE;
        int profit = Integer.MIN_VALUE;
        for (int i = 0; i <arr.length; i++) {
            cost = Math.min(cost,arr[i]);

        }
    }
}

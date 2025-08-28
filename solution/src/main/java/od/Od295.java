package od;


import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025-08-26 22:34:01
 */
public class Od295 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> arr = Arrays
                .stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
        Collections.sort(arr, Comparator.comparingInt(o -> o));
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        // -1 -3  5 7 11 15
        for (int i = 0; i < arr.size(); i++) {
            min = Math.min(min, arr.get(i));
            max = Math.max(min, arr.get(i));
        }
        // 全是负数
        int a;
        int b;
        int absSum = Integer.MAX_VALUE;
        if (max <= 0) {
            // -1 -2 -3 -xx
            a = arr.get(0);
            b = arr.get(1);
        } else if (min >= 0) {
            // 全是正数
            a = arr.get(0);
            b = arr.get(1);
        } else {
            // 有正有负
            int l = 0;
            int r = arr.size() - 1;
            // -3 -1  5 7 11 15

        }
//        System.out.println(
//                a + " " + b + " " + Math.abs(a + b));
    }

}

package od;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * P00406-最大N个数与最小N个数的和
 *
 * @author chenghu
 * @since 2025-08-28 21:08:37
 */
public class Od73SumOfLargestKNumAndSmallestKNum {

    static List<Integer> list = new ArrayList<>();

    static Set<Integer> set = new HashSet<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        list.clear();
        set.clear();
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            if (x > 1000 || x < 0) {
                System.out.println(-1);
                return;
            }
            set.add(x);
        }
        list = new ArrayList<>(set);
        int k = sc.nextInt();
        if (k < 0) {
            System.out.println(-1);
            return;
        }

        if (list.size() < 2 * k) {
            System.out.println(-1);
            return;
        }
        Collections.sort(list);
        // 排序了后 从 前面拿出最大的k个数 从后面拿出k个数

        List<Integer> min = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            min.add(list.get(i));
        }
        List<Integer> max = new ArrayList<>();
        for (int i = list.size() - 1; i >= list.size() - k; i--) {
            max.add(list.get(i));
        }
        if (min.isEmpty() && max.isEmpty()) {
            System.out.println(0);
            return;
        }
        // 比较 最小的那个最后一个数是否大于或者等于最大数组最小的那个
        if (min.get(k - 1) >= max.get(0)) {
            System.out.println(-1);
            return;
        }
        int sum = 0;
        for (int i = 0; i < min.size(); i++) {
            sum += min.get(i);
        }
        for (int i = 0; i < max.size(); i++) {
            sum += max.get(i);
        }
        System.out.println(sum);
    }


}

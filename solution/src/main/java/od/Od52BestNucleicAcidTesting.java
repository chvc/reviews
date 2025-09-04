package od;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * P00130华为od机试—优选核酸检测点
 *
 * @author chenghu
 * @since 2025-09-03 21:51:59
 */
public class Od52BestNucleicAcidTesting {

    static int startHour;

    static int startMinute;

    static int endHour;

    static int endMinute;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        startHour = sc.nextInt();
        startMinute = sc.nextInt();
        endHour = sc.nextInt();
        endMinute = sc.nextInt();
        int n = sc.nextInt();
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int id = sc.nextInt();
            int distance = sc.nextInt();
            int persons = sc.nextInt();
            // 花费的总时间 总消费
            list.add(new int[]{id, distance, persons, 0, 0, 0});
        }
        Collections.sort(list, (o1, o2) -> {
            // 先比较时间
            int i1 = o1[0];
            int d1 = o1[1];
            int p1 = o1[2];
            int i2 = o2[0];
            int d2 = o2[1];
            int p2 = o2[2];
            int t1 = getTime(d1, p1);
            int t2 = getTime(d2, p2);
            int c1 = getCost(d1);
            int c2 = getCost(d2);
            o1[3] = t1;
            o2[3] = t2;
            o1[4] = c1;
            o2[4] = c2;
            if (t1 == Integer.MAX_VALUE) {
                o1[5] = 1;
            }
            if (t2 == Integer.MAX_VALUE) {
                o2[5] = 1;
            }
            if (t1 != t2) {
                return t1 - t2;
            }
            if (c1 != c2) {
                return c1 - c2;
            }
            return i1 - i2;
        });

        list = list.stream().filter(i -> i[5] != 1).collect(Collectors.toList());
        System.out.println(list.size());
        for (int[] e : list) {
            System.out.println(e[0] + " " + e[3] + " " + e[4]);
        }
    }

    // 花费的时间 路程的时间加上等待做核酸的时间
    public static int getTime(int distance, int persons) {
        int travelTime = distance * 10;
        // 计算路上的时间
        // 计算到达时的人数
        // 换算成分钟 480 min -- 600 分钟 一分钟增加3人
        // 720 -- 840 一分钟增加10人
        int start = startHour * 60 + startMinute;
        int end = endHour * 60 + endMinute;
        int arrivalTime = start + travelTime;
        //
        if (arrivalTime > end) {
            // 直接不达标了 返回无穷大
            return Integer.MAX_VALUE;
        }
        if (end < 480) {
            return Integer.MAX_VALUE;
        }
        //
        int plus = 0;
        for (int i = start; i < arrivalTime; i++) {
            if (i <= 480) {
                persons = Math.max(--persons, 0);
            }
            if (i > 480 && i <= 600) {
                persons = persons + 3;
            }
            if (i > 600 && i <= 720) {
                persons = Math.max(--persons, 0);
            }
            if (i > 720 && i < 840) {
                persons = persons + 10;
            }
            if (i >= 840) {
                persons = Math.max(--persons, 0);
            }
        }
        int res = Math.max(persons, 0) + travelTime;
        if (res > end) {
            return Integer.MAX_VALUE;
        }
        return res;
    }

    // 花费的费用
    public static int getCost(int distance) {
        return distance * 10;
    }

}

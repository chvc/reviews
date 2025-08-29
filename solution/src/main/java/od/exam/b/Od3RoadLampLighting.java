package od.exam.b;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * P00168-路灯照明问题-区间
 *
 * @author chenghu
 * @since 2025-08-20 21:52:37
 */
public class Od3RoadLampLighting {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] lights = new int[n];
        for (int i = 0; i < n; i++) {
            lights[i] = scanner.nextInt();
        }
        int interval = 100;
        int maxRange = (n - 1) * 100;
        List<Integer[]> list = new ArrayList<>();
        for (int i = 0; i < lights.length; i++) {
            int start = (i * interval - lights[i]);
            start = Math.max(start, 0);
            int end = i * interval + lights[i];
            end = Math.min(end, maxRange);
            list.add(new Integer[]{
                    start, end
            });
        }
        // 合并区间
        Collections.sort(list, Comparator.comparingInt(o -> o[0]));
        List<Integer[]> megeredRangeList = new ArrayList<>();
        Integer[] cur = list.get(0);
        megeredRangeList.add(cur);
        for (int i = 1; i < list.size(); i++) {
            Integer[] next = list.get(i);
            if (cur[1] >= next[0] - 1) {
                cur[1] = Math.max(cur[1], next[1]);
            } else {
                cur = next;
                megeredRangeList.add(cur);
            }
        }
        int ans = 0;
        for (int i = 0; i < megeredRangeList.size(); i++) {
            ans += megeredRangeList.get(i)[1] - megeredRangeList.get(i)[0];
        }
        System.out.println(maxRange - ans);
    }

}

package prefix;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025-08-20 23:42:56
 */
public class Lc56 {


    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        //
        List<int[]> list = new ArrayList<>();
        int[] cur = intervals[0];
        list.add(cur);
        for (int i = 1; i < intervals.length; i++) {
            int[] next = intervals[i];
            if (cur[1] >= next[0]) {
                // 合并
                cur[1] = Math.max(cur[1], next[1]);
            } else {
                cur = next;
                list.add(cur);
            }
        }
        int[][] res = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}

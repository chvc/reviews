package listnode;

import structure.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025/7/30
 */
public class Lc2058 {


    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int[] res = new int[]{
                -1, -1
        };
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        if (list.size() == 2) {
            return res;
        }
        // 遍历 list 找出极大 极小值
        List<Integer> resList = new ArrayList<>();
        for (int i = 1; i < list.size() - 1; i++) {
            if (list.get(i) < list.get(i - 1) && list.get(i) < list.get(i + 1)) {
                resList.add(i);
            }
            if (list.get(i) > list.get(i - 1) && list.get(i) > list.get(i + 1)) {
                resList.add(i);
            }
        }
        // 装的就是 极值了 求最大值 和最小值
        Collections.sort(resList);
        int max = resList.get(resList.size() - 1) - resList.get(0);
        int min = -1;
        for (int i = 1; i < resList.size(); i++) {
            min = Math.min(min, resList.get(i) - resList.get(i - 1));
        }
        res[0] = min;
        res[1] = max;
        return res;
    }


}



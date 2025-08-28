package listnode;


import structure.ListNode;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025-08-28 07:58:52
 */
public class Lc23 {

    // 合并k个有序链表 准备一个小根堆 将 头结点放进去


    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                pq.add(lists[i]);
            }

        }
        //
        // 可能为空?
        if (pq.isEmpty()) {
            return null;
        }

        // 头结点
        ListNode h = pq.poll();
        ListNode pre = h;
        if (pre.next != null) {
            pq.add(pre.next);
        }
        // 如果 pre的next为空 怎么办？
        while (!pq.isEmpty()) {
            ListNode cur = pq.poll();
            pre.next = cur;
            pre = cur;
            if (cur.next != null) {
                pq.add(cur.next);
            }
        }
        return h;
    }

}

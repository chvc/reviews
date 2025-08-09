package listnode;

import structure.ListNode;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025/7/30
 */
public class Lc2181 {
    public ListNode mergeNodes(ListNode head) {
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        int sum = 0;
        while (head != null) {
            if (head.val != 0) {
                sum = sum + head.val;
            } else {
                // 节点为0 需要创建新节点了
                if (sum != 0) {
                    ListNode next = new ListNode(sum);
                    cur.next = next;
                    cur = next;
                    sum = 0;
                }
            }
            head = head.next;
        }
        return dummy;
    }

}





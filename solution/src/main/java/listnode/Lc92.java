package listnode;

import structure.ListNode;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025/8/2
 */
public class Lc92 {

    public ListNode reverseBetween(ListNode head, int left, int right) {

        ListNode dummy = new ListNode(0, head);
        ListNode l = dummy;
        ListNode pre = dummy;
        ListNode r = dummy;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        for (int i = 0; i < left; i++) {
            l = l.next;
        }
        for (int i = 0; i < right; i++) {
            r = r.next;
        }
        // 翻转链表
        ListNode cur = l;
        ListNode p = null;
        while (cur != null && cur != r) {
            ListNode nex = cur.next;
            cur.next = p;
            p = cur;
            cur = nex;
        }
        pre.next.next = cur;
        pre.next = p;
        return dummy.next;
    }

    public static void main(String[] args) {
        System.out.println(new Lc92().reverseBetween(ListNode.createNode(new int[]{
                1, 2, 3, 4, 5
        }), 2, 4));
    }

}

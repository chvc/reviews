package listnode;


import structure.ListNode;

import java.util.List;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025-08-09 21:50:57
 */
public class Lc86 {

    public ListNode partition(ListNode head, int x) {
        ListNode preDummy = new ListNode(0, head);
        ListNode sufDummy = new ListNode(0, head);
        ListNode pre = preDummy;
        ListNode suf = sufDummy;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val < x) {
                pre.next = cur;
                pre = pre.next;
            } else {
                suf.next = cur;
                suf = suf.next;
            }
            cur = cur.next;
        }
        pre.next = preDummy.next;
        suf.next = null;
        return preDummy.next;
    }


    public static void main(String[] args) {
        Lc86 lc86 = new Lc86();
        lc86.partition(ListNode.createNode(new int[]{
                1, 4, 3, 2, 5, 2
        }), 3);
    }
}

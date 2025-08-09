package listnode;

import structure.ListNode;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025/7/30
 */
public class Lc203 {

    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode cur = dummy;
        while (cur.next != null) {
            ListNode cuu = cur;
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }

        }
        return dummy.next;
    }

    public static void main(String[] args) {
        System.out.println(new Lc203().removeElements(ListNode.createNode(new int[]{
                1, 2, 6, 3, 4, 5, 6
        }), 6));
    }

}

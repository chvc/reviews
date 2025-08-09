package listnode;

import structure.ListNode;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025/7/30
 */
public class Lc2095 {

    public ListNode deleteMiddle(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;

        }
        slow.next = slow.next.next;
        return dummy.next;
    }

    public static void main(String[] args) {
        System.out.println(new Lc2095().deleteMiddle(ListNode.createNode(new int[]{
                1
        })));
    }

}

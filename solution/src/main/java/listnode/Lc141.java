package listnode;

import structure.ListNode;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025/7/31
 */
public class Lc141 {

    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

}

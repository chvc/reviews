package listnode;

import structure.ListNode;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025/7/30
 */
public class Lc876 {

    public ListNode middleNode(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        while (fast != null && fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow.next;
    }

    public static void main(String[] args) {
        System.out.println(new Lc876().middleNode(ListNode.createNode(new int[]{
                1, 2, 3, 4, 5
        })));
    }

}

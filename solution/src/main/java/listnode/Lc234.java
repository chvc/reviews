package listnode;

import structure.ListNode;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025/7/30
 */
public class Lc234 {

    public boolean isPalindrome(ListNode head) {
        ListNode middle = head;
        ListNode mid = findMiddle(middle);
        ListNode reverse = reverseList(mid);
        while (reverse != null) {
            if (head.val != reverse.val) {
                return false;
            }
            reverse = reverse.next;
            head = head.next;
        }
        return true;
    }

    public ListNode findMiddle(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode fast = dummy;
        ListNode slow = dummy;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow.next;
    }

    public ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        System.out.println(new Lc234().isPalindrome(ListNode.createNode(new int[]{
                1, 2, 2, 1,3
        })));
    }
}

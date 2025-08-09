package listnode;

import structure.ListNode;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025/7/31
 */
public class Lc143 {
    public void reorderList(ListNode head) {
        ListNode middle = head;
        ListNode mid = findMiddle(middle);
        ListNode reverse = reverseList(mid);
        mergeList(head, reverse);
        System.out.println("=====>");
    }

    public ListNode findMiddle(ListNode node) {
        ListNode fast = node;
        ListNode slow = node;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public ListNode reverseList(ListNode node) {
        ListNode cur = node;
        ListNode pre = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public void mergeList(ListNode head, ListNode reverse) {
        while (reverse.next != null) {
            ListNode next1 = head.next;
            ListNode next2 = reverse.next;
            head.next = reverse;
            reverse.next = next1;
            head = next1;
            reverse = next2;
        }
    }


    public static void main(String[] args) {
        new Lc143().reorderList(ListNode.createNode(new int[]{
                1, 2, 3, 4, 5, 6
        }));
    }
}

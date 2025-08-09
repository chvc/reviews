package listnode;

import structure.ListNode;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025/7/30
 */
public class Lcr027 {

    public boolean isPalindrome(ListNode head) {
        ListNode copiedNode = new ListNode();
        ListNode cur = copiedNode;
        ListNode cycle = head;
        while (cycle != null) {
            cur.next = new ListNode(cycle.val);
            cycle = cycle.next;
            cur = cur.next;
        }
        ListNode reverseNode = reverseList(copiedNode.next);
        while (reverseNode != null && head != null) {
            if (reverseNode.val != head.val) {
                return false;
            }
            reverseNode = reverseNode.next;
            head = head.next;
        }
        return true;
    }

    public ListNode reverseList(ListNode node) {
        ListNode pre = null;
        ListNode cur = node;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(1);
        node.next.next = new ListNode(2);
        node.next.next.next = new ListNode(1);
        System.out.println(new Lcr027().isPalindrome(node));
    }

}

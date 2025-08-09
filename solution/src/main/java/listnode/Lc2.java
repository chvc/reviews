package listnode;

import structure.ListNode;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025/7/30
 */
public class Lc2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int v1;
            int v2;
            if (l1 == null) {
                v1 = 0;
            } else {
                v1 = l1.val;
            }
            if (l2 == null) {
                v2 = 0;
            } else {
                v2 = l2.val;
            }
            int num = v1 + v2 + carry;
            int i = num % 10;
            carry = num / 10;
            ListNode node = new ListNode(i);
            cur.next = node;
            cur = cur.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        return dummy;
    }

    public static void main(String[] args) {
        ListNode l1 = ListNode.createNode(new int[]{
                9, 9, 9, 9, 9, 9, 9
        });
        ListNode l2 = ListNode.createNode(new int[]{
                9, 9, 9, 9
        });
        System.out.println(new Lc2().addTwoNumbers(l1, l2));
    }


}

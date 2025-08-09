package listnode;

import structure.ListNode;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025/8/2
 */
public class Lc2807 {
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            int pre = cur.val;
            ListNode next = cur.next;
            int nextVal = next.val;
            int gcd = gcd(pre, nextVal);
            ListNode node = new ListNode(gcd);
            cur.next = node;
            node.next = next;
            cur = next;
        }
        return head;
    }


    public int gcd(int a, int b) {
        while (a % b != 0) {
            int mod = a % b;
            a = b;
            b = mod;
        }
        return b;
    }

    public static void main(String[] args) {
        System.out.println(new Lc2807().gcd(4, 6));
    }


}

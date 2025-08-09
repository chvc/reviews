package listnode;

import structure.ListNode;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025/7/30
 */
public class Lc19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int cnt = 0;
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode cur = dummy;
        while (cur != null) {
            cur = cur.next;
            cnt++;
        }
        //
        int index = cnt - n;
        ListNode curr = dummy;
        int i = 0;
        while (curr != null) {
            if (i == index - 1) {
                curr.next = curr.next.next;
            }
            i++;
            curr = curr.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode node = ListNode.createNode(new int[]{
                1, 2, 3, 4, 5
        });
        System.out.println(new Lc19().removeNthFromEnd(node, 2));
    }

}

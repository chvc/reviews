package listnode;

import structure.ListNode;
import twopointer.Lc238;

import java.util.List;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025/8/3
 */
public class Lc328 {

    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode odd = head;
        ListNode even = odd.next;
        ListNode evenHead = even;
        while (odd != null && odd.next != null) {
            odd.next = odd.next.next;
            if (odd.next != null) {
                odd = odd.next;
            }
            if (even != null) {
                if (even.next != null) {
                    even.next = even.next.next;
                }
                even = even.next;
            }
        }
        odd.next = evenHead;
        return head;
    }

    public static void main(String[] args) {
        ListNode.printListNode(new Lc328().oddEvenList(ListNode.createNode(new int[]{
                1, 2, 3, 4, 5, 6, 7, 8
        })));
    }

}

package listnode;

import structure.ListNode;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025/8/2
 */
public class Lc147 {

    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(-10000);
        ListNode cur = head;
        while (cur != null) {
            int curVal = cur.val;
            if (dummy.next == null) {
                ListNode node = new ListNode(cur.val);
                dummy.next = node;
            } else {
                ListNode pre = dummy;
                ListNode curr = dummy.next;
                int currVal = curr.val;
                while (curr.next != null && curVal > currVal) {
                    curr = curr.next;
                    currVal = curr.val;
                    pre = pre.next;
                }
                if (curr.next == null) {
                    ListNode node = new ListNode(curVal);
                    curr.next = node;
                } else {
                    ListNode node = new ListNode(curVal);
                    pre.next = node;
                    node.next = curr;
                }
            }
            cur = cur.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        System.out.println(new Lc147().insertionSortList(ListNode.createNode(new int[]{
                -1, 5, 3, 4, 0
        })));
    }

}

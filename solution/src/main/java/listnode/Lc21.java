package listnode;

import structure.ListNode;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025/7/31
 */
public class Lc21 {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        while (list1 != null || list2 != null) {
            if (list1 == null) {
                dummy.next = list2;
            }
            if (list2 == null) {
                dummy.next = list1;
            }
            int v1 = list1 == null ? Integer.MAX_VALUE : list1.val;
            int v2 = list2 == null ? Integer.MAX_VALUE : list2.val;
            if (v1 <= v2) {
                dummy.next = new ListNode(v1);
                list1 = list1.next;
                dummy = dummy.next;
            } else {
                dummy.next = new ListNode(v2);
                list2 = list2.next;
                dummy = dummy.next;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        System.out.println(new Lc21().mergeTwoLists(ListNode.createNode(new int[]{
                1, 2, 4
        }), ListNode.createNode(new int[]{
                1, 3, 4
        })));
    }

}

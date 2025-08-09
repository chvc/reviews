package structure;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025/7/30
 */
public class ListNode {


    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode createNode(int[] nums) {
        ListNode node = new ListNode();
        ListNode cur = node;
        for (int num : nums) {
            ListNode next = new ListNode(num);
            cur.next = next;
            cur = cur.next;
        }
        return node.next;
    }

    public static void printListNode(ListNode node) {
        ListNode cur = node;
        while (cur != null) {
            System.out.print(cur.val);
            if (cur.next != null) {
                System.out.print(" -> ");
            }
            cur = cur.next;
        }
    }

}

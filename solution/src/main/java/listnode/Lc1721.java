package listnode;

import structure.ListNode;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025/8/2
 */
public class Lc1721 {


    public ListNode swapNodes(ListNode head, int k) {
        ListNode dummy = new ListNode(0, head);
        ListNode pre = dummy;
        // 下表从1 开始
        for (int i = 0; i < k; i++) {
            pre = pre.next;
        }
        int preVal = pre.val;
        // pre 就是此时的前k节点
        ListNode pree = pre;
        ListNode suf = dummy;
        while (pree != null) {
            suf = suf.next;
            pree = pree.next;
        }
        int sufVal = suf.val;
        pre.val = sufVal;
        suf.val = preVal;
        return dummy.next;
    }

    public static void main(String[] args) {
        System.out.println(new Lc1721().swapNodes(ListNode.createNode(new int[]{
                1, 2, 3, 4, 5
        }), 2));
    }
}

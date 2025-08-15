package math;


import structure.ListNode;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025-08-11 08:09:45
 */
public class Lcr187 {

    // 模拟法
    public int iceBreakingGame(int num, int target) {
        return this.simulate(num, target);
    }

    // 环形链表
    public int simulate(int num, int target) {

        ListNode node = new ListNode(0);
        ListNode cur = node;

        for (int i = 1; i < num; i++) {
            cur.next = new ListNode(i);
            cur = cur.next;
        }
        cur.next = node;

        int round = 0;

        ListNode p = node;
        int count = 1;
        while (round < num - 1) {
            while (count < target - 1) {
                p = p.next;
                count++;
            }
            p.next = p.next.next;
            p = p.next;
            count = 1;
            round++;
        }
        return p.val;
    }

    public static void main(String[] args) {
        Lcr187 lcr187 = new Lcr187();
        System.out.println(lcr187.iceBreakingGame(5, 1));
    }


}

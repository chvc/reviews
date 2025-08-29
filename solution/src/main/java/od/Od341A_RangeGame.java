package od;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 排队游戏-刺头游戏-堆
 *
 * @author chenghu
 * @since 2025-08-29 00:31:35
 */
public class Od341A_RangeGame {

    /**
     * 新来的老师给班里的同学排一个队。每个学生有一个影力值。一些学生是刺头，不会听老师的话，自己选位置，非刺头同学在剩下的位置按照能力值从小到大排。对于非刺头同学，如果发现他前面有能力值比自己高的同学，他不满程度就增加，增加的数量等于前面能力值比他大的同学的个数刺头不会产生不满如果整个班级累计的不满程度超过k，那么老师就没有办法教这个班级了.
     * 输入描述
     * 输入有三行:
     * 第一行为n,m,k,空格隔开，分别表示班级总人数，刺头人数，最大不满程度k.
     * <p>
     * 第二行为刺头所在位置(从0开始，即排队数组的下标，比如1代表队伍中第2个同学是刺头)，位置的数组也是排序的.
     * <p>
     * 第三行有n个数，空格隔开，表示老师排好的队中每人人的能力值，其中非刺头同学一定按照能力值从小到大排好序的
     * <p>
     * 输出描述
     * 0 表示老师可以继续教这个班级
     * 1 表示老师无法继续教这个班级
     * 说明：
     * n 范围是[1,10000]
     * m 范围是[1,n]
     * k 范围是[1,1000000000]
     * 每位同学的能力值范围是[1000,100000]
     * <p>
     * 示例1：
     * <p>
     * 输入
     * <p>
     * 4 2 3
     * 0 1
     * <p>
     * 1810 1809 1801 1802
     * 输出
     * <p>
     * 1
     * 说明
     * 刺头在0.1位置，2号同学不满程度2(前面两人刺头能力值都比他大)，3号同学不满程度2，总不满程度4，大于3。输出不能教这班(1).
     * <p>
     * 示例2：
     * 输入
     * <p>
     * 4 2 4
     * 0 1
     * 1810 1809 1801 1802
     * 输出：
     * 0
     * <p>
     * 说明：
     * 同前，4不大于4，输出能教这个班(0)
     */

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String line;
        while ((line = in.readLine()) != null) {
            String[] split = line.split(" ");
            int[] params = Arrays.stream(split).mapToInt(Integer::parseInt).toArray();
            int n = params[0];
            int m = params[1];
            int k = params[2];
            String pos = in.readLine();
            Set<Integer> set = Arrays.stream(pos.split(" ")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toSet());
            String num = in.readLine();
            int[] nums = Arrays.stream(num.split(" ")).mapToInt(Integer::parseInt).toArray();
            PriorityQueue<Integer> heap = new PriorityQueue<>();
            long kk = 0;
            for (int i = 0; i < nums.length; i++) {
                int x = nums[i];
                if (set.contains(i)) {
                    heap.add(x);
                } else {
                    while (!heap.isEmpty() && heap.peek() <= x) {
                        heap.poll();
                    }
                    if (!heap.isEmpty()) {
                        kk += heap.size();
                    }
                }
            }
            if (kk > k) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }

        in.close();
    }

}

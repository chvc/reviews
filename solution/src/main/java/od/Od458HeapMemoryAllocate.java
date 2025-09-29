package od;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * #P00212—堆内存申请
 * // todo 应该使用 区间的做法
 *
 * @author chenghu
 * @since 2025-09-27 22:53:33
 */
public class Od458HeapMemoryAllocate {

    /**
     * 有一个总空间为100字节的堆，现要从中新申请一块内存，内存分配原则为:优先紧接着前一块已使用内存，分配空间足够目最接近申请大小的空闲内存。
     * <p>
     * <p>
     * 输入描述
     * 第1行是1个整数，表示期望申请的内存字节数。
     * 第2到第N行是用空格分割的两个整数，表示当前已分配的内存的情况，每一行表示一块已分配的连续内存空间，每行的第1和第2个整教分别表示偏移地址和内存块大小，如:
     * 0 1
     * <p>
     * 3 2
     * 表示0偏移地址开始的1个字节和3偏移地址开始的2个字节已被分配，其余内存空闲。
     * 输出描述
     * 若申请成功，输出申请到内存的偏移
     * 若申请失败，输出-1。
     * <p>
     * 备注
     * 1.若输入信息不合法或无效，则申请失败2.若没有足够的空间供分配，则申请失败3.堆内存信息有区域重叠或有非法值等都是无效输入
     * <p>
     * 示例1：
     * <p>
     * 输入：
     * <p>
     * 1
     * 0 1
     * 3 2
     * <p>
     * 输出：
     * <p>
     * 1
     * <p>
     * 说明
     * 堆中已使用的两块内存是偏移从0开始的1字节和偏移从3开始的2字节，空闲的两块内存是偏移从1开始2个字节和偏移从5开始95字节根据分配原则，新申请的内存应从1开始分配1个字节，所以输出偏移为1。
     *
     * @param args
     */

    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = Integer.parseInt(sc.nextLine());
        boolean[] heap = new boolean[100];
        int cnt = 100;
        while (sc.hasNextLine()) {
            String s = sc.nextLine().trim();
            if (s.isEmpty()) {
                break;
            }
            String[] split = s.split(" ");
            int offset = Integer.parseInt(split[0]);
            if (offset < 0 || offset >= 100) {
                System.out.println(-1);
                return;
            }
            int size = Integer.parseInt(split[1]);
            if (heap[offset]) {
                System.out.println(-1);
                return;
            }
            int y = offset + size;
            if (y >= 100) {
                System.out.println(-1);
                return;
            }
            for (int i = offset; i < offset + size; i++) {
                heap[i] = true;
                cnt--;
            }
            if (cnt == 0) {
                System.out.println(-1);
                return;
            }
        }
        // 一共 x个
        for (int i = 0; i < heap.length; i++) {
            boolean flag = true;
            int t = i + x;
            if (t >= 100) {
                System.out.println(-1);
                return;
            }
            for (int j = i; j < t; j++) {
                if (heap[j]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                System.out.println(i);
                return;
            }
        }

    }




        static class Block {
            int offset;
            int size;
            Block(int o, int s) { offset = o; size = s; }
        }

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            if (!sc.hasNextLine()) {
                System.out.println(-1);
                return;
            }

            int req;
            try {
                req = Integer.parseInt(sc.nextLine().trim());
            } catch (Exception e) {
                System.out.println(-1);
                return;
            }

            if (req <= 0 || req > 100) {
                System.out.println(-1);
                return;
            }

            List<Block> used = new ArrayList<>();
            while (sc.hasNextLine()) {
                String line = sc.nextLine().trim();
                if (line.isEmpty()) break;
                String[] parts = line.split("\\s+");
                if (parts.length != 2) {
                    System.out.println(-1);
                    return;
                }
                int offset, size;
                try {
                    offset = Integer.parseInt(parts[0]);
                    size = Integer.parseInt(parts[1]);
                } catch (Exception e) {
                    System.out.println(-1);
                    return;
                }

                if (offset < 0 || offset >= 100 || size <= 0 || offset + size > 100) {
                    System.out.println(-1);
                    return;
                }

                used.add(new Block(offset, size));
            }

            // 按 offset 排序
            used.sort(Comparator.comparingInt(b -> b.offset));

            // 检查重叠
            for (int i = 1; i < used.size(); i++) {
                Block prev = used.get(i - 1);
                Block cur = used.get(i);
                if (cur.offset < prev.offset + prev.size) {
                    System.out.println(-1);
                    return;
                }
            }

            // 构造空闲区
            List<Block> free = new ArrayList<>();
            int start = 0;
            for (Block b : used) {
                if (b.offset > start) {
                    free.add(new Block(start, b.offset - start));
                }
                start = b.offset + b.size;
            }
            if (start < 100) {
                free.add(new Block(start, 100 - start));
            }

            int bestOffset = -1;
            int bestDiff = Integer.MAX_VALUE;

            // 遍历空闲区
            for (int i = 0; i < free.size(); i++) {
                Block f = free.get(i);
                if (f.size >= req) {
                    // 优先紧接前一块已使用内存
                    int prevEnd = (i == 0 ? 0 : used.get(i - 1).offset + used.get(i - 1).size);
                    if (f.offset == prevEnd) {
                        System.out.println(f.offset);
                        return;
                    }
                    // 否则选择最接近申请大小的空闲块
                    int diff = f.size - req;
                    if (diff < bestDiff) {
                        bestDiff = diff;
                        bestOffset = f.offset;
                    }
                }
            }

            System.out.println(bestOffset);
        }



}

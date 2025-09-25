package od;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * #P00250—端口合并
 *
 * @author chenghu
 * @since 2025-09-23 21:42:55
 */
public class Od153PortMerge {

    /**
     * 有 M(1<=M<=10) 个端口组
     * 每个端口组是长度为 N(1<=N<=100)的整数数组，如果端口组间存在2个及以上不同端口相同，则认为这2个端口组 互相关联，可以合并
     * 第一行输入端口组个数M，再输入M行，每行逗号分隔，代表端口组。输出合并后的端口组，用二维数组表示
     * 输入描述
     * 第一行输入一个数字M
     * 第二行开始输入M行，每行是长度为N的整数数组，用逗号分割
     * 输出描述
     * 合并后的二维数组，用二维数组表示
     * 1：组合内同端口仅保留一个，并从小到大排序。
     * 2：组合外顺序保持输入顺序。
     * 示例1：
     * 输入：
     * 4
     * 4
     * 2,3,2
     * 1,2
     * 5
     * 输出：
     * [[4],[2,3],[1,2],[5]]
     * 示例2：
     * 输入：
     * 3
     * 2,3,1
     * 4,3,2
     * 5
     * 输出：
     * [[1,2,3,4],[5]]
     * 示例3：
     * 输入：
     * 6
     * 10
     * 4,2,1
     * 9
     * 3,6,9,2
     * 6,3,4
     * 8
     * 输出：
     * [[10],[1,2,3,4,6,9],[9],[8]]
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = Integer.parseInt(sc.nextLine());
        if (m <= 0 || m > 10) {
            System.out.println("[[]]");
            return;
        }
        ArrayList<List<Integer>> ans = new ArrayList<>();
        Map<Integer, Set<Integer>> map = new HashMap<>();
        boolean[] flags = new boolean[m];
        Arrays.fill(flags, true);
        for (int i = 0; i < m; i++) {
            Set<Integer> set = Arrays.stream(sc.nextLine().split(",")).map(Integer::parseInt).collect(Collectors.toSet());
            map.put(i, set);
        }
        boolean flag = true;
        while (flag) {
            int merged = 0;
            for (int i = 0; i < m; i++) {

                if (flags[i]) {
                    Set<Integer> set1 = map.get(i);
                    for (int j = i + 1; j < m; j++) {
                        int count = 0;
                        Set<Integer> set2 = map.get(j);
                        for (Integer x : set2) {
                            if (set1.contains(x)) {
                                count++;
                            }
                        }
                        // 合并set
                        if (count >= 2) {
                            set1.addAll(set2);
                            set2.clear();
                            flags[j] = false;
                            merged++;
                        }
                    }
                }
            }
            if (merged == 0) {
                flag = false;
            }
        }

        for (int i = 0; i < m; i++) {
            if (flags[i]) {
                Set<Integer> integers = map.get(i);
                ArrayList<Integer> list = new ArrayList<>(integers);
                Collections.sort(list);
                ans.add(list);
            }
        }
        String output = ans
                .stream()
                .map(list -> list.stream().map(String::valueOf).collect(Collectors.joining(",", "[", "]")))
                .collect(Collectors.joining(",", "[", "]"));
        System.out.println(output);
    }

}

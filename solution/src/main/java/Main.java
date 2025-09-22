/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025/8/7
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {

    //region
/*    public static void main(String[] args) {
//        给定一组闭区间，其中部分区间存在交集。
//
//        任意两个给定区间的交集，称为公共区间(如:[1,2],[2,3]的公共区间为[2,2]，[3,5],[3,6]的公共区间为[3,5])。
//
//        公共区间之间若存在交集，则需要合并(如:[1,3],[3,5]区间存在交集[3,3]，需合并为[1,5])。
//
//        按升序排列输出合并后的区间列表。
//
//        输入描述
//
//        一组区间列表，区间数为 N: 0<=N<=1000;区间元素为 X: -10000<=X<=10000。
//
//        输出描述
//
//                升序排列的合并区间列表
//
//        备注:
//
//        1、区间元素均为数字，不考虑字母、符号等异常输入。
//
//        2、单个区间认定为无公共区间。
//
//        示例1  输入输出示例仅供调试，后台判题数据一般不包含示例
//
//                输入
//
//[[0, 3], [1, 3], [3, 5], [3, 6]]
//
//        本题为了方便处理，OJ的输入去掉了逗号和括号。
//        0 3 1 3 3 5 3 6
//
//
//
//        输出
//
//                [[1, 5]]
//
//        说明
//
//                [0,3]和[1,3]的公共区间为[1,3]，[0,3]和[3,5]的公共区间为[3,3]，[0,3]和[3,6]的公共区间为[3,3]，[1,3]和[3,5]的公共区间为[3,3]，[1,3]和[3,6]的公共区间为[3,3]，[3,5]和[3,6]的公共区间为[3,5]，公共区间列表为[[1,3],[3,3],[3,5]]；[1,3],[3,3],[3,5]存在交集，须合并为[1,5]。
//
//        示例2 (简化输入版本)
//
//        输入
//        1 6 2 5 5 7
//        输出
//        2 6
//        说明
//                [1,6]、[2,5]的交集为[2,5]，[1,6]、[5,7]的交集为[5,6]
//[2,5]、[5,7]的交集为[5,5]
//        最后的输出为：2 6
//
//        示例3
//                输入
//        1 2 3 4
//        输出
//                (这里没看到题目上具体要求输出什么，根据题目情况临场发挥即可)
        Scanner in = new Scanner(System.in);
        int[] input = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = input.length / 2;
        Map<Integer, Integer> diff = new TreeMap<>();
        for (int i = 0; i < input.length; i = i + 2) {
            int start = input[i];
            int end = input[i + 1];
            diff.compute(start, (k, v) -> v == null ? 1 : v + 1);
            diff.compute(end + 1, (k, v) -> v == null ? -1 : v - 1);
        }
        Integer x = null, y = null;
        int sum = 0;
        StringBuilder result = new StringBuilder();
        for (Map.Entry<Integer, Integer> entry : diff.entrySet()) {
            sum += entry.getValue();
            if (sum > 1) {
                if (x == null) {
                    x = entry.getKey();
                }
            } else {
                y = entry.getKey();
                if (x != null) {
                    result.append(x).append(" ").append(y - 1).append(" ");
                }
                x = null;
            }
        }
        System.out.println(result.toString().trim());
    }*/
    //endregion

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            graph.get(u).add(new int[]{
                    v, w
            });
        }
        int src = sc.nextInt();
        int dst = sc.nextInt();
        int[] distance = new int[n + 1];
        boolean[] visited = new boolean[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[src] = 0;
        PriorityQueue<int[]> heap = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        heap.add(new int[]{
                src, 0
        });
        while (!heap.isEmpty()) {
            int[] poll = heap.poll();
            int u = poll[0];
            int di = poll[1];

            if (visited[u]) {
                continue;
            }
            visited[u] = true;
            List<int[]> children = graph.get(u);
            for (int[] child : children) {
                int v = child[0];
                int w = child[1];
                if (di + w < distance[v]) {
                    int newInstance = di + w;
                    distance[v] = newInstance;
                    heap.add(new int[]{
                            v, newInstance
                    });
                }
            }
        }
        System.out.println(distance[dst] == Integer.MAX_VALUE ? -1 : distance[dst]);
    }

}



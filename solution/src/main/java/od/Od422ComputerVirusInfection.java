package od;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 * P00278—电脑病毒感染
 *
 * @author chenghu
 * @since 2025-09-06 10:11:18
 */
public class Od422ComputerVirusInfection {

    static List<List<int[]>> graph = new ArrayList<>();

    // 所有点到单源的距离
    static int[] distance;

    static boolean[] visited;

    // dj
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }
        visited = new boolean[n + 1];
        distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int t = sc.nextInt();
            //
            graph.get(a).add(new int[]{
                    b, t
            });
        }
        int virusOrigin = sc.nextInt();
        // 找入度为0的节点 加入到队列中去
        //
        // 点 -- 距离
        PriorityQueue<int[]> heap = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        //
        distance[virusOrigin] = 0;
        heap.add(new int[]{
                virusOrigin, 0
        });
        while (!heap.isEmpty()) {
            int[] cur = heap.poll();
            int curComputer = cur[0];
            if (visited[curComputer]) {
                continue;
            }
            visited[curComputer] = true;
            int di = cur[1];
            List<int[]> children = graph.get(curComputer);
            // 找到孩子 如果距离可以变得更断 处理
            for (int[] child : children) {
                if (di + child[1] < distance[child[0]]) {
                    // 更新结果
                    distance[child[0]] = di + child[1];
                    heap.add(new int[]{
                            child[0], distance[child[0]]
                    });
                }
            }
        }
        int ans = Integer.MIN_VALUE;
        for (int i = 1; i < distance.length; i++) {
            if (distance[i] == Integer.MAX_VALUE) {
                System.out.println(-1);
                return;
            }
            ans = Math.max(ans,distance[i]);
        }
        System.out.println(ans);
    }

}

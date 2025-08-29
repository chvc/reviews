package od.exam.c;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

/**
 *  P00325—微服务的集成测试
 *
 * @author chenghu
 * @since 2025-08-24 22:52:49
 */
public class Od182MicroservicesIntegrationTesting {

    static Map<Integer, List<Integer>> dependMap;

    static int[][] grid;

    static int[] memo;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 求出每个服务的启动时间
        // 找出依赖关系

        dependMap = new HashMap<>();
        int n = scanner.nextInt();
        grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = scanner.nextInt();
            }
        }
        int k = scanner.nextInt();
        if (k > n) {
            System.out.println(-1);
            return;
        }
        // 从k-1号开始算
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(k - 1);
        while (!queue.isEmpty()) {
            Integer index = queue.poll();
            int[] services = grid[index];
            for (int i = 0; i < services.length; i++) {
                if (i != index && services[i] == 1) {
                    if (!dependMap.containsKey(index)) {
                        List<Integer> dependonList = new ArrayList<>();
                        dependonList.add(i);
                        dependMap.put(index, dependonList);
                    } else {
                        List<Integer> dependonList = dependMap.get(index);
                        dependonList.add(i);
                    }
                    queue.add(i);
                }
            }
        }
        memo = new int[n];
        Arrays.fill(memo, -1);
        int ans = f(k - 1);
        System.out.println(ans);
    }

    public static int f(int index) {
        List<Integer> dependList = dependMap.get(index);
        if (dependList == null || dependList.isEmpty()) {
            return grid[index][index];
        }
        // 如果依赖 就拿依赖的最大值
        int ans = Integer.MIN_VALUE;
        for (Integer depend : dependList) {
            ans = Math.max(ans, f(depend));
        }
        if (ans < 0) {
            ans = 0;
        }
        return ans + grid[index][index];
    }

}

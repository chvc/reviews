package graph;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 最小生成树
 *
 * @author chenghu
 * @since 2025-09-10 19:42:23
 */
public class Lc1584MinCostToConnectAllPoints {

    int[] father;
    int[] stack;

    public int minCostConnectPoints(int[][] points) {
        // 拿到的是所有的点
        // 建立边的集合
        int n = points.length;
        // 一共n个点 建立并查集
        // 从1 开始给点编号
        int cnt = 1;
        // 建立边的信息
        List<int[]> edges = new ArrayList<>();
        Map<Integer, int[]> pointInfoMap = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            pointInfoMap.put(cnt++, points[i]);
        }
        // 建立边的信息
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                int[] edge = new int[3];
                int u = i + 1;
                int v = j + 1;
                edge[0] = u;
                edge[1] = v;
                edge[2] = getInstance(pointInfoMap.get(u), pointInfoMap.get(v));
                edges.add(edge);
            }
        }
        // 建立并查集
        build(n);
        // 对每一条边进行排序
        edges.sort(Comparator.comparingInt(o -> o[2]));
        //
        int cost = 0;
        for (int i = 0; i < edges.size(); i++) {
            int[] edge = edges.get(i);
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            // 如果可以合并 说明之前不是同一个集合
            if (union(u, v)) {
                //
                cost += w;
            }
        }
        return cost;
    }

    public int getInstance(int[] pointA, int[] pointB) {
        int x1 = pointA[0];
        int y1 = pointA[1];
        int x2 = pointB[0];
        int y2 = pointB[1];
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }

    public void build(int n) {
        father = new int[n + 1];
        stack = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            father[i] = i;
        }
    }

    public int find(int x) {
        int cnt = 0;
        while (x != father[x]) {
            x = father[x];
            stack[cnt++] = x;
        }
        for (int i = 0; i < cnt; i++) {
            father[stack[i]] = x;
        }
        return x;
    }

    public boolean union(int x, int y) {
        int fx = find(x);
        int fy = find(y);
        //
        if (fx == fy) {
            return false;
        } else {
            // 合并父集合
            father[fx] = fy;
            return true;
        }
    }

    public static void main(String[] args) {
        Lc1584MinCostToConnectAllPoints lc1584MinCostToConnectAllPoints = new Lc1584MinCostToConnectAllPoints();
        System.out.println(lc1584MinCostToConnectAllPoints.minCostConnectPoints(new int[][]{
                {0, 0}, {2, 2}, {3, 10}, {5, 2}, {7, 0}
        }));
    }

}

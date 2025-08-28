package graph;


import java.util.Arrays;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025-08-28 08:31:29
 */
public class Lc547 {


    static int[] parent;

    static int n;

    static int[] sets;

    static int setSize;

    static int[] stack;


    public static void build() {
        // 构建并查集
        parent = new int[n];
        sets = new int[n];
        stack = new int[n];
        setSize = 0;
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            sets[i]++;
            setSize++;
        }
    }

    public static int find(int x) {
        // 构建并查集

        // 还有一个扁平化
        int cnt = 0;
        while (x != parent[x]) {
            stack[cnt++] = x;
            x = parent[x];
        }
        for (int i = 0; i < cnt; i++) {
            parent[stack[i]] = x;
        }
        return x;
    }

    public static void union(int x, int y) {
        int fx = find(x);
        int fy = find(y);
        if (fx != fy) {
            // 需要合并
            if (sets[fx] < sets[fy]) {
                // 将x合并到y上面去
                parent[fx] = fy;
                sets[fy] += sets[fx];
                sets[fx] = 0;
            } else {
                // 将x合并到y上面去
                parent[fy] = fx;
                sets[fx] += sets[fy];
                sets[fy] = 0;
            }
            setSize--;
        }
    }

    public int findCircleNum(int[][] isConnected) {
        n = isConnected.length;
        build();
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < isConnected.length; j++) {
                if (i == j) {
                    continue;
                }
                if (isConnected[i][j] == 1) {
                    union(i, j);
                }
            }
        }
        return setSize;
    }

    public static void main(String[] args) {
        Lc547 lc547 = new Lc547();
        System.out.println(lc547.findCircleNum(new int[][]{
                {1, 0, 0, 1},
                {0, 1, 1, 0},
                {0, 1, 1, 1},
                {1, 0, 1, 1}
        }));
    }

}

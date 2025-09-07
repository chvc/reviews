package graph;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025-09-06 20:43:08
 */
public class Lc851LoudAndRich {

    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n = quiet.length;
        // n个人 0- n-1
        List<List<Integer>> graph = new ArrayList<>();
        // 建图
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        // 入度表
        int[] inDegree = new int[n];
        for (int i = 0; i < richer.length; i++) {
            int u = richer[i][0];
            int v = richer[i][1];
            graph.get(u).add(v);
            inDegree[v]++;
        }
        // 准备一张answer表 初始时结果是自己
        int[] ans = new int[n];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = i;
        }
        // 准备一个队列
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        //
        while (!queue.isEmpty()) {
            Integer person = queue.poll();
            // 当前父节点的最小安静值
            int an = ans[person];
            int x = quiet[an];
            // 找有哪些child
            for (Integer per : graph.get(person)) {
                if (x < quiet[ans[per]]) {
                    ans[per] = an;
                }
                if (--inDegree[per] == 0) {
                    queue.add(per);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Lc851LoudAndRich lc851LoudAndRich = new Lc851LoudAndRich();
        System.out.println(Arrays.toString(lc851LoudAndRich.loudAndRich(new int[][]{
                {0, 2}, {1, 2}
        }, new int[]{
                0, 1, 2
        })));
    }

}

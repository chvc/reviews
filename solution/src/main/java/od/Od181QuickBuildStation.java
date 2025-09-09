package od;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * P00421-快速开租建站
 *
 * @author chenghu
 * @since 2025-09-09 09:17:52
 */
public class Od181QuickBuildStation {

    static int MAXN = 101;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int taskNum = sc.nextInt();
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < taskNum; i++) {
            graph.add(new ArrayList<>());
        }
        //
        int relationsNum = sc.nextInt();
        int[] inDegree = new int[taskNum];
        int[] times = new int[taskNum];
        for (int i = 0; i < relationsNum; i++) {
            // u ->v
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph.get(u).add(v);
            inDegree[v]++;
        }
        int[] q = new int[MAXN];
        int l = 0;
        int r = 0;
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                q[r++] = i;
                times[i] = 1;
            }
        }
        while (r > l) {
            int cur = q[l++];
            List<Integer> nodes = graph.get(cur);
            for (int i = 0; i < nodes.size(); i++) {
                Integer node = nodes.get(i);
                if (times[cur] + 1 > times[node]) {
                    times[node] = times[cur] + 1;
                }
                if (--inDegree[node] == 0) {
                    q[r++] = node;
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < times.length; i++) {
            ans = Math.max(times[i], ans);
        }
        System.out.println(ans);
    }

}

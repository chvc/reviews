package graph;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025-08-28 07:02:34
 */
public class Lc207 {

    static int[] in;

    static List<List<Integer>> graph;

    static Queue<Integer> queue;
    static int courseCnt;

    public static void build(int numCourse, int[][] prerequisites) {
        in = new int[numCourse];
        graph = new ArrayList<>();
        queue = new LinkedList<>();
        courseCnt = numCourse;
        for (int i = 0; i < numCourse; i++) {
            graph.add(new ArrayList<>());
        }
        // [a,b]
        for (int i = 0; i < prerequisites.length; i++) {
            List<Integer> list = graph.get(prerequisites[i][1]);
            list.add(prerequisites[i][0]);
            in[prerequisites[i][0]]++;
        }
    }

    // 拓扑排序 先把入度为0的加入到队列中去
    public static boolean topooSort() {
        int cnt = 0;
        for (int i = 0; i < in.length; i++) {
            if (in[i] == 0) {
                queue.add(i);
                cnt++;
            }
        }
        // 消除queue的影响

        while (!queue.isEmpty()) {
            // 如果队列不为空
            Integer course = queue.poll();

            // 找到他的下一个边
            for (Integer next : graph.get(course)) {
                in[next]--;
                if (in[next] == 0) {
                    queue.add(next);
                    cnt++;
                }
            }
        }
        // 什么时候返回是呢 所有的都排完了
        return courseCnt == cnt;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 建图  拓扑排序
        // 入度表
        // [1,2] [2,3]
        build(numCourses, prerequisites);
        return topooSort();
    }

    public static void main(String[] args) {
        Lc207 lc207 = new Lc207();
        lc207.canFinish(2, new int[][]{
                {
                        1, 0
                }
        });
    }

}

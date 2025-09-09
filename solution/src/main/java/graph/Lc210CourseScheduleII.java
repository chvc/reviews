package graph;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 210. 课程表 II
 *
 * @author chenghu
 * @since 2025-09-09 06:30:34
 */
public class Lc210CourseScheduleII {
    // 拓扑排序

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // 建图
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        // 准备一个入度表
        int[] inDegree = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            int[] prerequisite = prerequisites[i];
            graph.get(prerequisite[1]).add(prerequisite[0]);
            inDegree[prerequisite[0]]++;
        }
        // 准备一个队列
        int[] q = new int[2001];
        int l = 0;
        int r = 0;
        // 将入度为0的课程加入到队列中
        int[] ans = new int[numCourses];
        int cnt = 0;
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                q[r++] = i;
                ans[cnt++] = i;
            }
        }
        // 遍历队列
        while (r > l) {
            // 弹出节点
            int i = q[l++];
            List<Integer> children = graph.get(i);
            // 每个孩子的入度都减少1
            for (int j = 0; j < children.size(); j++) {
                if (--inDegree[children.get(j)] == 0) {
                    q[r++] = children.get(j);
                    ans[cnt++] = children.get(j);
                }
            }
        }
        // 收集答案
        // 如果有环那么说明完不成了
        if (cnt != numCourses) {
            return new int[0];
        } else {
            return ans;
        }
    }

    public static void main(String[] args) {
        Lc210CourseScheduleII lc210CourseScheduleII = new Lc210CourseScheduleII();
        System.out.println(Arrays.toString(lc210CourseScheduleII.findOrder(2, new int[][]{
                {1, 0}
        })));
    }
}

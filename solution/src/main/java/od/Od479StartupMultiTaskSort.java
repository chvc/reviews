package od;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

/**
 * P00022—启动多任务排序
 *
 * @author chenghu
 * @since 2025-09-09 10:25:37
 */
public class Od479StartupMultiTaskSort {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strs = sc.nextLine().split(" ");
        // 拿到任务的个数
        Map<String, Set<String>> graph = new HashMap<>();
        Map<String, Integer> in = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            String[] split = str.split("->");
            Set<String> set = graph.getOrDefault(split[1], new HashSet<>());
            set.add(split[0]);
            graph.put(split[1], set);
            in.put(split[0], in.getOrDefault(split[0], 0) + 1);
            in.put(split[1], in.getOrDefault(split[1], 0));
        }
        // 拿到了每一个的依赖关系
        Queue<String> queue = new LinkedList<>();
        for (Map.Entry<String, Integer> entry : in.entrySet()) {
            if (entry.getValue() == 0) {
                queue.add(entry.getKey());
            }
        }
        List<String> ans = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<String> tmp = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                tmp.add(queue.poll());
            }
            if (!tmp.isEmpty()) {
                tmp.sort(String::compareTo);
                ans.addAll(tmp);
            }
            for (int i = 0; i < tmp.size(); i++) {
                String s = tmp.get(i);
                Set<String> children = graph.get(s);
                if (children != null && !children.isEmpty()) {
                    for (String child : children) {
                        Integer cnt = in.getOrDefault(child, 0);
                        cnt--;
                        in.put(child, cnt);
                        if (cnt == 0) {
                            queue.add(child);
                        }
                    }
                }
            }
        }
        String out = String.join(" ", ans);
        System.out.println(out);
    }
}

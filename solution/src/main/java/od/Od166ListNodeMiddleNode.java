package od;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

/**
 * P00198-单向链表中间节点
 *
 * @author chenghu
 * @since 2025-09-06 23:08:28
 */
public class Od166ListNodeMiddleNode {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] info = s.split(" ");
        String head = info[0];
        int n = Integer.parseInt(info[1]);
        List<String[]> input = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] split = sc.nextLine().split(" ");
            input.add(split);
        }
        // 准备一张hash表
        Map<String, Integer> nodeMap = new HashMap<>();
        Map<String, String> nextMap = new HashMap<>();
        for (int i = 0; i < input.size(); i++) {
            String[] in = input.get(i);
            String u = in[0];
            int value = Integer.parseInt(in[1]);
            String v = in[2];
            nodeMap.put(u, value);
            nextMap.put(u, v);
        }
        List<Integer> listNode = new ArrayList<>();
        while (!Objects.equals(head, "-1")) {
            listNode.add(nodeMap.get(head));
            head = nextMap.get(head);
        }
        int size = listNode.size();
        int mid = size / 2;
        System.out.println(listNode.get(mid));
    }
}

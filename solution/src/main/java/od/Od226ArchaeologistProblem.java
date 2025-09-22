package od;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * #P00390—考古学家 / 考古问题
 *
 * @author chenghu
 * @since 2025-09-14 13:19:32
 */
public class Od226ArchaeologistProblem {

    static Set<String> ans = new HashSet<>();

    public static void main(String[] args) {
        ans.clear();
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String[] s = sc.nextLine().split("\\s+");
        dfs(s, 0, n);
        // 对ans进行排序
        ArrayList<String> list = new ArrayList<>(ans);
        Collections.sort(list);
        list.forEach(System.out::println);
    }

    public static void dfs(String[] s, int i, int n) {
        if (i == n) {
            // 收集答案
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < s.length; j++) {
                sb.append(s[j]);
            }
            ans.add(sb.toString());
        }
        for (int j = i; j < n; j++) {
            swap(s, i, j);
            dfs(s, i + 1, n);
            swap(s, i, j);
        }

    }

    public static void swap(String[] s, int a, int b) {
        String temp = s[a];
        s[a] = s[b];
        s[b] = temp;
    }

}

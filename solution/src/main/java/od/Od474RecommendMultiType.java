package od;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * P00199—推荐多样性
 *
 * @author chenghu
 * @since 2025-09-25 20:23:19
 */
public class Od474RecommendMultiType {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int k = Integer.parseInt(sc.nextLine());
        List<List<Integer>> lists = new ArrayList<>();
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            if (line.isEmpty()) {
                break;
            }
            List<Integer> arr = Arrays.stream(line.split(" ")).map(Integer::parseInt).collect(Collectors.toList());
            lists.add(arr);
        }
        int need = n * k;
        int cnt = 0;
        int size = lists.size();
        int[] nums = new int[size];
        List<List<Integer>> needList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            needList.add(new ArrayList<>());
        }
        int cur = 0;
        while (cnt < need) {
            cur = cur % size;
            List<Integer> list = lists.get(cur);
            int start = nums[cur];
            int len = list.size();
            int end = Math.min(start + n, len);
            for (int j = start; j < end; j++) {
                int i = cnt % n;
                List<Integer> temp = needList.get(i);
                temp.add(list.get(j));
                cnt++;
                if (cnt == need) {
                    break;
                }
            }
            nums[cur] = end;
            cur++;
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ans.addAll(needList.get(i));
        }
        System.out.println(ans.stream().map(String::valueOf).collect(Collectors.joining(" ")));
    }

    public static List<Integer> distributeElements(int n, int k, List<List<Integer>> lists) {
        int totalNeed = n * k;
        int size = lists.size();
        int cnt = 0;

        // 每个列表的当前索引
        int[] nums = new int[size];

        // 每个窗口对应的列表
        List<List<Integer>> windows = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            windows.add(new ArrayList<>());
        }

        while (cnt < totalNeed) {
            for (int cur = 0; cur < size && cnt < totalNeed; cur++) {
                List<Integer> list = lists.get(cur);
                int start = nums[cur];
                int remaining = list.size() - start;
                if (remaining <= 0) continue;

                int take = Math.min(remaining, n);
                for (int t = 0; t < take && cnt < totalNeed; t++) {
                    windows.get(t).add(list.get(start + t));
                    cnt++;
                }
                nums[cur] += take;
            }
        }

        // 展平成一个列表输出
        List<Integer> result = new ArrayList<>();
        for (List<Integer> window : windows) {
            result.addAll(window);
        }

        return result;
    }

}

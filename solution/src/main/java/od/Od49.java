package od;


import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025-08-29 17:40:47
 */
public class Od49 {

    static long ans;

    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine().trim();
        String[] nums = s.split(",");
        // 对nums进行排序
        if (nums.length == 1) {
            System.out.println(nums[0]);
            return;
        }
        ans = Long.MAX_VALUE;
        visited = new boolean[nums.length];
//        dfs(0, nums, new StringBuilder());
        Integer[] arr = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = Integer.parseInt(nums[i]);
        }
        Arrays.sort(arr);
        Integer[] num = Arrays.copyOfRange(arr, 0, Math.min(arr.length, 3));
        Arrays.sort(num, (o1, o2) -> (o1 + String.valueOf(o2)).compareTo(o2 + String.valueOf(o1)));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num.length; i++) {
            sb.append(num[i]);
        }
        System.out.println(sb.toString());
    }
    public static void dfs(int i, String[] nums, StringBuilder sb) {
        if (i == 3 || i == nums.length) {
            long l = Long.parseLong(sb.toString());
            if (l < ans) {
                ans = l;
            }
            return;
        }
        for (int j = 0; j < nums.length; j++) {
            if (visited[j]) {
                continue;
            }
            String num = nums[j];
            visited[j] = true;
            sb.append(num);
            dfs(i + 1, nums, sb);
            for (int k = 0; k < num.length(); k++) {
                sb.deleteCharAt(sb.length() - 1);
            }
            visited[j] = false;
        }
    }

}

package od;


import java.util.Scanner;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025-08-10 14:05:21
 */
public class Od10C {


    static String ans;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] arr = new int[6];
        ans = "";
        boolean[] used = new boolean[6];
        for (int i = 0; i < 6; i++) {
            arr[i] = scanner.nextInt();
        }
        dfs(arr, 0, new StringBuilder(), used);
        System.out.println(ans.isEmpty() ? "invalid" : ans.substring(0, 2) + ":" + ans.substring(2, 4) + ":" + ans.substring(4));

    }

    public static void dfs(int[] arr, int i, StringBuilder sb, boolean[] used) {

        if (i == 2 && Integer.parseInt(sb.toString()) >= 24) {
            return;
        }
        if (i == 4 && Integer.parseInt(sb.substring(2, 4)) >= 60) {
            return;
        }
        // 到结尾了
        if (i == 6) {
            if (Integer.parseInt(sb.substring(4)) >= 60) {
                return;
            }
            // 加入结果中去
            if (sb.toString().compareTo(ans) > 0) {
                ans = sb.toString();
            }
            return;
        }

        for (int j = 0; j < arr.length; j++) {
            if (!used[j]) {
                sb.append(arr[j]);
                used[j] = true;
                dfs(arr, i + 1, sb, used);
                sb.deleteCharAt(sb.length() - 1);
                used[j] = false;
            }
        }
    }


}

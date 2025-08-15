package backtrack;


import java.util.ArrayList;
import java.util.List;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025-08-10 12:58:11
 */
public class Lc949 {

    boolean[] used = new boolean[4];

    String ans = "";

    public String largestTimeFromDigits(int[] arr) {
        dfs(arr, 0, new StringBuilder());
        return ans.substring(0, 2) + ":" + ans.substring(2);
    }

    public void dfs(int[] arr, int i, StringBuilder sb) {

        // 到结尾了
        if (i == 4) {
            if (Integer.parseInt(sb.substring(2, 4)) >= 60) {
                return;
            }
            // 加入结果中去
            if (sb.toString().compareTo(ans) > 0) {
                ans = sb.toString();
            }
            return;
        }
        if (i == 2 && Integer.parseInt(sb.toString()) >= 24) {
            return;
        }
        for (int j = 0; j < arr.length; j++) {
            if (!used[j]) {
                sb.append(arr[j]);
                used[j] = true;
                dfs(arr, i + 1, sb);
                sb.deleteCharAt(sb.length() - 1);
                used[j] = false;
            }
        }
    }

    public static void main(String[] args) {
        Lc949 lc949 = new Lc949();
        System.out.println(lc949.largestTimeFromDigits(new int[]{
                1, 2, 3, 4
        }));
    }


}

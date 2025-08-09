package backtrack;

import slidewindow.Lc76;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025/8/8
 */
public class Lc767 {

    List<String> ans = new ArrayList<>();

    public String reorganizeString(String s) {
        dfs(s, 0, new StringBuilder());
        if (ans.isEmpty()) {
            return "";
        }
        List<String> res = ans.stream().filter(e -> !e.equals(s)).collect(Collectors.toList());
        if (res.isEmpty()) {
            return "";
        }
        return res.get(0);
    }

    public void dfs(String s, int index, StringBuilder sb) {
        // 如果全部排完了 那么就得到结果
        if (index == s.length()) {
            ans.add(sb.toString());
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (sb.length() == 0) {
                sb.append(c);
            } else {
                // 判断是否和前一个相同
                if (sb.charAt(sb.length() - 1) != c) {
                    sb.append(c);
                }
            }
            dfs(s, index + 1, sb);
            // 删除最后一个字符
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        Lc767 lc767 = new Lc767();
        System.out.println(lc767.reorganizeString("aaab"));
    }

}

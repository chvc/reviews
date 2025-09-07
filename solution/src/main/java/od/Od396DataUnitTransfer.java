package od;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * P00294—数据单元的变量替换
 * // todo 需要重新做
 * @author chenghu
 * @since 2025-09-06 06:44:19
 */
public class Od396DataUnitTransfer {

    static String s = "<[A-Z]+>";

    static Pattern p = Pattern.compile(s);

    static Map<String, String> refenceMap = new HashMap<>();
    static Set<Integer> refenceSet = new HashSet<>();

    public static void main(String[] args) {
        // 0--A
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] strs = input.split(",");
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            Character c = (char) ('A' + i);
            Matcher matcher = p.matcher(str);
            if ((str.contains("<") || str.contains(">"))) {
                if (!matcher.find()) {
                    System.out.println(-1);
                    return;
                } else {
                    refenceSet.add(i);
                }
            } else {
                refenceMap.put(String.valueOf(c), str);
            }
        }
        List<String> res = new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
            if (refenceSet.contains(i)) {
                String str = strs[i];
                Matcher matcher = p.matcher(str);
                while (matcher.find()) {
                    String group = matcher.group();
                    String replace = group.replace("<", "").replace(">", "");
                    String content = refenceMap.get(replace);
                    if (null==content){
                        System.out.println(-1);
                        return;
                    }
                    str = str.replaceAll(Matcher.quoteReplacement(group), content);
                    res.add(str);
                }
            } else {
                res.add(strs[i]);
            }
        }
        System.out.println(String.join(",", res));
    }
}

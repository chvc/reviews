package od;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * #P00188—告警抑制
 *
 * @author chenghu
 * @since 2025-09-07 22:46:56
 */
public class Od375WaringSuppress {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        Set<String> excluedSet = new HashSet<>();
        List<String> suppressList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            suppressList.add(sc.nextLine());
        }
        Set<String> characters = Arrays.stream(sc.nextLine().split(" ")).collect(Collectors.toSet());
        for (int i = 0; i < suppressList.size(); i++) {
            String[] split = suppressList.get(i).split(" ");
            if (characters.contains(split[0])) {
                excluedSet.add(split[1]);
            }
        }
        List<String> res = new ArrayList<>();
        for (String c : characters) {
            if (!excluedSet.contains(c)) {
                res.add(c);
            }
        }
        // 输出
        String str = String.join(" ", res);
        System.out.println(str);
    }

}

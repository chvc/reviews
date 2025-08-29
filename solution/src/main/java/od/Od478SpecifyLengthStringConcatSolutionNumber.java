package od;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 *  P00351—字符串拼接
 *
 * @author chenghu
 * @since 2025/8/8
 */
public class Od478SpecifyLengthStringConcatSolutionNumber {

    static int cnt = 0;
    static int n = 0;

    static boolean[] used = new boolean[31];

    static Set<String> set = new HashSet<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] input = s.split(" ");
        String chars = input[0];
        n = Integer.parseInt(input[1]);
        if (n > chars.length()) {
            System.out.println(0);
        } else {
            arrange(chars, 0, new StringBuffer());
            System.out.println(set.size());
        }
    }

    public static void arrange(String chars, int j, StringBuffer path) {
        if (path.length() == n) {
            cnt++;
            set.add(path.toString());
            return;
        }

        for (int i = 0; i < chars.length(); i++) {
            // 没有被使用 才能使用
            if (!used[i]) {
                char c = chars.charAt(i);
                if (j > 0) {
                    if (path.charAt(j - 1) == c) {
                        continue;
                    }
                }
                path.append(c);
                used[i] = true;
                arrange(chars, j + 1, path);
                used[i] = false;
                path.deleteCharAt(path.length() - 1);
            }
        }
    }


}

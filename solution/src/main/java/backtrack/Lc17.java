package backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025/7/29
 */
public class Lc17 {

    String[] letterMap =
            new String[]{
                    " ",
                    "",
                    "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
            };

    List<String> res = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        int length = digits.length();
        char[] path = new char[length];
        letterCombinations(digits, 0, path);
        return res;
    }

    public void letterCombinations(String digits, int index, char[] path) {
        if (index == digits.length()) {
            res.add(new String(path));
            return;
        }
        String str = letterMap[digits.charAt(index) - '0'];
        for (int i = 0; i < str.length(); i++) {
            path[index] = str.charAt(i);
            letterCombinations(digits, index + 1, path);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Lc17().letterCombinations(""));
    }

}

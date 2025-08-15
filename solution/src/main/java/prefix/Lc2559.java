package prefix;


import java.util.Arrays;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025-08-09 20:49:50
 */
public class Lc2559 {
    int[] ans;

    public int[] vowelStrings(String[] words, int[][] queries) {
        ans = new int[words.length + 1];
        // [0,1,1,2,3,4]
        for (int i = 0; i < words.length; i++) {
            int cnt = 0;
            if (matched(words[i])) {
                cnt = 1;
            }
            ans[i + 1] = ans[i] + cnt;
        }
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            res[i] = ans[queries[i][1]] - ans[queries[i][0]];
        }
        return res;
    }

    public boolean matched(String word) {
        return (word.charAt(0) == 'a' || word.charAt(0) == 'e' || word.charAt(0) == 'i' || word.charAt(0) == 'o'
                || word.charAt(0) == 'u')
                && (word.charAt(word.length() - 1) == 'a' || word.charAt(word.length() - 1) == 'e'
                || word.charAt(word.length() - 1) == 'i' || word.charAt(word.length() - 1) == 'o'
                || word.charAt(word.length() - 1) == 'u');
    }

    public static void main(String[] args) {
        Lc2559 lc2559 = new Lc2559();
//        System.out.println(Arrays.toString(lc2559.vowelStrings(new String[]{
//                "aba", "bcb", "ece", "aa", "e"
//        }, new int[][]{
//                {0, 2}, {1, 4}, {1, 1}
//        })));


    }

}

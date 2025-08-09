package array;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025/8/8
 */
public class Lc1128 {

    Map<String, Integer> map = new HashMap<>();
    int ans = 0;

    public int numEquivDominoPairs(int[][] dominoes) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < dominoes.length; i++) {
            int pre = dominoes[i][0];
            int suf = dominoes[i][1];
            if (pre <= suf) {
                sb.append(pre).append(suf);
            } else {
                sb.append(suf).append(pre);
            }
            String key = sb.toString();
            if (map.containsKey(key)) {
                int cnt = map.get(key);
                ans += cnt;
                map.put(key, cnt + 1);
            } else {
                map.put(key, 1);
            }
            sb.delete(0, 2);
        }
        return ans;
    }


    public static void main(String[] args) {
//        Lc1128 lc1128 = new Lc1128();
//        System.out.println(lc1128.numEquivDominoPairs(new int[][]{
//                {1, 2}, {1, 2}, {1, 1}, {1, 2}, {2, 2}
//        }));
        System.out.println(Objects.hash(1, 2) + "----" + Objects.hash(2, 1));
    }
}

package slidewindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025/7/26
 */
public class Lc438 {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (Character c : p.toCharArray()) {
            need.compute(c, (k, v) -> v == null ? 1 : v + 1);
        }
        int l = 0;
        int r = 0;
        boolean isValid = false;
        while (l < s.length()) {
            if (r + 1 <= s.length() && !isValid) {
                window.compute(s.charAt(r), (k, v) -> v == null ? 1 : v + 1);
                // 判断两个Map一致
                r++;
            } else {
                window.compute(s.charAt(l), (k, v) -> v == null ? 1 : v - 1);
                l++;
            }
            if (contains(window, need)) {
                isValid = true;
                if (isAna(window, need)) {
                    res.add(l);
                }

            } else {
                isValid = false;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        printList(new Lc438().findAnagrams("cbaebabacd", "abc"));
    }

    public static void printList(List list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }


    public boolean contains(Map<Character, Integer> win, Map<Character, Integer> need) {
        for (Map.Entry<Character, Integer> e : need.entrySet()) {
            Integer value = e.getValue();
            Character key = e.getKey();
            if (!win.containsKey(key)) {
                return false;
            }
            Integer i = win.get(key);
            if (i < value) {
                return false;
            }
        }
        return true;
    }

    public boolean isAna(Map<Character, Integer> win, Map<Character, Integer> need) {
        for (Map.Entry<Character, Integer> e : win.entrySet()) {
            Integer value = e.getValue();
            if (value == 0) {
                continue;
            }
            Character key = e.getKey();
            if (!win.containsKey(key)) {
                return false;
            }
            Integer i = need.get(key);
            if (!Objects.equals(i, value)) {
                return false;
            }
        }
        return true;
    }

    public boolean isAna(String s1, String s2) {
        char[] ca1 = s1.toCharArray();
        char[] ca2 = s2.toCharArray();
        Arrays.sort(ca1);
        Arrays.sort(ca2);
        String s = new String(ca1);
        String p = new String(ca2);
        return s.equals(p);
    }

}

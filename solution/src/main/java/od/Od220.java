package od;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025-08-25 21:33:48
 */
public class Od220 {
    static Map<Character, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        map.clear();
        String str = scanner.nextLine();
        String[] split = str.split(" ");
        String s = split[0];
        char[] charArray = s.toCharArray();
        int k = Integer.parseInt(split[1]);
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < charArray.length; i++) {
            if (!map.containsKey(charArray[i])) {
                map.put(charArray[i], i);
            }
            list.add(charArray[i]);
        }
        // 对 s进行排序
        Collections.sort(list, new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                if (Character.isLetter(o1) && Character.isLetter(o2)) {
                    return o1 - o2;
                }
                if (Character.isLetter(o1) && !Character.isLetter(o2)) {
                    return o1 - o2;
                }
                if (Character.isLetter(o2) && !Character.isLetter(o1)) {
                    return o2 - o1;
                }
                if (!Character.isLetter(o2) && !Character.isLetter(o1)) {
                    return o1 - o2;
                }
                return 0;
            }
        });
        Character c = list.get(k - 1);
        System.out.println(map.get(c));

    }

}

package od;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * P00248—德州扑克
 *
 * @author chenghu
 * @since 2025-08-27 19:57:25
 */
public class Od286TexasHoldPoker {

    /**
     * 五张牌，每张牌由牌大小和花色组成，牌大小2~10、J 、Q、 K、A，牌花色为红桃、黑桃、梅花、方块四种花色之一
     * 判断牌型：
     * 牌型1，同花顺：同一花色的顺子，如红桃2红桃3红桃4红桃5红桃6
     * 牌型2，四条：四张相同数字+ 单张，如红桃A黑桃A梅花A方块A+黑桃K
     * 牌型3，葫芦：三张相同数字+ 一对，如红桃5黑桃5梅花5 +方块9梅花9
     * 牌型4，同花：同一花色，如方块3方块7方块10方块J方块Q
     * 牌型5，顺子：花色不一样的顺子，如红桃2黑桃3红桃4红桃5方块6
     * 牌型6，三条：三张相同+两张单
     * 说明：
     * 1、五张牌里不会出现牌大小和花色完全相同的牌
     * 2、编号小的牌型较大，如同花顺比四条大，依次类推
     * 3、包含A的合法的顺子只有10 J Q K A和A 2 3 4 5 ；类似K A 2 3 4的序列不认为是顺子
     *
     * 4 H
     * 5 S
     * 6 C
     * 7 D
     * 8 D
     */

    static boolean[] card;

    static Map<String, Integer> mapping = new HashMap<String, Integer>() {
        {
            put("A", 0);
            put("2", 1);
            put("3", 2);
            put("4", 3);
            put("5", 4);
            put("6", 5);
            put("7", 6);
            put("8", 7);
            put("9", 8);
            put("10", 9);
            put("J", 10);
            put("Q", 11);
            put("K", 12);
        }
    };

    static Map<Character, Integer> map = new HashMap<Character, Integer>() {
        {
            put('S', 0);
            put('H', 1);
            put('C', 2);
            put('D', 3);
        }
    };

    static Set<Integer> set = new HashSet<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 5个输入
        card = new boolean[52];
        set.clear();
        for (int i = 0; i < 5; i++) {
            String s = sc.nextLine().trim();
            int k = calIndex(s);
            card[k] = true;
            set.add(k);
        }
        // 判断牌型
        boolean fourFlag = judgeFour();
        int judge = judge();
        // 如果是同花顺
        if (judge == 5 && fourFlag) {
            System.out.println(1);
            return;
        }
        if (judge <= 3) {
            System.out.println(judge);
            return;
        }
        // 判断是不是2
        if (judge > 4 && fourFlag) {
            System.out.println(4);
            return;
        }
        System.out.println(judge);
    }

    public static int calIndex(String in) {
        // 黑红梅方
        // 0 1 2 3
        String[] split = in.split(" ");
        String c1 = split[0];
        char c2 = split[1].charAt(0);
        // 5个输入
        return map.get(c2) * 13 + mapping.get(c1);
    }

    // 判断是不是同花
    public static boolean judgeFour() {
        // 同花就是 判断除以13是不是都相等
        int x = -1;
        for (Integer i : set) {
            if (x == -1) {
                x = i / 13;
            } else {
                if (i / 13 != x) {
                    return false;
                } else {
                    x = i / 13;
                }
            }
        }
        return true;
    }

    // 判断是不是顺子
    public static int judge() {
        // 1 顺子
        // 2 四条
        // 判断 是不是挨着的 mod 13 是不是挨着的
        // 特判 含A的
        List<Integer> list = new ArrayList<>();
        for (Integer i : set) {
            list.add(i % 13);
        }
        // 含有 A2345
        if (list.contains(0) && list.contains(1) && list.contains(2) && list.contains(3) && list.contains(4)) {
            return 5;
        }
        // 10 J Q K A
        if (list.contains(0) && list.contains(9) && list.contains(10) && list.contains(11) && list.contains(12)) {
            return 5;
        }
        // 判断是不是 四条
        Collections.sort(list);
        boolean fiveFlag = true;
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            if (i != list.size() - 1) {
                if (list.get(i + 1) - list.get(i) != 1) {
                    fiveFlag = false;
                }
            }
            freqMap.put(list.get(i), freqMap.getOrDefault(list.get(i), 0) + 1);
        }
        boolean TwoFlag = false;
        boolean ThreeFlag = false;
        boolean SixFlag = false;
        // 只有两个数
        List<Integer> vals = new ArrayList<>(freqMap.values());
        vals.sort((o1, o2) -> o2 - o1);
        if (freqMap.size() == 2) {
            if (vals.get(0) == 4 && vals.get(1) == 1) {
                TwoFlag = true;
            }
            if (vals.get(0) == 3 && vals.get(1) == 2) {
                ThreeFlag = true;
            }
        }
        if (freqMap.size() == 3) {
            if (vals.get(0) == 3 && vals.get(1) == 1 && vals.get(2) == 1) {
                SixFlag = true;
            }
        }
        if (TwoFlag) {
            return 2;
        }
        if (ThreeFlag) {
            return 3;
        }
        if (fiveFlag) {
            return 5;
        }
        if (SixFlag) {
            return 6;
        }
        return 7;
    }


}

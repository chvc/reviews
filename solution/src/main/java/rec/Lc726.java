package rec;


import sun.reflect.generics.tree.Tree;

import java.util.Map;
import java.util.TreeMap;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025-08-13 14:07:51
 */
public class Lc726 {

    int where;

    public String countOfAtoms(String formula) {
        // 遇到大写字母和右括号就要收集答案
        TreeMap<String, Integer> map = f(formula.toCharArray(), 0);
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            sb.append(key);
            Integer value = entry.getValue();
            if (value > 1) {
                sb.append(value);
            }
        }
        return sb.toString();
    }

    public TreeMap<String, Integer> f(char[] formulas, int i) {
        // 遇到大写字母和(括号就要收集答案
        //
        StringBuilder name = new StringBuilder();
        TreeMap<String, Integer> record = new TreeMap<>();
        TreeMap<String, Integer> res = new TreeMap<>();
        int count = 0;
        while (i < formulas.length && formulas[i] != ')') {
            if (formulas[i] == '(') {
                merge(name, count, record, res);
                count = 0;
                res = null;
                name.setLength(0);
                res = f(formulas, i + 1);
                i = where + 1;
            } else {
                // 有可能是数字 有可能是大写字母
                if (formulas[i] - '0' >= 0 && formulas[i] - '0' <= 9) {
                    // 数字
                    count = count * 10 + formulas[i] - '0';
                } else if (formulas[i] >= 'a' && formulas[i] <= 'z') {
                    // 小写字母 那名字就要拼接了
                    name.append(formulas[i]);
                } else {
                    // 大写字母 那就要合并结果了
                    merge(name, count, record, res);
                    count = 0;
                    res = null;
                    name.setLength(0);
                    // 清除之前的 name
                    name.append(formulas[i]);
                }
                i++;
            }
        }
        merge(name, count, record, res);
        where = i;
        return record;
    }

    public void merge(StringBuilder name, int count, TreeMap<String, Integer> record, TreeMap<String, Integer> res) {
        int cnt = count == 0 ? 1 : count;
        if (!name.toString().isEmpty() || res != null) {
            if (res != null && !res.isEmpty()) {
                for (Map.Entry<String, Integer> entry : res.entrySet()) {
                    String key = entry.getKey();
                    Integer value = entry.getValue();
                    record.put(key, record.getOrDefault(key, 0) + cnt * value);
                }
            } else {
                if (!name.toString().isEmpty()) {
                    record.put(name.toString(), record.getOrDefault(name.toString(), 0) + cnt);
                }
            }
        }
    }

    public static void main(String[] args) {
        Lc726 lc726 = new Lc726();
//        System.out.println(lc726.countOfAtoms("H2O"));
//        System.out.println(lc726.countOfAtoms("Mg(OH)2"));
        System.out.println(lc726.countOfAtoms("Mg(H2O)N"));
    }

}

package binarysearch;

import java.util.HashMap;
import java.util.Map;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025/7/27
 */
public class Lc904 {
    public int totalFruit(int[] fruits) {
        int l = 0;
        int r = 0;
        int res = 0;
        Map<Integer, Integer> lz = new HashMap<>();
        while (r < fruits.length) {
            lz.compute(fruits[r], (k, v) -> v == null ? 1 : v + 1);
            if (lz.size()<=2) {
                r++;
            } else {
                lz.compute(fruits[l], (k, v) -> v == null ? 1 : v - 1);
                if (lz.get(fruits[l]) <= 0) {
                   lz.remove(fruits[l]);
                }
                l++;
                r++;
            }
            if (lz.size() <= 2) {
                res = Math.max(res,r-l);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Lc904().totalFruit(new int[]{
                3,3,3,1,2,1,1,2,3,3,4
        }));
    }

    public static boolean canPick(Map<Integer, Integer> lz, Integer fruit) {
        if (lz.size() < 2) {
            return true;
        } else {
            if (lz.size() == 2) {
                if (lz.containsKey(fruit)) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }



}

package binarysearch;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025/7/28
 */
public class Lc2824 {

    public int countPairs(List<Integer> nums, int target) {
        Collections.sort(nums);
        int res = 0;
        int l = 0;
        int r = nums.size() - 1;
        boolean isFirstFind = false;
        while (l < r && !isFirstFind) {
            Integer i1 = nums.get(l);
            Integer i2 = nums.get(r);
            if (i1 + i2 >= target) {
                r--;
            }else {
                isFirstFind = true;
            }
        }
        res = r-l;
        return res;
    }

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(-6,2,5,-2,-7,-1,3);
        System.out.println(new Lc2824().countPairs(list,-2));
    }

}

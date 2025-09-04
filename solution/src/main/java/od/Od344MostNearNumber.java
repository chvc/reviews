package od;


import sun.font.FontRunIterator;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

/**
 *  P00171—计算最接近的数
 *
 * @author chenghu
 * @since 2025-09-04 21:59:35
 */
public class Od344MostNearNumber {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int i = s.lastIndexOf(",");
        String ks = s.substring(i + 1);
        ks = ks.replaceAll(" ", "");
        int k = Integer.parseInt(ks);
        String ns = s.substring(1, i - 1);
        int[] nums = Arrays.stream(ns.split(",")).mapToInt(Integer::parseInt).toArray();
        int[] sort = Arrays.copyOfRange(nums, 0, nums.length);
        Arrays.sort(sort);
        // 中位数
        int n = nums.length;
        int num = sort[n / 2];
        //
        int ans = Integer.MAX_VALUE;
        int res = -1;
        for (int j = 0; j + k - 1 < n; j++) {
            // 最接近 就是绝对值
            int x = nums[j];
            for (int l = j + 1; l <= j + k - 1; l++) {
                x = x - nums[l];
            }
            if (Math.abs(x - num) <= ans) {
                ans = Math.abs(x - num);
                res = j;
            }
        }
        System.out.println(res);
    }

}

package od;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * P00181—第k个排列
 * //todo 有更好的实现
 * @author chenghu
 * @since 2025-09-05 01:00:28
 */
public class Od11KthArrangement {

    static int count;

    static int k;

    static StringBuilder sb = new StringBuilder();

    static List<Integer> ans = new ArrayList<>();


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        k = sc.nextInt();
        // 直接进行全排列
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }
        dfs(nums, 0);
        Collections.sort(ans);
        System.out.println(ans.get(k-1));
        count = 0;
    }

    public static void dfs(int[] nums, int i) {
        // 0要丢掉不用
        if (i == nums.length) {
            // 统计一个结果
            for (int j = 0; j < nums.length; j++) {
                sb.append(nums[j]);
            }
            ans.add(Integer.parseInt(sb.toString()));
            sb.setLength(0);
            return;
        }
        //
        for (int j = i; j < nums.length; j++) {
            // 交换数据
            swap(nums, i, j);
            dfs(nums, i + 1);
            swap(nums, i, j);
        }
    }

    public static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }


}

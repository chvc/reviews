package od;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;


public class Od395A {

    static int[] nums;

    static int[] left;

    static int[] right;

    static int ans = Integer.MAX_VALUE;

    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();
        nums = Arrays.stream(str.trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        if (nums.length < 3) {
            System.out.println(-1);
            return;
        }
        // 在nums上做二分
        stack.clear();
        // 找当前元素的左边的最近的比他小的元素
        left = new int[nums.length];
        right = new int[nums.length];
        Arrays.fill(left, -1);
        Arrays.fill(right, -1);
        int  ans = Integer.MAX_VALUE;
        // 单调递增
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] >= nums[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                left[i] = stack.peek();
            }
            stack.push(i);
        }
        stack.clear();
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] >= nums[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                right[i] = stack.peek();
            }
            stack.push(i);
        }

        int minDistance = Integer.MAX_VALUE;

        // 遍历每个 j，找左边 i 和右边 k
        for (int j = 0; j < nums.length; j++) {
            if (left[j] != -1 && right[j] != -1) {
                ans = Math.min(minDistance, right[j] - left[j]);
            }
        }
        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
    }


}

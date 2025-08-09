package twopointer;

import java.util.Arrays;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025/8/2
 */
public class Lc238 {

    public int[] productExceptSelf(int[] nums) {

        if (nums.length == 2) {
            return new int[]{
                    nums[1], nums[0]
            };
        }
        int[] answer = new int[nums.length];
        int[] preVal = new int[nums.length];
        int[] sufVal = new int[nums.length];
        int res = 1;
        for (int i = 0; i < nums.length; i++) {
            res = res * nums[i];
            preVal[i] = (res);
        }
        res = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            res = res * nums[i];
            sufVal[i] = res;
            i++;
        }
        int r = nums.length - 1;
        int preSum = 1;
        int sufSum = 1;
        int l = 0;
        while (l <= r) {
            if (l == r) {
                answer[l] = preSum * sufSum;
            } else {
                answer[r] = preVal[r - 1];
                preSum = preSum * nums[r];
                preVal[r - 2] = preVal[r - 2] * preSum;

                answer[l] = sufVal[l + 1];
                sufSum = sufSum * nums[l];
                sufVal[l + 2] = sufVal[l + 2] * sufSum;
            }
            r--;
            l++;
        }
        return answer;
    }

    public static void main(String[] args) {
        Lc238 lc238 = new Lc238();
        System.out.println(Arrays.toString(lc238.productExceptSelf(new int[]{
                4, 3, 2, 1, 2
        })));
    }

}

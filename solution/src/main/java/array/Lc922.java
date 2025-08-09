package array;

import java.util.Arrays;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025/7/29
 */
public class Lc922 {




    public int[] sortArrayByParityII(int[] nums) {
        int evenIndex = 0;
        int oddIndex = 1;
        for (int i = 0; i < nums.length ; i++) {
            if (nums[i] % 2 == 0) {
                // 如果是偶数索引 那么就直接移动指针 不交换

                    swap(nums, i, evenIndex);
                    evenIndex = evenIndex + 2;

            }
        }

        return nums;
    }

    public void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Lc922().sortArrayByParityII(new int[]{
                2,0,3,4,1,3
        })));
    }

}

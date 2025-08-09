/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2024/9/1
 */
public class SelectColor {

    public static void main(String[] args) {
        int[] arr = {2, 0, 1};
        new SelectColor().sortColors(arr);
    }

    public void sortColors(int[] nums) {
        // [zero, i-1] 0
        // [i,two-1] 1
        // [two...] 2
        int zero = 0;
        int two = nums.length - 1;
        int i = 0;
        if (i < two) {
            if (nums[i] == 0) {
                swap(nums, i, zero);
                zero++;
                i++;
            } else if (nums[i] == 1) {
                i++;
            } else {
                swap(nums, i, two);
                two--;
            }
        }
    }


    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}

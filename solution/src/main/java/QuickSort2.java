import java.util.Random;

class QuickSort2 {

    public static void main(String[] args) {
        QuickSort2 quickSort2 = new QuickSort2();
        int[] nums = {-4, 0, 7, 4, 9, -5, -1, 0, -7, -1};
        quickSort2.sortArray(nums);
        Random rd = new Random();
        int idx = rd.nextInt(10) + 0;
        System.out.println(idx);
    }

    Random rd = new Random();

    public int[] sortArray(int[] nums) {
        sort(nums, 0, nums.length - 1);
        return nums;
    }

    public void sort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int less = left;
        int i = left;
        int great = right;
        int idx = rd.nextInt(right - left + 1) + left;

        while (i <= great) {
            if (arr[i] < arr[idx]) {
                swap(arr, i, less);
                less++;
                i++;
            } else if (arr[i] > arr[idx]) {
                swap(arr, i, great);
                great--;
            } else {
                i++;
            }
        }
        sort(arr, left, less - 1);
        sort(arr, great + 1, right);
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
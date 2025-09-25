package listnode;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025/7/31
 */
public class Lc189 {
    public void rotate(int[] nums, int k) {
        // 原地实现
        int pre = 0;
        int next = -1;
        if (k == 0) {
            return;
        }
        int round = gcd(nums.length, k);
        // 正好成了圈的话
        // 交换前k个元素
        for (int i = 0; i < round; i++) {
            pre = i;
            while (next != i) {
                int temp = nums[i];
                next = (pre + k) % nums.length;
                nums[i] = nums[next];
                nums[next] = temp;
                pre = next;
            }
        }
    }

    public int gcd(int n, int k) {
        while (n % k != 0) {
            int mod = n % k;
            n = k;
            k = mod;
        }
        return k;
    }


    // [1,2,3,4,5,6,7] 3
    // [4,2,3,1,5,6,7]
    // [4,6,]
    // [7,2,3,1,5,6,4]
    // [5,6,7,1,2,3,4]
    // [-1,-100,3,99]

    // 0-->3
    // 1-->4
    // 2-->5  i --> (i+k) / len
    // 7--> (6+3) / 7 ==>2

    public void rotate2(int[] nums, int k) {
        // 每一个数 都往右移动k个数字
        int[] res = new int[nums.length];

        int n = nums.length;
        for (int i = 0; i < n; i++) {
            res[(i + k) % n] = nums[i];
        }
        for (int i = 0; i < n; i++) {
            nums[i] = res[i];
        }
    }

    public void rotate3(int[] nums, int k) {
        // 每一个数 都往右移动k个数字
        int n = nums.length;
        k = k % n;
        reverseNums(nums, 0, n - 1);
        reverseNums(nums, 0, k - 1);
        reverseNums(nums, k, n - 1);
    }

    public void reverseNums(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    public void swap(int[] nums, int start, int end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }

    public static void main(String[] args) {
        new Lc189().rotate2(new int[]{
                1, 2, 3, 4, 5, 6, 7
        }, 3);
        System.out.println(new Lc189().gcd(4, 6));
        // [5,2,3,4,1,6]
        // [3,2,5,4,1,6]
        // [2,4,3,5,1,6]
        // [6,4,3,5,1,2]
        // [5,4,3,6,1,2]
        // [3,4,5,6,1,2]
        // [3,4,5,6,1,2]
    }


}

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
        int l = 0;
        k = k % nums.length;
        int r = nums.length - k - 1;
        while (r < nums.length - 1) {
            int temp = nums[++r];
            int templ = nums[l];
            nums[l++] = temp;
            nums[r] = templ;
        }
        // [3,2,1,4,5,6 ]
        // [3,4,1,2,5,6]
        // [3,4,5,2,1,6]
        // [3,4,5,6,1,2]
    }

    public static void main(String[] args) {
        new Lc189().rotate2(new int[]{
                1,2,3,4,5,6,7
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

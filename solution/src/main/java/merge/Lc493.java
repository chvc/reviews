package merge;


import static com.sun.deploy.net.MessageHeader.merge;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025-08-25 19:50:13
 */
public class Lc493 {

    /**
     * 给定一个数组 nums ，如果 i < j 且 nums[i] > 2*nums[j] 我们就将 (i, j) 称作一个重要翻转对。
     * <p>
     * 你需要返回给定数组中的重要翻转对的数量。
     * <p>
     * 示例 1:
     * <p>
     * 输入: [1,3,2,3,1]
     * 输出: 2
     * 示例 2:
     * <p>
     * 输入: [2,4,3,5,1]
     * 输出: 3
     * 注意:
     * <p>
     * 给定数组的长度不会超过50000。
     * 输入数组中的所有数字都在32位整数的表示范围内。
     */
    static int MAXN = 5001;

    static int[] help;
    static int[] arr;

    public static void main(String[] args) {
        Lc493 lc493 = new Lc493();
        System.out.println(lc493.reversePairs(new int[]{
                1, 3, 2, 3, 1
        }));
    }

    public int reversePairs(int[] nums) {
        help = new int[nums.length];
        arr = nums;
        return f(0, nums.length - 1);
    }

    public int f(int l, int r) {
        if (l == r) {
            return 0;
        }
        int m = (l + r) / 2;
        return f(l, m) + f(m + 1, r) + merge(l, m, r);
    }

    private int merge(int l, int m, int r) {

        int ans = 0;
        // 比较左右两边的
        for (int i = l, j = m + 1, temp = 0; i <= m; i++) {
            while (j <= r && (long) arr[i] > (long) (arr[j] * 2L)) {
                j++;
            }
            temp = j - (m + 1);
            ans += temp;
        }

        // 进行归并排序
        int a = l;
        int b = m + 1;
        int k = l;
        while (a <= m && b <= r) {
            if (arr[a] <= arr[b]) {
                help[k] = arr[a];
                k++;
                a++;
            } else {
                help[k] = arr[b];
                k++;
                b++;
            }
        }
        while (a <= m) {
            help[k++] = arr[a++];
        }
        while (b <= r) {
            help[k++] = arr[b++];
        }
        for (int n = l; n <= r; n++) {
            arr[n] = help[n];
        }
        return ans;
    }


}

package binarysearch;


import java.util.Arrays;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025-08-15 20:57:47
 */
public class Lc1385 {

    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);
        int cnt = 0;
        for (int i = 0; i < arr1.length; i++) {
            int lowerIndex = searchLower(arr2, arr1[i] - d);
            if (lowerIndex == -1 || arr2[lowerIndex] > arr1[i] + d) {
                cnt++;
            }
        }
        return cnt;
    }

    //  所有数都要大于 target 或者小于 target
    public int searchUpper(int[] arr2, int target) {
        int l = 0;
        int r = arr2.length - 1;
        int ans = -1;
        while (l <= r) {
            int m = (l + r) >> 1;
            if (arr2[m] < target) {
                ans = m;
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return ans;
    }

    // arr[i]-d<=arr[j]<=arr[i]+d

    public int searchLower(int[] arr2, int target) {
        int l = 0;
        int r = arr2.length;
        int ans = -1;
        while (l < r) {
            int m = (l + r) >> 1;
            if (arr2[m] >= target) {
                ans = m;
                r = m;
            } else {
                l = m + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Lc1385 lc1385 = new Lc1385();
        System.out.println(lc1385.findTheDistanceValue(new int[]{
                1, 4, 2, 3
        }, new int[]{
                -4, -3, 6, 10, 20, 30
        }, 3));
    }


}

package greedy;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025-08-16 09:53:49
 */
public class Lc870 {

    Map<Integer, Integer> map = new HashMap<>();

    public int[] advantageCount(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] result = new int[n];
        int[] array = Arrays.copyOf(nums2, n);
        Arrays.sort(array);
        Arrays.sort(nums1);
        int l1 = 0;
        int r1 = n - 1;
        int l2 = 0;
        int r2 = n - 1;
        while (l1 <= r1) {
            // 从最大开始比较 如果 最大的比他大 就使用
            if (nums1[r1] > array[r2]) {
                map.put(array[r2], nums1[r1]);
                r1--;
                r2--;
            } else if (nums1[r1] < array[r2]) {
                // 比他小 就弄最小的过来
                map.put(array[r2], nums1[l1]);
                l1++;
                r2--;
            } else {
                // 比较 最小的 如果 最小比最小的大 那么也用最小的 否则就把最小的跟最大的比较
                if (nums1[l1] > array[l2]) {
                    map.put(array[l2], nums1[l1]);
                    l1++;
                    l2++;
                } else if (nums1[l1] < array[l2]) {
                    map.put(array[r2], nums1[l1]);
                    l1++;
                    r2--;
                } else {
                    // 如果都相等的话 那就都加减
                    map.put(array[r2], nums1[r1]);
                    r2--;
                    r1--;
                    map.put(array[l2], nums1[l1]);
                    l2++;
                    l1++;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            Integer x = map.get(nums2[i]);
            result[i] = x;
        }
        return result;
    }

    public static void main(String[] args) {
        Lc870 lc870 = new Lc870();
        System.out.println(Arrays.toString(lc870.advantageCount(new int[]{
                2, 0, 4, 1, 2
        }, new int[]{
                1, 3, 0, 0, 2
        })));
    }


}

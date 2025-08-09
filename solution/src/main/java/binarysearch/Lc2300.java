package binarysearch;

import java.util.Arrays;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025/7/28
 */
public class Lc2300 {

    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        //
        int[] paris = new int[spells.length];
        for (int i = 0; i < spells.length; i++) {
            int l = 0;
            int r = potions.length - 1;
            while (l <= r) {
                int mid = (r - l) / 2 + l;
                if ((long) spells[i] * potions[mid] >= success) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            paris[i] = potions.length - l;
        }
        return paris;
    }

    public static void main(String[] args) {
        int[] spells = {5, 1, 3};
        int[] positions = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(new Lc2300().successfulPairs(spells, positions, 7)));
    }

}

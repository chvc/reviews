package binarysearch;

import java.util.Arrays;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025/7/26
 */
public class Lc881 {

    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int l = 0;
        int r = people.length - 1;
        int count = 0;
        while (l <= r) {
            if (people[r] >= limit) {
                count++;
                r--;
                continue;
            }
            if (people[l] + people[r] > limit) {
                count++;
                r--;
                continue;
            }
            if (people[l] + people[r] < limit) {
                count++;
                l++;
                continue;
            }
            if (people[l] + people[r] == limit) {
                count++;
                r--;
                l++;
            }

        }
        return count;
    }

    public static void main(String[] args) {
        int[] people = {2,2};
        int limit = 6;
        new Lc881().numRescueBoats(people, limit);
    }


}

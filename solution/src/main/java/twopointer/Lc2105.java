package twopointer;


/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025-08-13 13:22:36
 */
public class Lc2105 {


    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int ans = 0;
        int l = 0;
        int r = plants.length - 1;
        int maxCapA = capacityA;
        int maxCapB = capacityB;
        while (l <= r) {
            if (l == r) {
                if (capacityA == capacityB) {
                    if (plants[l] > capacityA) {
                        int cap = plants[l];
                        int cnt = 0;
                        while (cap > capacityA) {
                            cap = cap - capacityA;
                            capacityA = maxCapA;
                            cnt++;
                        }
                        ans += cnt;
                    }
                } else {
                    if (capacityA > capacityB) {
                        if (plants[l] > capacityA) {
                            int cap = plants[l];
                            int cnt = 0;
                            while (cap > capacityA) {
                                cap = cap - capacityA;
                                capacityA = maxCapA;
                                cnt++;
                            }
                            ans += cnt;
                        }
                    } else {
                        if (plants[l] > capacityB) {
                            int cap = plants[l];
                            int cnt = 0;
                            while (cap > capacityB) {
                                cap = cap - capacityB;
                                capacityB = maxCapB;
                                cnt++;
                            }
                            ans += cnt;
                        }
                    }
                }
                l++;
                r--;
            } else {
                if (capacityA > plants[l]) {
                    capacityA = capacityA - plants[l];
                    l++;
                } else {
                    int cap = plants[l];
                    int cnt = 0;
                    while (cap > capacityA) {
                        cap = cap - capacityA;
                        capacityA = maxCapA;
                        cnt++;
                    }
                    capacityA = capacityA - plants[l];
                    ans += cnt;
                    l++;
                }
                if (capacityB > plants[r]) {
                    capacityB = capacityB - plants[r];
                    r--;
                } else {
                    int cap = plants[r];
                    int cnt = 0;
                    while (cap > capacityB) {
                        cap = cap - capacityB;
                        capacityB = maxCapB;
                        cnt++;
                    }
                    capacityB = capacityB - plants[r];
                    ans += cnt;
                    r--;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Lc2105 lc2105 = new Lc2105();
        System.out.println(lc2105.minimumRefill(new int[]{
                7, 7, 7, 7, 7, 7, 7
        }, 7, 8));
    }

}

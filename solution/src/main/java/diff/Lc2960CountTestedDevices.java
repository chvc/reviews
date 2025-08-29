package diff;


/**
 * 统计已测试设备
 *
 * @author chenghu
 * @since 2025-08-30 03:59:09
 */
public class Lc2960CountTestedDevices {


    public int countTestedDevices(int[] batteryPercentages) {
        int n = batteryPercentages.length;
        int[] diff = new int[n + 1];
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (batteryPercentages[i] > cnt) {
                diff[i + 1]++;
                diff[n]--;
                cnt++;
            }
        }
        for (int i = 1; i < diff.length; i++) {
            diff[i] += diff[i - 1];
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (batteryPercentages[i] > diff[i]) {
                ans++;
            }
        }
        System.out.println(cnt);
        return ans;
    }

    public static void main(String[] args) {
        Lc2960CountTestedDevices lc2960 = new Lc2960CountTestedDevices();
        System.out.println(lc2960.countTestedDevices(new int[]{
                1, 1, 2, 1, 3
        }));
    }


}

package math;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025/8/18
 */
public class Lc204 {
    public int countPrimes(int n) {
        boolean[] isPrime = new boolean[n];
        for (int i = 2; i < n; i++) {
            if (!isPrime[i]) {
                for (long j = (long) i * i; j < n; j = j + i) {
                    isPrime[(int) j] = true;
                }
            }
        }
        int cnt = 0;
        for (int i = 2; i < isPrime.length; i++) {
            if (!isPrime[i]) {
                cnt++;
            }
        }
        return cnt;
    }

}

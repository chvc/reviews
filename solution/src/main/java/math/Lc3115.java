package math;


/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025-08-10 18:28:57
 */
public class Lc3115 {

    int[] prime = new int[101];

    public int maximumPrimeDifference(int[] nums) {
        prime[1] = 2;
        int start = -1;
        int end = -1;
        for (int i = 0; i < nums.length; i++) {
            if (prime[nums[i]] == 0) {
                if (isPrime(nums[i])) {
                    start = start == -1 ? i : start;
                    end = i;
                }
            } else {
                // 是质数
                if (prime[nums[i]] == 1) {
                    start = start == -1 ? i : start;
                    end = i;
                }
            }
        }
        return end - start;
    }


    public boolean isPrime(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                prime[n] = 2;
                return false;
            }
        }
        prime[n] = 1;
        return true;
    }

    public static void main(String[] args) {
        Lc3115 lc3115 = new Lc3115();
        System.out.println(lc3115.maximumPrimeDifference(new int[]{
                4, 2, 9, 5, 3
        }));
    }
}

package binary;

class Lc875 {
    public int minEatingSpeed(int[] piles, int h) {
        int max = Integer.MIN_VALUE;
        for (int num : piles) {
            max = Math.max(num, max);
        }
        int min = 1;
        int ans = 0;
        while (min <= max) {
            int m = (
                    max - min) / 2 + min;
            if (f(m, piles) <= h) {
                ans = m;
                max = m - 1;
            } else {
                min = m + 1;
            }
        }
        return ans;
    }

    public int f(int speed, int[] nums) {
        long time = 0;
        for (int num : nums) {
            time += ((long) (num + speed - 1)) / speed;
        }
        return (int) time;
    }

    public static void main(String[] args) {
        Lc875 lc875 = new Lc875();
        System.out.println(lc875.minEatingSpeed(new int[]{
                805306368, 805306368, 805306368
        }, 1000000000));
    }
}
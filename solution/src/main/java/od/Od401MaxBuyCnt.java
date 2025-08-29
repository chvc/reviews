package od;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 *  P00302—最多购买宝石数目
 *
 * @author chenghu
 * @since 2025-08-29 19:41:20
 */
public class Od401MaxBuyCnt {

    static int[] gems;

    public static void main(String[] args) throws IOException {
        //
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(reader);
        while (in.nextToken() != StreamTokenizer.TT_EOF) {
            int number = (int) in.nval;
            gems = new int[number];
            for (int i = 0; i < number; i++) {
                in.nextToken();
                int num = (int) in.nval;
                gems[i] = num;
            }
            in.nextToken();
            int amount = (int) in.nval;
            int cnt = canBuyMaxCnt(gems, amount);
            System.out.println(cnt ==Integer.MIN_VALUE?0:cnt);
        }

    }

    public static int canBuyMaxCnt(int[] gems, int amount) {
        int left = 0;
        int right = 0;
        int sum = 0;
        int ans = Integer.MIN_VALUE;
        while (right < gems.length) {
            if (sum + gems[right] <= amount) {
                sum += gems[right];
                ans = Math.max(ans, right - left + 1);
                right++;
            } else {
                if (left == right) {
                    left++;
                    right++;
                    sum = 0;
                } else {
                    sum -= gems[left];
                    left++;
                }
            }
        }
        return ans;
    }
}

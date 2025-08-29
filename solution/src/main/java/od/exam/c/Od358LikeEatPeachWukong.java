package od.exam.c;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 *  P000010—爱吃蟠桃的孙悟空
 *
 * @author chenghu
 * @since 2025-08-18 22:46:59
 */
public class Od358LikeEatPeachWukong {


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = reader.readLine()) != null) {
            List<Integer> nums = Arrays.stream(line.split(" ")).map(Integer::parseInt).collect(Collectors.toList());
            int hour = Integer.parseInt(reader.readLine());

            // 从 1开始
            Collections.sort(nums);
            int min = 1;
            int max = nums.get(nums.size() - 1);
            int ans = -1;
            for (int i = min; i <= max; i++) {
                int count = 0;
                boolean isBreak = false;
                for (int j = 0; j < nums.size(); j++) {
                    count += calculateHours(nums.get(j), i);
                    if (count > hour) {
                        isBreak = true;
                        break;
                    }
                }
                if (!isBreak){
                    ans = i;
                    break;
                }
            }
            System.out.println(ans);
        }
    }

    public static int calculateHours(int n, int k) {
        if (n % k == 0) {
            return n / k;
        } else {
            return n / k + 1;
        }
    }

}

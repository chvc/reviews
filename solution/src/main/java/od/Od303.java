package od;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Od303 {

    static List<Integer> nums;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        while ((line = reader.readLine()) != null) {
            int z = Integer.parseInt(line);
            int[] nums = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0) {
                    set.add(i);
                }
            }


            int maxLen = 0;
            int index = -1;
            int mid = nums.length / 2;
            for (Integer i : set) {
                int continueZCount = 0;
                int l = i - 1;
                int r = i + 1;
                while (l >= 0 && r < nums.length && (nums[l] == z || nums[r] == z)) {
                    if (nums[l] == z && nums[r] == z) {
                        l--;
                        r++;
                    } else if (nums[l] == z && nums[r] != z) {
                        l--;
                    } else if (nums[l] != z && nums[r] == z) {
                        r++;
                    }
                }
                int len = r - l - 1;
                if (len <= 5) {
                    if (len > maxLen) {
                        maxLen = len;
                        index = i;
                    }
                    if (len == maxLen) {
                        // 计算中间位置
                        if (Math.abs(i - mid) < Math.abs(index - mid)) {
                            index = i;
                        }
                    }
                }
            }
            System.out.println(index);
        }
    }

}

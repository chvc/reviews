package od.exam.c;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * P00396-数字涂色
 *
 * @author chenghu
 * @since 2025-08-25 00:02:35
 */
public class Od14NumericColoring {

    static int[] nums;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        Arrays.sort(nums);
        List<Integer> countList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (countList.isEmpty()) {
                countList.add(nums[i]);
            } else {
                boolean add = true;
                for (int j = 0; j < countList.size(); j++) {
                    if (nums[i] % countList.get(j) == 0) {
                        add = false;
                        break;
                    }
                }
                if (add) {
                    countList.add(nums[i]);
                }
            }
        }
        System.out.println(countList.size());
    }
}

package od;

import java.util.*;

public class Od10 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        int[] nums = Arrays.stream(input.substring(1, input.length() - 1).split(","))
                .mapToInt(Integer::parseInt)
                .toArray();

        dfs(nums, 0, new StringBuilder());
        if (result == null) {
            System.out.println("invalid");
            return;
        }
        System.out.println(result.substring(0, 2) + ":" + result.substring(2, 4) + ":" + result.substring(4, 6));
    }

    static boolean[] used = new boolean[6];
    static String result;

    private static void dfs(int[] nums, int index, StringBuilder sb) {
        if (index == 1) {
            int hour1 = Integer.parseInt(sb.substring(0, 1));
            if (hour1 > 2) {
                return;
            }
        }
        if (index == 2) {
            int hour2 = Integer.parseInt(sb.substring(0, 2));
            if (hour2 > 23) {
                return;
            }
        }
        if (index == 3) {
            int hour2 = Integer.parseInt(sb.substring(2, 3));
            if (hour2 > 5) {
                return;
            }
        }
//        if (index == 4) {
//            int hour2 = Integer.parseInt(sb.substring(2, 4));
//            if (hour2 > 59) {
//                return;
//            }
//        }
        if (index == 5) {
            int hour2 = Integer.parseInt(sb.substring(4, 5));
            if (hour2 > 5) {
                return;
            }
        }
        if (index == 6) {
            if (result == null) {
                result = sb.toString();
            } else {
                if (result.compareTo(sb.toString()) < 0) {
                    result = sb.toString();
                }

            }
            return;
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            if (!used[i]) {
                used[i] = true;
                dfs(nums, index + 1, sb.append(nums[i]));
                used[i] = false;
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}


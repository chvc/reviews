package od;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025/8/17
 */
public class Main {


    // region
   /* public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String line;
        while ((line = in.readLine()) != null) {
            String[] split = line.split(" ");
            int[] params = Arrays.stream(split).mapToInt(Integer::parseInt).toArray();
            int n = params[0];
            int m = params[1];
            int k = params[2];
            String pos = in.readLine();
            Set<Integer> set = Arrays.stream(pos.split(" ")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toSet());
            String num = in.readLine();
            int[] nums = Arrays.stream(num.split(" ")).mapToInt(Integer::parseInt).toArray();
            PriorityQueue<Integer> heap = new PriorityQueue<>();
            long kk = 0;
            for (int i = 0; i < nums.length; i++) {
                int x = nums[i];
                if (set.contains(i)) {
                    heap.add(x);
                } else {
                    if (!heap.isEmpty()) {
                        Integer peek = heap.peek();
                        if (peek > x) {
                            kk += heap.size();
                        } else {
                            while (!heap.isEmpty() && heap.peek() <= x) {
                                heap.poll();
                            }
                            if (!heap.isEmpty()) {
                                kk += heap.size();
                            }
                        }
                    }
                }
            }
            if (kk > k) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }

        in.close();
    }*/
    // endregion


//    //region
//    public static void main(String[] args) throws IOException {
//        Scanner scanner = new Scanner(System.in);
//        List<String> times = new ArrayList<>();
//        int n = Integer.parseInt(scanner.nextLine());
//        for (int i = 0; i < n; i++) {
//            String time = scanner.nextLine();
//            times.add(time);
//        }
//        Map<Long, List<String>> listMap = times.stream().collect(Collectors.groupingBy(t -> key(t),
//                Collectors.collectingAndThen(Collectors.toList(), list -> {
//                            list.sort((o1, o2) -> {
//                                String ss1 = o1.split("\\.")[1];
//                                String ss2 = o2.split("\\.")[1];
//                                return ss1.compareTo(ss2);
//                            });
//                            return list;
//                        }
//                )));
//        int sum = 0;
//        for (Map.Entry<Long, List<String>> entry : listMap.entrySet()) {
//            List<String> value = entry.getValue();
//            int res = 1;
//            for (int i = 1; i < value.size(); i++) {
//                if (value.get(i).compareTo(value.get(i - 1)) == 0) {
//                    res++;
//                } else {
//                    break;
//                }
//            }
//            sum += res;
//        }
//        System.out.println(sum);
//
//    }
//
//    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//
//    // 2019-01-01 00:00:00.001
//    public static long key(String time) {
//        String[] split = time.split("\\.");
//        String t = split[0];
//        LocalDateTime dateTime = LocalDateTime.parse(t, formatter);
//        Instant instant = dateTime.toInstant(ZoneOffset.UTC);
//        long epochMilli = instant.toEpochMilli();
//        return epochMilli;
//    }
//    // endregion

    //region
//    static int[][] grid = new int[64][64];
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = Integer.parseInt(scanner.nextLine());
//        List<Integer> numsList = new ArrayList<>();
//        for (int i = 0; i < n; i++) {
//            String s = scanner.nextLine();
//            int[] nums = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
//            int num = nums[0];
//            numsList.add(num);
//            for (int j = 1; j < nums.length; j = j + 2) {
//                grid[nums[j]][nums[j + 1]] = num;
//            }
//        }
//        List<Integer> resultList = new ArrayList<>();
//        for (int num : numsList) {
//            int res = 0;
//            for (int i = 0; i < 64; i++) {
//                for (int j = 0; j < 64; j++) {
//                    if (grid[i][j] == num) {
//                        if (!inArea(i - 1, j) ||(inArea(i - 1, j) && grid[i - 1][j] != num)) {
//                            res++;
//                        }
//                        if (!inArea(i + 1, j) ||(inArea(i + 1, j) && grid[i + 1][j] != num) ){
//                            res++;
//                        }
//                        if (!inArea(i, j - 1) || (inArea(i, j - 1) && grid[i][j - 1] != num)) {
//                            res++;
//                        }
//                        if (!inArea(i, j + 1)||(inArea(i, j + 1) && grid[i][j + 1] != num)) {
//                            res++;
//                        }
//                    }
//                }
//            }
//            resultList.add(res);
//        }
//        String s = resultList.stream().map(String::valueOf).collect(Collectors.joining(" "));
//        System.out.print(s);
//    }
//
//    public static boolean inArea(int i, int j) {
//        return i >= 0 && i < 64 && j >= 0 && j < 64;
//    }
    //endregion

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

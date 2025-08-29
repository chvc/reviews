package od;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025-08-29 01:01:11
 */
public class Od122SamePerimeter {


    static int[][] grid = new int[64][64];

    /**
     * 复杂度比较高 应该用 Map 来存坐标后 遍历
     *
     * @param args
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Integer> numsList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String s = scanner.nextLine();
            int[] nums = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
            int num = nums[0];
            numsList.add(num);
            for (int j = 1; j < nums.length; j = j + 2) {
                grid[nums[j]][nums[j + 1]] = num;
            }
        }
        List<Integer> resultList = new ArrayList<>();
        for (int num : numsList) {
            int res = 0;
            for (int i = 0; i < 64; i++) {
                for (int j = 0; j < 64; j++) {
                    if (grid[i][j] == num) {
                        if (!inArea(i - 1, j) || (inArea(i - 1, j) && grid[i - 1][j] != num)) {
                            res++;
                        }
                        if (!inArea(i + 1, j) || (inArea(i + 1, j) && grid[i + 1][j] != num)) {
                            res++;
                        }
                        if (!inArea(i, j - 1) || (inArea(i, j - 1) && grid[i][j - 1] != num)) {
                            res++;
                        }
                        if (!inArea(i, j + 1) || (inArea(i, j + 1) && grid[i][j + 1] != num)) {
                            res++;
                        }
                    }
                }

            }
            resultList.add(res);
        }
        String s = resultList.stream().map(String::valueOf).collect(Collectors.joining(" "));
        System.out.print(s);

    }

    public static boolean inArea(int i, int j) {
        return i >= 0 && i < 64 && j >= 0 && j < 64;
    }

    /**
     * 更好
     * @param args
     */

    public static void main2(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        int[][] grid = new int[64][64];
        Map<Integer, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            List<Integer> list = Arrays.stream(in.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .boxed()
                    .collect(Collectors.toList());
            int val = list.get(0);
            map.put(val, 0);
            for (int j = 1; j < list.size(); j = j + 2) {
                grid[list.get(j)][list.get(j + 1)] = val;
            }
        }
        for (int i = 0; i < 64; i++) {
            for (int j = 0; j < 64; j++) {
                for (int[] d : diff) {
                    if (!map.containsKey(grid[i][j])) {
                        continue;
                    }
                    if (!inArea(i + d[0], j + d[1])) {
                        map.put(grid[i][j], map.getOrDefault(grid[i][j], 0) + 1);
                        continue;
                    }
                    if (grid[i + d[0]][j + d[1]] != grid[i][j]) {
                        map.put(grid[i][j], map.getOrDefault(grid[i][j], 0) + 1);
                    }
                }
            }
        }

        System.out.println(map.values().stream().map(String::valueOf).collect(Collectors.joining(" ")));
    }

    static int[][] diff = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};


}

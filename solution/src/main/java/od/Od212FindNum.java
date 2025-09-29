package od;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025-09-27 22:31:26
 */
public class Od212FindNum {

    /**
     * 给一个二维数组nums，对于每一个元素num[i]，找出距离最近的且值相等的元素，输出横纵坐标差值的绝对值之和，如果没有等值元素，则输出-1。
     * <p>
     * 输入描述:
     * 输入第一行为二维数组的行
     * 输入第二行为二维数组的列
     * 输入的数字以空格隔开。
     * <p>
     * 输出描述:
     * 数组形式返回所有坐标值。
     * <p>
     * 补充说明:
     * 1. 针对数组num[i][j]，满足0<i<=100: 0<i<=100.
     * 2. 对于每个数字，最多存在100个与其相等的数字
     * <p>
     * 示例1：
     * 输入：
     * 3
     * 5
     * 0 3 5 4 2
     * 2 5 7 8 3
     * 2 5 4 2 4
     * <p>
     * 输出：
     * [-1, 4, 2, 3, 3], [1, 1, -1, -1, 4], [1, 1, 2, 3, 2]]
     * <p>
     * 解释：
     * 对于 num[0][0] = 0，不存在相等的值。
     * 对于 num[0][1] = 3，存在一个相等的值，最近的坐标为num[1][4]，最小距离为4.
     * 对于 num[0][2] = 5，存在两个相等的值，最近的坐标为num[1][1]，故最小距离为2.
     * 对于 num[1][1] = 5，存在两个相等的值，最近的坐标为num[2][1]，故最小距离为1。
     *
     * @param args
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] grid = new int[n][m];
        Map<Integer, List<int[]>> mapping = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int x = sc.nextInt();
                grid[i][j] = x;
                List<int[]> list = mapping.getOrDefault(x, new ArrayList<>());
                list.add(new int[]{i, j});
                mapping.put(x, list);
            }
        }
        int[][] res = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int x = grid[i][j];
                List<int[]> list = mapping.get(x);
                if (list.size()==1) {
                    res[i][j] = -1;
                } else {
                    int distance = Integer.MAX_VALUE;
                    for (int k = 0; k < list.size(); k++) {
                        int[] arr = list.get(k);
                        if (arr[0] == i && arr[1] == j) {
                            continue;
                        }
                        distance = Math.min(distance, Math.abs(arr[0] - i) + Math.abs(arr[1] - j));
                    }
                    res[i][j] = distance;
                }
            }
        }
        System.out.println(Arrays.deepToString(res));
    }

}

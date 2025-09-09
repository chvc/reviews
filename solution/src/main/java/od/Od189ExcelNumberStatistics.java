package od;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * #P00416—Excel单元格数值统计
 *
 * @author chenghu
 * @since 2025-09-08 21:19:25
 */
public class Od189ExcelNumberStatistics {

    static int[][] grid;

    static boolean[][] resolved;

    static Map<String, String> mapping = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] area = sc.nextLine().split(" ");
        int rows = Integer.parseInt(area[0]);
        int cols = Integer.parseInt(area[1]);
        grid = new int[rows][cols];
        resolved = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            String[] row = sc.nextLine().split(" ");
            for (int j = 0; j < row.length; j++) {
                String content = row[j];
                if (content.contains("=")) {
                    mapping.put(getKey(i, j), content.substring(1));
                } else {
                    grid[i][j] = Integer.parseInt(content);
                    resolved[i][j] = true;
                }
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                f(i, j);
            }
        }
        String[] split = sc.nextLine().split(":");
        int startCol = split[0].charAt(0) - 'A';
        int startRow = Integer.parseInt(split[0].substring(1)) - 1;
        int endCol = split[1].charAt(0) - 'A';
        int endRow = Integer.parseInt(split[1].substring(1)) - 1;
        int ans = 0;
        for (int i = startRow; i <= endRow; i++) {
            for (int j = startCol; j <= endCol; j++) {
                ans += grid[i][j];
            }
        }
        System.out.println(ans);
    }


    public static int f(int i, int j) {
        if (resolved[i][j]) {
            return grid[i][j];
        }
        // 否则就拿出字符进行解析
        String s = mapping.get(getKey(i, j));
        String pre = "";
        String suf = "";
        boolean flag = true;
        if (s.contains("+")) {
            String[] ss = s.split("\\+");
            pre = ss[0];
            suf = ss[1];
        } else if (s.contains("-")) {
            String[] ss = s.split("-");
            pre = ss[0];
            suf = ss[1];
            flag = false;
        } else {
            // 直接等于某个单元格的值
            int x = parse(s);
            grid[i][j] = x;
            resolved[i][j] = true;
            return x;
        }
        int x1 = parse(pre);
        int x2 = parse(suf);
        int res;
        if (flag) {
            res = x1 + x2;
        } else {
            res = x1 - x2;
        }
        grid[i][j] = res;
        resolved[i][j] = true;
        return res;
    }

    public static String getKey(String str) {
        char c = str.charAt(0);
        // 否则就拿出字符进行解析
        int row = Integer.parseInt(str.substring(1));
        int col = c - 'A';
        return getKey(row, col);
    }

    public static String getKey(int row, int col) {
        return row + "#" + col;
    }

    public static int parse(String ss) {
        int x;
        try {
            x = Integer.parseInt(ss);
        } catch (NumberFormatException e) {
            char c = ss.charAt(0);
            int row = Integer.parseInt(ss.substring(1));
            int col = c - 'A';
            x = f(row - 1, col);
        }
        return x;
    }

}

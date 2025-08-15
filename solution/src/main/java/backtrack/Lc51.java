package backtrack;


import sun.misc.Queue;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025-08-11 18:20:37
 */
public class Lc51 {

    int n_queen;

    List<List<String>> ans = new ArrayList<>();

    StringBuilder sb = new StringBuilder();


    public List<List<String>> solveNQueens(int n) {
        n_queen = n;
        int[] path = new int[n_queen];
        for (int i = 0; i < n; i++) {
            sb.append('.');
        }
        dfs(0, path);
        return ans;
    }


    public void dfs(int currentRow, int[] path) {
        if (currentRow == n_queen) {
            // 说明有一个结果了
            List<String> res = getResult(path);
            ans.add(res);
        }
        // 否则 就要看 每一个位置上能不能放皇后
        for (int column = 0; column < n_queen; column++) {
            // 如果可以放了
            if (check(path, currentRow, column)) {
                // 那就放上去
                path[currentRow] = column;
                dfs(currentRow + 1, path);
            }
        }
    }

    // 已经在 [0...i-1]行放了皇后了
    // 能否在i行放皇后
    private boolean check(int[] path, int currentRow, int currentColumn) {
        // 0行开始比较 列数相同就不能放
        // 对角线 斜率一样
        for (int i = 0; i < currentRow; i++) {
            if (currentColumn == path[i] || (Math.abs(currentRow - i) == Math.abs(currentColumn - path[i]))) {
                return false;
            }
        }
        return true;
    }

    private List<String> getResult(int[] path) {
        // 第i行的第j列放入了皇后
        List<String> res = new ArrayList<>();

        for (int i = 0; i < path.length; i++) {
            StringBuilder builder = new StringBuilder(sb.toString());
            int col = path[i];
            builder.setCharAt(col, 'Q');
            res.add(builder.toString());
        }
        return res;
    }

    public static void main(String[] args) {
        Lc51 lc51 = new Lc51();
        System.out.println(lc51.solveNQueens(4));
    }


}

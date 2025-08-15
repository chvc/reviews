package graph;


/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025-08-13 10:16:13
 */
public class Lc79 {

    int m;

    int n;

    boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        visited = new boolean[m][n];
        char[] chars = word.toCharArray();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, chars, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }


    public boolean dfs(char[][] board, char[] chars, int index, int x, int y) {
        if (!inArea(x, y)) {
            return false;
        }
        if (visited[x][y]) {
            return false;
        }
        if (index == chars.length - 1) {
            // 说明找到了
            return board[x][y] == chars[index];
        }
        if (board[x][y] != chars[index]) {
            return false;
        }
        visited[x][y] = true;
        // 否则就在四个方向上面寻找
        // 如果寻找到了  继续找下一个位置
        boolean res =
                // 继续找下一个位置
                dfs(board, chars, index + 1, x + 1, y) ||
                        dfs(board, chars, index + 1, x - 1, y) ||
                        dfs(board, chars, index + 1, x, y + 1) ||
                        dfs(board, chars, index + 1, x, y - 1);
        visited[x][y] = false;
        return res;

    }


    public boolean inArea(int x, int y) {
        return x < m && x >= 0 && y < n && y >= 0;
    }
}

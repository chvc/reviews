package od;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 * P00379—单词搜索/找到它
 *
 * @author chenghu
 * @since 2025-08-15 23:58:36
 */
public class Od249WordSearch {


    static char[][] board;
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(reader);
        while (in.nextToken() != StreamTokenizer.TT_EOF) {
            n = (int) in.nval;
            in.nextToken();
            m = (int) in.nval;
            board = new char[n][m];
            in.nextToken();
            String word = in.sval;
            // n行
            for (int i = 0; i < n; i++) {
                in.nextToken();
                String sval = in.sval;
                for (int j = 0; j < m; j++) {
                    board[i][j] = sval.charAt(j);
                }
            }

            int firstRow = -1;
            int firstCol = -1;
            boolean found = false;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (!found && dfs(board, word.toCharArray(), i, j, 0)) {
                        firstRow = i;
                        firstCol = j;
                        found = true;
                    }
                }
            }
            if (!found) {
                System.out.println("NO");
            } else {
                System.out.print(firstRow + 1);
                System.out.print(" ");
                System.out.print(firstCol + 1);
            }
        }
    }

    public static boolean dfs(char[][] board, char[] words, int i, int j, int k) {
        if (k == words.length) {
            return true;
        }
        if (i < 0 || i >= n || j < 0 || j >= m || board[i][j] != words[k]) {
            return false;
        }
        char temp = board[i][j];
        board[i][j] = 0;
        boolean ans = dfs(board, words, i - 1, j, k + 1)
                || dfs(board, words, i + 1, j, k + 1)
                || dfs(board, words, i, j - 1, k + 1)
                || dfs(board, words, i, j + 1, k + 1);
        board[i][j] = temp;
        return ans;
    }


}

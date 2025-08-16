package od;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025-08-16 00:14:22
 */
public class Od473 {

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
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (dfs(board, word.toCharArray(), i, j, 0)) {
                        firstRow = i;
                        firstCol = j;
                    }
                }
            }
            if (firstCol == -1) {
                System.out.println("NO");
            } else {
                System.out.print(firstRow);
                System.out.print(" ");
                System.out.print(firstCol);
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
        boolean ans = dfs(board, words, i - 1, j, k + 1)
                || dfs(board, words, i + 1, j, k + 1)
                || dfs(board, words, i, j - 1, k + 1)
                || dfs(board, words, i, j + 1, k + 1);
        board[i][j] = temp;
        return ans;
    }

}

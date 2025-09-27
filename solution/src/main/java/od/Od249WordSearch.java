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

    /**
     * 找到它是一个小游戏，你需要在一个矩阵中找到给定的单词。
     *
     * 假设给定单词 HELLOWORD，在矩阵中只要能找到 H->E->L->L->O->W->O->R->L->D连成的单词，就算通过。
     *
     * 注意区分英文字母大小写，并且您只能上下左右行走，不能走回头路。
     *
     * 输入描述
     *
     * 输入第 1 行包含两个整数 n、m (0 < n,m < 21) 分别表示 n 行 m 列的矩阵，
     *
     * 第 2 行是长度不超过100的单词 W (在整个矩阵中给定单词 W 只会出现一次)，
     *
     * 从第 3 行到第 n+2 行是指包含大小写英文字母的长度为 m 的字符串矩阵。
     *
     * 输出描述
     *
     * 如果能在矩阵中连成给定的单词，则输出给定单词首字母在矩阵中的位置(第几行 第几列)，
     *
     * 否则输出“NO”。
     *
     * 示例1  输入输出示例仅供调试，后台判题数据一般不包含示例
     *
     * 输入
     *
     * 5 5
     *
     * HELLOWORLD
     *
     * CPUCY
     *
     * EKLQH
     *
     * CHELL
     *
     * LROWO
     *
     * DGRBC
     *
     * 输出
     *
     * 3 2
     */


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

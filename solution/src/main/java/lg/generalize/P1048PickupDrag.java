package lg.generalize;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 * P1048 [NOIP 2005 普及组] 采药
 *
 * @author chenghu
 * @since 2025-09-09 00:18:46
 */
public class P1048PickupDrag {

    /**
     * 题目描述
     * 辰辰是个天资聪颖的孩子，他的梦想是成为世界上最伟大的医师。为此，他想拜附近最有威望的医师为师。医师为了判断他的资质，给他出了一个难题。医师把他带到一个到处都是草药的山洞里对他说：“孩子，这个山洞里有一些不同的草药，采每一株都需要一些时间，每一株也有它自身的价值。我会给你一段时间，在这段时间里，你可以采到一些草药。如果你是一个聪明的孩子，你应该可以让采到的草药的总价值最大。”
     * <p>
     * 如果你是辰辰，你能完成这个任务吗？
     * <p>
     * 输入格式
     * 第一行有 2 个整数 T（1≤T≤1000）和 M（1≤M≤100），用一个空格隔开，T 代表总共能够用来采药的时间，M 代表山洞里的草药的数目。
     * <p>
     * 接下来的 M 行每行包括两个在 1 到 100 之间（包括 1 和 100）的整数，分别表示采摘某株草药的时间和这株草药的价值。
     * <p>
     * 输出格式
     * 输出在规定的时间内可以采到的草药的最大总价值。
     * 输入输出样例
     * 输入 #1
     * 70 3
     * 71 100
     * 69 1
     * 1 2
     * 输出 #1
     * 3
     */

    static int t;

    static int m;

    static int[] times;

    static int[] values;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(reader);
        while (in.nextToken() != StreamTokenizer.TT_EOF) {
            t = (int) in.nval;
            in.nextToken();
            m = (int) in.nval;
            times = new int[m + 1];
            values = new int[m + 1];
            dp = new int[t + 1];
            for (int i = 1; i <= m; i++) {
                in.nextToken();
                times[i] = (int) in.nval;
                in.nextToken();
                values[i] = (int) in.nval;
            }
            // 遍历所有的物品
            for (int i = 1; i <= m; i++) {
                int w = times[i];
                int v = values[i];
                // 遍历所有的代价 代价必须大于当前的时间
                for (int j = t; j >= w; j--) {
                    //
                    dp[j] = Math.max(dp[j], dp[j - w] + v);
                }
            }
            System.out.println(dp[t]);
        }
    }

}

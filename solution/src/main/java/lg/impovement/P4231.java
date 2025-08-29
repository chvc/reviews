package lg.impovement;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;
import java.util.Map;

/**
 * 等差数列差分
 *
 * @author chenghu
 * @since 2025-08-30 02:57:41
 */
public class P4231 {

    static int n;


    static int m;

    static long[] diff;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(reader);
        while (in.nextToken() != StreamTokenizer.TT_EOF) {
            n = (int) in.nval;
            diff = new long[n + 3];
            in.nextToken();
            m = (int) in.nval;
            // 要进行m次攻击
            for (int i = 0; i < m; i++) {
                // 每次读取四个数
                in.nextToken();
                int l = (int) in.nval;
                in.nextToken();
                int r = (int) in.nval;
                in.nextToken();
                int s = (int) in.nval;
                in.nextToken();
                int e = (int) in.nval;
                build(l, r, s, e);
            }
            // 来两遍前缀和
            cover();
            // 对数组进行求异或和
            long ans = 0;
            long max = 0;
            for (int i = 1; i <= n; i++) {
                ans = ans ^ diff[i];
                max = Math.max(max, diff[i]);
            }
            System.out.println(ans + " " + max);
        }
    }

    public static void build(int l, int r, int s, int e) {
        // 计算公差d
        int d = (e - s) / (r - l);
        // l..r
        diff[l] += s;
        diff[l + 1] += d - s;
        diff[r + 1] -= (d + e);
        diff[r + 2] += e;
    }

    public static void cover() {
        // 计算公差d
        for (int i = 1; i < diff.length; i++) {
            diff[i] += diff[i - 1];
        }
        for (int i = 1; i < diff.length; i++) {
            diff[i] += diff[i - 1];
        }
    }
}

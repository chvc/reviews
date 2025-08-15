import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StreamTokenizer;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025-08-15 16:17:58
 */
public class UnionFind {


    static int MAXM = 1000001;

    static int[] sets = new int[MAXM];

    static int[] size = new int[MAXM];

    static int[] stack = new int[MAXM];

    static int setnum = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(reader);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.nextToken() != StreamTokenizer.TT_EOF) {
            // 注意 while 处理多个 case
            int n = (int) in.nval;
            in.nextToken();
            build(n);
            int m = (int) in.nval;
            for (int j = 0; j < m; j++) {
                in.nextToken();
                int op = (int) in.nval;
                // 调用 isSameSet
                if (op == 1) {
                    in.nextToken();
                    int x = (int) in.nval;
                    in.nextToken();
                    int y = (int) in.nval;
                    if (isSameSet(x, y)) {
                        out.println("Yes");
                    } else {
                        out.println("No");
                    }
                }
                if (op == 2) {
                    in.nextToken();
                    int x = (int) in.nval;
                    in.nextToken();
                    int y = (int) in.nval;
                    union(x, y);
                }
            }
        }
    }

    public static void build(int n) {
        for (int i = 0; i < n; i++) {
            sets[i] = i;
            size[i] = 1;
        }
        setnum = n;
    }

    public static boolean isSameSet(int x, int y) {
        return find(x) == find(y);
    }

    public static void union(int a, int b) {
        int x = find(a);
        int y = find(b);
        if (x != y) {
            // 不在一个集合 那就要挂了
            if (size[x] < size[y]) {
                sets[x] = y;
                size[y] += size[x];
                size[x] = 0;
            } else {
                sets[y] = x;
                size[x] += size[y];
                size[y] = 0;
            }
            setnum--;
        }
    }

    public static int find(int a) {
        int res = a;
        int size = 0;
        while (sets[res] != res) {
            stack[size] = res;
            res = sets[res];
            size++;
        }

        for (int i = 0; i < size; i++) {
            sets[stack[i]] = res;
        }
        return res;
    }

}

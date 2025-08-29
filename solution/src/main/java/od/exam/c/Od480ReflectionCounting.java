package od.exam.c;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 * P00310-反射计数
 *
 * @author chenghu
 * @since 2025-08-24 01:33:48
 */
public class Od480ReflectionCounting {
    static int[][] grid;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(reader);
        while (in.nextToken() != StreamTokenizer.TT_EOF) {
            int w = (int) in.nval;
            in.nextToken();
            int h = (int) in.nval;
            in.nextToken();
            int x = (int) in.nval;
            in.nextToken();
            int y = (int) in.nval;
            in.nextToken();
            double sx = in.nval;
            in.nextToken();
            double sy = in.nval;
            in.nextToken();
            int t = (int) in.nval;
            grid = new int[h][w];
            for (int i = 0; i < h; i++) {
                String s = reader.readLine();
                for (int j = 0; j < w; j++) {
                    grid[i][j] = s.charAt(j) - '0';
                }
            }
            // t时间内
            int count = grid[y][x] == 1 ? 1 : 0;
            for (int i = 0; i < t; i++) {
                int newx = (int) (x + sx);

                int newy = (int) (y + sy);

                if (grid[newy][newx] == 1) {
                    count++;
                }
                // 判断是否碰到了边缘 如果是的话 速度进行调整
                if (newx == w - 1 || newx == 0) {
                    sx = -sx;
                }
                if (newy == h - 1 || newy == 0) {
                    sy = -sy;
                }
                x = newx;
                y = newy;
            }
            System.out.println(count);
        }
    }

}

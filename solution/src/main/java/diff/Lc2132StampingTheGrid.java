package diff;


/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025-09-03 18:56:44
 */
public class Lc2132StampingTheGrid {
    public boolean possibleToStamp(int[][] grid, int stampHeight, int stampWidth) {
        // 准备一个sum数组 快速判断 区域累加和
        int n = grid.length;
        int m = grid[0].length;
        int[][] sum = new int[n + 1][m + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sum[i + 1][j + 1] += grid[i][j];
            }
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                sum[i][j] += sum[i][j - 1] + sum[i - 1][j] - sum[i - 1][j - 1];
            }
        }
        // 创建一个差分数组
        int[][] diff = new int[n + 2][m + 2];
        // 找到为0的左上角的单元格
        for (int a = 1, c = a + stampHeight - 1; c <= n; a++, c++) {
            for (int b = 1, d = b + stampWidth - 1; d <= m; b++, d++) {
                if (regionSum(sum, a, b, c, d) == 0) {
                    // 贴邮票
                    addStamp(diff, a, b, c, d);
                }
            }
        }
        // 加工diff前缀和
        for (int i = 1; i < n + 2; i++) {
            for (int j = 1; j < m + 2; j++) {
                diff[i][j] += diff[i][j - 1] + diff[i - 1][j] - diff[i - 1][j - 1];
            }
        }
        // 比较
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0 && diff[i + 1][j + 1] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public int regionSum(int[][] sum, int a, int b, int c, int d) {
        // 计算区域和
        return sum[c][d] - sum[c][b - 1] - sum[a - 1][d] + sum[a - 1][b - 1];
    }

    public void addStamp(int[][] diff, int a, int b, int c, int d) {
        // diff数组里面
        diff[a][b] += 1;
        diff[c + 1][d + 1] += 1;
        diff[c + 1][b] -= 1;
        diff[a][d + 1] -= 1;
    }

}

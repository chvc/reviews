package matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025/7/24
 */
public class Lc54 {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<Integer>();
        // 上下左右四个边界的索引
        int rightBorder = matrix[0].length - 1;

        int bottomBorder = matrix.length - 1;

        int leftBorder = 0;

        int topBorder = 0;

        while (true) {
            // 向右
            for (int i = leftBorder; i <= rightBorder; i++) {
                list.add(matrix[topBorder][i]);
            }
            if (++topBorder > bottomBorder) {
                break;
            }
            // 向下
            for (int i = topBorder; i <= bottomBorder; i++) {
                list.add(matrix[i][rightBorder]);
            }
            if (leftBorder > --rightBorder) {
                break;
            }
            // 向左
            for (int i = rightBorder; i >= leftBorder; i--) {
                list.add(matrix[bottomBorder][i]);
            } // right to left
            if (topBorder > --bottomBorder) break;
            // 向上
            for (int i = bottomBorder; i >= topBorder; i--) {
                list.add(matrix[i][leftBorder]);
            }
            if (++leftBorder > rightBorder) break;
        }
        return list;
    }

    public static void main(String[] args) {
        Lc54 lc54 = new Lc54();
        int[][] matrix = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        lc54.spiralOrder(matrix);
    }

}

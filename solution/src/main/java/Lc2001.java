import java.util.HashMap;
import java.util.Map;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025/8/8
 */
public class Lc2001 {

    Map<Double, Integer> map = new HashMap<>();
    int ans = 0;

    public long interchangeableRectangles(int[][] rectangles) {
        for (int i = 0; i < rectangles.length; i++) {
            int[] rectangle = rectangles[i];
            double rate = (double) rectangle[1] / rectangle[0];
            if (map.containsKey(rate)) {
                Integer cnt = map.get(rate);
                ans += cnt;
                map.put(rate, cnt + 1);
            } else {
                map.put(rate, 1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Lc2001 lc2001 = new Lc2001();
        System.out.println(lc2001.interchangeableRectangles(new int[][]{
                {4, 5}, {7, 8}
        }));
    }

}

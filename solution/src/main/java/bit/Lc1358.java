package bit;


import java.util.Arrays;
import java.util.Comparator;
import java.util.function.IntUnaryOperator;
import java.util.stream.IntStream;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025-08-10 17:41:07
 */
public class Lc1358 {
    public int[] sortByBits(int[] arr) {

        arr = Arrays.stream(arr).boxed().sorted((o1, o2) -> {
            int x = Integer.bitCount(o1);
            int y = Integer.bitCount(o2);
            if (x != y) {
                return x - y;
            } else {
                return o1 - o2;
            }
        }).mapToInt(m -> m).toArray();
        return arr;
    }

    public static void main(String[] args) {
        Lc1358 lc1358 = new Lc1358();
        System.out.println(Arrays.toString(lc1358.sortByBits(new int[]{
                0, 1, 2, 3, 4, 5, 6, 7, 8
        })));
    }

}

package greedy;


import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025-08-14 21:38:47
 */
public class Lc3074 {

    public int minimumBoxes(int[] apple, int[] capacity) {
        int sum = Arrays.stream(apple).sum();
        capacity = Arrays.stream(capacity).boxed().sorted(Comparator.reverseOrder()).mapToInt(a -> a).toArray();
        int sumCap = 0;
        int cnt = 0;
        while (sumCap < sum) {
            sumCap += capacity[cnt];
        }
        return cnt;
    }

}

package od;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *  P00402—叠积木
 *
 * @author chenghu
 * @since 2025-08-29 01:31:52
 */
public class Od223StackingBlocks {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] blocks = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        //
        if (blocks.length == 1) {
            System.out.println(1);
            return;
        }
        Arrays.sort(blocks);

        // 找到最小的 和最大的
        int min = blocks[0];
        int max = blocks[blocks.length - 1] + blocks[blocks.length - 2];
        int ans = 0;
        // 在min max之间进行尝试
        for (int len = min; len < max; len++) {
            // num cnt
            int cnt = 0;
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < blocks.length; i++) {
                map.put(blocks[i], map.getOrDefault(blocks[i], 0) + 1);
            }
            for (int i = 0; i < blocks.length; i++) {
                if (len == blocks[i]) {
                    Integer x = map.getOrDefault(blocks[i], 0);
                    x = x - 1;
                    map.put(blocks[i], x);
                    if (x == 0) {
                        map.remove(blocks[i]);
                    }
                    cnt += 2;
                } else {
                    if (map.getOrDefault(len - blocks[i], 0) <= 0 && map.getOrDefault(blocks[i], 0) <= 0) {
                        break;
                    } else {
                        Integer y = map.getOrDefault(len - blocks[i], 0);
                        y = y - 1;
                        map.put(len - blocks[i], y);
                        if (y == 0) {
                            map.remove(len - blocks[i]);
                        }
                        cnt++;
                    }
                }
            }
            if (map.isEmpty()) {
                ans = Math.max(ans, cnt / 2);
            }
        }
        System.out.println(ans == 0 ? -1 : ans);
    }
}

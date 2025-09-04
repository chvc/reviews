package od.exam.a;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * P00173-多线段数据压缩
 *
 * @author chenghu
 * @since 2025-09-04 22:41:41
 */
public class Od435MultiPartLineSegmentCompression {

    enum Direction {
        NONE,
        UP,
        DOWN,
        LEFT,
        RIGHT,
        LEFT_UP,
        LEFT_DOWN,
        RIGHT_UP,
        RIGHT_DOWN

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nums = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i += 2) {
            list.add(new int[]{
                    nums[i], nums[i + 1]
            });
        }
        // 压缩数据
        Set<int[]> res = new LinkedHashSet<>();
        Direction curDirection = Direction.NONE;
        for (int i = 1; i < list.size(); i++) {
            // 和前一个比较方向
            int[] pre = list.get(i - 1);
            int[] cur = list.get(i);
            Direction direction = getDirection(pre[0], pre[1], cur[0], cur[1]);
            if (curDirection != direction) {
                res.add(pre);
                curDirection = direction;
            }
        }
        res.add(list.get(list.size() - 1));
        // 输出结果
        StringBuffer sb = new StringBuffer();
        for (int[] re : res) {
            sb.append(re[0]).append(" ").append(re[1]).append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }

    public static Direction getDirection(int x1, int y1, int x2, int y2) {
        //
        if (x1 == x2 && y2 < y1) {
            return Direction.LEFT;
        }
        if (x1 == x2 && y2 > y1) {
            return Direction.RIGHT;
        }
        if (x2 < x1 && y2 == y1) {
            return Direction.UP;
        }
        if (x2 > x1 && y2 == y1) {
            return Direction.DOWN;
        }
        if (x2 > x1 && y2 > y1) {
            return Direction.RIGHT_DOWN;
        }
        if (x2 > x1 && y2 < y1) {
            return Direction.LEFT_DOWN;
        }
        if (x2 < x1 && y2 < y1) {
            return Direction.LEFT_UP;
        }
        if (x2 < x1 && y2 > y1) {
            return Direction.RIGHT_UP;
        }
        return Direction.NONE;
    }

}

package diff;


import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.ArrayList;
import java.util.List;

/**
 * 与车相交的点
 *
 * @author chenghu
 * @since 2025-08-29 22:01:58
 */
public class Lc2848PointsThatIntersectWithCars {

    /**
     * 给你一个下标从 0 开始的二维整数数组 nums 表示汽车停放在数轴上的坐标。对于任意下标 i，nums[i] = [starti, endi] ，其中 starti 是第 i 辆车的起点，endi 是第 i 辆车的终点。
     * 返回数轴上被车 任意部分 覆盖的整数点的数目。
     * 1 <= nums.length <= 100
     * nums[i].length == 2
     * 1 <= starti <= endi <= 100
     *
     * @param nums
     * @return
     */
    static int MAXN = 102;

    public int numberOfPoints(List<List<Integer>> nums) {
        int[] diff = new int[MAXN];
        int max = Integer.MIN_VALUE;
        // 构建差分数组
        for (int i = 0; i < nums.size(); i++) {
            // from的开始地方+1
            // to+1的地方-1
            List<Integer> t = nums.get(i);
            diff[t.get(0)] += 1;
            diff[t.get(1) + 1] -= 1;
            max = Math.max(max, t.get(1));
        }
        // 构建前缀和
        for (int i = 1; i < diff.length; i++) {
            diff[i] += diff[i - 1];
        }
        // 统计diff数组中为0的位置的和
        int cnt = 0;
        for (int i = 1; i <= max; i++) {
            if (diff[i] != 0) {
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        List<List<Integer>> nums = new ArrayList<>();

        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(6);
        nums.add(list);
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(5);
        nums.add(list1);
        List<Integer> list2 = new ArrayList<>();
        list2.add(4);
        list2.add(7);
        nums.add(list2);
        Lc2848PointsThatIntersectWithCars lc2848 = new Lc2848PointsThatIntersectWithCars();
        System.out.println(lc2848.numberOfPoints(nums));

    }

}

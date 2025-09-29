package od;


import java.util.Arrays;
import java.util.Scanner;

/**
 * P00077—项目排期/最少交付时间
 * //todo again
 * @author chenghu
 * @since 2025-09-28 00:24:26
 */
public class Od423ProjectArrangement {

    /**
     * 项目组共有N个开发人员，项目经理接到了M个独立的需求，每个需求的工作量不同，且每个需求只能由一个开发人员独立完成，不能多人合作。假定各个需求直接无任何先后依赖关系，请设计算法帮助项目经理进行工作安排，使整个项目能用最少的时间交付。
     * <p>
     * 输入描述 第一行输入为M个需求的工作量，单位为天，用逗号隔开 例如: X1 X2 X3 ... Xm 。表示共有M个需求，每个需求的工作量分别为X1天，X2天...Xm天其中0<M<30; 0<Xm<200 第二行输入为项目组人员数量N 输出描述
     * <p>
     * 输出最快完成工作的天数
     * <p>
     * 示例1： 输入: 6 2 7 7 9 3 2 1 3 11 4 2 输出: 28 说明: 共有两位员工，其中一位分配需求 6 2 7 7 3 2 1共需要28天完成，另一位分配需求 9 3 11 4共需要27天完成，故完成所有工作至少需要28天。
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nums = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = Integer.parseInt(sc.nextLine());
        System.out.println(f(nums, n));
    }

    public static int f(int[] nums, int k) {
        int l = 0;
        int r = 0;
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            l = Math.max(x, l);
            r = r + x;
        }
        int ans = 0;
        while (l <= r) {
            int mid = (r + l) / 2;
            // 满足了条件
            if (ok(nums, mid, k)) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }

    private static boolean ok(int[] nums, int mid, int k) {
        int[] workers = new int[k];
        return dfs(nums, workers, k, 0, mid);
    }

    private static boolean dfs(int[] nums, int[] workers, int k, int index, int limit) {
        if (index == nums.length) {
            return true;
        }
        for (int i = 0; i < k; i++) {
            if (workers[i] + nums[index] <= limit) {
                workers[i] = workers[i] + nums[index];
                if (dfs(nums, workers, k, index + 1, limit)) {
                    return true;
                }
                workers[i] = workers[i] - nums[index];
            }
        }
        return false;
    }


}

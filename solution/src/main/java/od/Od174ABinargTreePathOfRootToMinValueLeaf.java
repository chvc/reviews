package od;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 *  P00174— 数组二叉树 / 寻找路径
 *  直接用索引间的关系处理最简单
 * @author chenghu
 * @since 2025-09-04 23:29:00
 */
public class Od174ABinargTreePathOfRootToMinValueLeaf {

    static int size;

    static List<Integer> res = new ArrayList<>();

    static int[] nums;

    static int min = Integer.MAX_VALUE;

    static int minLeafIndex = -1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        nums = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        size = nums.length;
//        List<Integer> path = new ArrayList<>();
//        // 从根路径出发
//        dfs(1, path);
//        String s = res.stream().map(String::valueOf).collect(Collectors.joining(" "));
//        System.out.println(s);
        for (int i = 1; i <= nums.length; i++) {
            findMinLeaf(i);
        }
        // 找到了最小的叶子节点的索引 向上推父节点的索引
        int cur = minLeafIndex;

        while (cur >= 1) {
            res.add(nums[cur - 1]);
            cur = parentIndex(cur);
        }
        Collections.reverse(res);
        String s = res.stream().map(String::valueOf).collect(Collectors.joining(" "));
        System.out.println(s);
        res.clear();
    }

    // 递归做
    public static void dfs(int index, List<Integer> path) {
        // 当前索引越界
        if (index > size) {
            return;
        }
        int num = nums[index - 1];
        if (num == -1) {
            return;
        }
        path.add(num);
        // 子节点索引越界
        if (isLeaf(index)) {
            // 是叶子节点
            if (num < min) {
                min = num;
                res = new ArrayList<>(path);
            }
        }
        // 往左右子树走
        dfs(index * 2, path);
        dfs(index * 2 + 1, path);
        path.remove(path.size() - 1);
    }

    public static boolean hasChild(int index) {
        return index <= size;
    }

    public static void findMinLeaf(int index) {
        if (!isLeaf(index)) {
            return;
        }
        // 判断是不是最小的那个
        int num = nums[index - 1];
        if (num == -1) {
            return;
        }
        if (num < min) {
            min = num;
            minLeafIndex = index;
        }
    }

    public static boolean isLeaf(int index) {
        // 有左子树且子树为-1;
        // 有右子树且子树为-1
        int l = index * 2;
        int r = index * 2 + 1;
        // 或者没有子树
        if ((hasChild(l) && nums[l - 1] != -1) || (hasChild(r) && nums[r - 1] != -1)) {
            return false;
        }
        return true;
    }

    public static int parentIndex(int index) {
        return index / 2;
    }
}

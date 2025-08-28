package temp;

import java.util.Scanner;

public class Main {
    private static int x;
    private static int y;
    private static int cntx;
    private static int cnty;
    //    某公司部门需要派遣员工去国外做项目。
//    现在，代号为 x 的国家和代号为 y 的国家分别需要 cntx 名和 cnty 名员工部门每个员工有一个员工号 (1,2,3,......)，工号连续，从 1开始。部长派遣员工的规则:
//    规则1: 从 1,k中选择员工派遣出去
//    规则2: 编号为 x的倍数的员工不能去 x国，编号为 y 的倍数的员工不能去y 国
//    问题
//    找到最小的k，使得可以将编号在 [1,k] 中的员工分配给 x 国和 y 国，且满足 x 国和 y 国的需求
//
//            输入描述
//    四个整数 x,y,cntx,cnty。
//            2 < x < y < 30000
//    x和y 一定是质数
//1 < cntx, cnty < 10^9
//    cntx + cnty < 10^9
//    输出描述
//    满足条件的最小的 k
//
//    示例1：
//
//    输入：
//
//            2 3 3 1
//
//    输出：
//
//            5
//
//    说明:
//
//    输入中：
//            2 表示国家代号 2
//            3 表示国家代号 3
//            3 表示国家 2 需要3 个人
//
//1 表示国家 3 需要1个人
//
//            输出的5表示k最小为5


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        x = in.nextInt();
        y = in.nextInt();
        cntx = in.nextInt();
        cnty = in.nextInt();

        int n = cntx + cnty;
        int l = n;
        int r = 2 * l;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (check(mid)) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        System.out.println(l);
    }

    private static boolean check(int num) {
        long onlyX = num / x - num / (x * y); // 只能去 y 国
        long onlyY = num / y - num / (x * y); // 只能去 x 国
        long both  = num - onlyX - onlyY - num / (x * y); // 都能去

        long needX = Math.max(0, cntx - onlyY);
        long needY = Math.max(0, cnty - onlyX);

        return needX + needY <= both;
    }
}

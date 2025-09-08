package od;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025/8/17
 */
public class Main {


    static int[] gems;


//    public static void main(String[] args) throws IOException {
//        //
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        StreamTokenizer in = new StreamTokenizer(reader);
//        while (in.nextToken() != StreamTokenizer.TT_EOF) {
//            int number = (int) in.nval;
//            gems = new int[number];
//            for (int i = 0; i < number; i++) {
//                in.nextToken();
//                int num = (int) in.nval;
//                gems[i] = num;
//            }
//            in.nextToken();
//            int amount = (int) in.nval;
//            int cnt = canBuyMaxCnt(gems, amount);
//            System.out.println(cnt ==Integer.MIN_VALUE?0:cnt);
//        }
//
//    }

    public static int canBuyMaxCnt(int[] gems, int amount) {
        int left = 0;
        int right = 0;
        int sum = 0;
        int ans = Integer.MIN_VALUE;
        while (right < gems.length) {
            if (sum + gems[right] <= amount) {
                sum += gems[right];
                ans = Math.max(ans, right - left + 1);
                right++;
            } else {
                if (left == right) {
                    left++;
                    right++;
                    sum = 0;
                } else {
                    sum -= gems[left];
                    left++;
                }
            }
        }
        return ans;
    }

    //此代码设置k为1e9的范围


    // 计算不能去某国家的员工数量
    public static int calculateUnavailableWorkers(int k, int divisor) {
        return k / divisor;
    }

    // 计算实际需求
    public static int calculateNeeds(int cnt, int unavailable, int commonUnavailable) {
        return Math.max(0, cnt - (unavailable - commonUnavailable));
    }

    // 找到最小的满足条件的k值
    public static int findMinimumK(int x, int y, int cntX, int cntY) {
        int left = cntX + cntY; // 左边界初始化为x国和y国的总需求
        int right = (int) 1e9;  // 右边界初始化为一个较大的数

        while (left <= right) { // 使用二分查找找到满足条件的最小k值
            int mid = (left + right) / 2; // 中间值
            int cantGoX = calculateUnavailableWorkers(mid, x); // 不能去x国的员工数量
            int cantGoY = calculateUnavailableWorkers(mid, y); // 不能去y国的员工数量
            int cantGoBoth = calculateUnavailableWorkers(mid, x * y); // 不能同时去x国和y国的员工数量

            // 计算实际需求
            int actualNeedX = calculateNeeds(cntX, cantGoY, cantGoBoth);
            int actualNeedY = calculateNeeds(cntY, cantGoX, cantGoBoth);
            int available = mid - cantGoX - cantGoY + cantGoBoth; // 可以派遣的员工数量

            // 根据实际需求和可派遣的员工数量更新边界
            if (actualNeedX + actualNeedY <= available) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left; // 返回最小的k值
    }

    // 主函数
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int x = scanner.nextInt(); // 输入x国的代号
//        int y = scanner.nextInt(); // 输入y国的代号
//        int cntX = scanner.nextInt(); // 输入x国的人数需求
//        int cntY = scanner.nextInt(); // 输入y国的人数需求
//
//        System.out.println(findMinimumK(x, y, cntX, cntY)); // 输出最小的k值
//    }

    public static void main1(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] params = split(in.nextLine(), " ");
        int M = params[0];
        int N = params[1];

        int[] cars = new int[M];
        for (int i = 0; i < M; i++) {
            cars[i] = Integer.parseInt(in.nextLine());
        }
        double result = 0;

        int i = 0;
        while (true) {
            if (i >= M) {
                System.out.println(String.format("%.1f", result));
                break;
            } else {
                if (i == 0) {
                    result = Double.valueOf(N) / cars[i];
                } else if (result <= Double.valueOf(N) / cars[i] + 1) {
                    result = Double.valueOf(N) / cars[i];
                } else {
                    result = result - 1;
                }
            }
            i += 1;
        }
    }

    public static int[] split(String input_str, String chars) {
        String[] tmp2 = input_str.split(chars);
        int[] counts = new int[tmp2.length];
        for (int i = 0; i < tmp2.length; i++) {
            counts[i] = Integer.parseInt(tmp2[i]);
        }
        return counts;
    }

    public static void main(String[] args) {
        int testTime = 1000;
        // 生成一个数
        // 0-10000
        System.out.println("测试开始");
        for (int i = 0; i < testTime; i++) {
            int n = new Random().nextInt(101);
            int x1 = f1(n);
            int x2 = f2(n);
            if (x1 != x2) {
                System.out.println("结果不正确:" + "n是:" + n + ",x1是:" + x1 + "," + "x2是:" + x2);
            }
        }
        System.out.println("测试结束");
    }

    public static int f1(int n) {
        int cnt = 0;
        for (int i = 0; i <= n; i++) {
            if (String.valueOf(i).contains("4")) {
                cnt++;
            }
        }
        return n - cnt;
    }

    public static int f2(int n) {
        // 以10进制形式处理
        int x = 0;
        int cnt = 0;
        int z = n;
        while (n > 0) {
            int mod = n % 10;
            if (x == 0) {
                if (mod >= 4) {
                    cnt++;
                }
            } else {
                if (mod != 0) {
                    int i = f3(x) * mod;
                    cnt = cnt + i;
                }
            }
            n = n / 10;
            x++;
        }
        return z - cnt;
    }

    public static int f3(int n) {
        if (n == 1) {
            return 1;
        }
        return (int) (f3(n - 1) * 9 + Math.pow(10, n - 1));
    }

}




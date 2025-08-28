package od;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025-08-23 01:59:59
 */
public class Od389 {

//    公司组织了一次考试,现在考试结果出来了，想看一下有没人存在作弊行为,但是员工太多了,需要先对员工进行一次过滤,再进一步确定是否存在作弊行为。
//    过滤的规则为:找到分差最小的员工ID对(p1,p2)列表,要求p1<p2
//    员工个数,取值范国:0<n<100000
//    员工ID为整数,取值范围:0<=n<=100000
//    考试成绩为整数,取值范围:0<=score<=300
//    输入描述
//            员工的ID及考试分数
//    输出描述
//    分差最小的员工ID对(p1,p2)列表,要求p1<p2。每一行代表一个集合,每个集合内的员工ID按顺序排列,多行结果也以员工对中p1值大小升序排列(如果p1相同则p2升序)。
//
//    示例1：
//    输入:
//            5
//            1 90
//            2 91
//            3 95
//            4 96
//            5 100
//    输出:
//            1 2
//            3 4
//    说明:
//    输入: 第一行为员工个数n，后续的n行第一个数值为员工ID,第二个数值为员工考试分数输出:员工1和员工2的分差为1,员工3和员工4的分差也为1,因此最终结果为
//1 2
//        3 4
//
//    示例2：
//
//    输入:
//            5
//            1 90
//            2 91
//            3 92
//            4 85
//            5 86
//    输出:
//            1 2
//            2 3
//            4 5

    //    输入: 第一行为员工个数n，后续的n行第一个数值为员工ID,第二个数值为员工考试分数输出:员工1和员工2的分差为1,员工3和员工4的分差也为1,因此最终结果为

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        List<People> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int[] input = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            list.add(new People(input[0], input[1]));
        }
        Collections.sort(list);
        int minDiff = Integer.MAX_VALUE;
        List<List<People>> result = new ArrayList<>();
        for (int i = 0; i < list.size() - 1; i++) {
            int diff = list.get(i + 1).point - list.get(i).point;
            if (diff > minDiff) {
                continue;
            }
            List<People> pair = new ArrayList<>();
            pair.add(list.get(i));
            pair.add(list.get(i + 1));
            if (diff < minDiff) {
                minDiff = diff;
                result.clear();
            }
            result.add(pair);
        }

        result.sort((o1, o2) -> {
            if (o1.get(0).id == o2.get(0).id) {
                return o1.get(1).id - o2.get(1).id;
            }
            return o1.get(0).id - o2.get(0).id;
        });
        for (List<People> peopleList : result) {
            System.out.println(peopleList.get(0).id + " " + peopleList.get(1).id);
        }
    }

    static class People implements Comparable<People> {
        int id;
        int point;

        public People(int id, int point) {
            this.id = id;
            this.point = point;
        }

        @Override
        public int compareTo(People o) {
            if (this.point == o.point) {
                return this.id - o.id;
            }
            return this.point - o.point;
        }
    }


}

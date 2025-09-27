package od;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * #P00087. 华为od机试—智能成绩表
 *
 * @author chenghu
 * @since 2025-09-27 16:47:40
 */
public class Od412GeniusScoreTable {

    /**
     * 小明来到某学校当老师，需要将学生按考试总分或单科分数进行排名，你能帮帮他吗?
     * 输入描述
     * 第 1 行输入两个整数，学生人数 n 和科目数量 m
     * 0<n<100
     * 0<m < 10
     * 第 2 行输入 m 个科目名称，彼此之间用空格隔开，
     * 科目名称只由英文字母构成，单个长度不超过10个字符。
     * 科目的出现顺序和后续输入的学生成绩一一对应
     * 不会出现重复的科目名称
     * 第 3 行开始的 n 行，每行包含一个学生的姓名和该生 m 个科目的成绩 (空格隔开)。学生不会重名
     * 学生姓名只由英文字母构成，长度不超过10个字符
     * 成绩是0~100的整数，依次对应第2行种输入的科目
     * 第n+2行，输入用作排名的科目名称。若科目不存在，则按总分进行排序.
     * 输出描述
     * 输出一行，按 成绩排序后的学生名字，空格隔开。成绩相同的按照学生姓名字典顺序排序
     * 示例1：
     * <p>
     * 输入
     * 3 2
     * yuwen shuxue
     * fangfang 95 90
     * xiaohua 88 95
     * minmin 100 82
     * shuxue
     * 输出
     * <p>
     * xiaohua fangfang minmin
     * 说明
     * 按shuxue成绩排名，依次是xiaohua、fangfang、minmin
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] s = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = s[0];
        int m = s[1];
        Map<Integer, String> subjectMap = new HashMap<>();

        String[] subjectNum = sc.nextLine().split(" ");
        for (int i = 0; i < m; i++) {
            subjectMap.put(i, subjectNum[i]);
        }
        Set<String> set = new HashSet<>(subjectMap.values());
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] split = sc.nextLine().split(" ");
            Student student = new Student();
            student.name = split[0];
            int total = 0;
            for (int j = 1; j < split.length; j++) {
                int scr = Integer.parseInt(split[j]);
                total += scr;
                student.scoreMap.put(subjectMap.get(j - 1), scr);
            }
            student.score = total;
            students.add(student);
        }
        String key = sc.nextLine();
        if (key.isEmpty() || !set.contains(key)) {
            students.sort((s1, s2) -> {
                Integer ss1 = s1.score;
                Integer ss2 = s2.score;
                if (!Objects.equals(ss1, ss2)) {
                    return ss2.compareTo(ss1);
                }
                return s1.name.compareTo(s2.name);
            });
            String res = students.stream().map(stu -> stu.name).collect(Collectors.joining(" "));
            System.out.println(res);
        } else {
            students.sort((s1, s2) -> {
                Integer ss1 = s1.scoreMap.get(key);
                Integer ss2 = s2.scoreMap.get(key);
                if (!Objects.equals(ss1, ss2)) {
                    return ss2.compareTo(ss1);
                }
                return s1.name.compareTo(s2.name);
            });
            String res = students.stream().map(stu -> stu.name).collect(Collectors.joining(" "));
            System.out.println(res);

        }
    }

    static class Student {
        String name;
        Map<String, Integer> scoreMap = new HashMap<>();
        Integer score;
    }
}

package od.exam.c;


import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * P00360—单词重量
 *
 * @author chenghu
 * @since 2025-08-26 22:01:21
 */
public class Od258WordWeigh {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        List<String> words = Arrays.stream(s.split(" ")).filter(e -> !e.isEmpty()).collect(Collectors.toList());
        double sum = 0;
        for (int i = 0; i < words.size(); i++) {
            sum += words.get(i).length();
        }
        // 四舍五入

        double res = sum / words.size();
        System.out.printf("%.2f%n",res);

    }
}

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ForkJoinPool;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025/8/9
 */
public class Main2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        printNumber(n);

//        System.out.println(String.format("%-4s", 100));
//        System.out.println(MessageFormat.format("{0}", 100));
    }


    public static void printNumber(int n) {
        int cnt = 1;
        List<List<String>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<String> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                row.add(String.format("%-4s",cnt).replace(" ","*"));
                cnt++;
            }
            if (i%2!=0){
               Collections.reverse(row);
            }
            list.add(row);
        }
        for (int i = 0; i < list.size(); i++) {
            List<String> row = list.get(i);

            String join = String.join("    ", row);
            if (i==list.size()-2){
                join = "    "+ join;
            }
            System.out.println(join);
        }
        for (List<String> row : list) {

        }
    }

}

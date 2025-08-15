package od;


import javax.xml.transform.Source;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025-08-10 13:14:37
 */
public class Od10 {

    static List<Integer[]> test_data = new ArrayList<>();

    static int[] arr;

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int[] arr = new int[6];
            String ans = "";
            boolean[] used = new boolean[6];
            for (int i = 0; i < 6; i++) {
                arr[i] = scanner.nextInt();
            }
            dfs(arr, 0, new StringBuilder());
            System.out.println(ans.isEmpty() ? "invalid" : ans.substring(0, 2) + ":" + ans.substring(2, 4) + ":" + ans.substring(5));
        }
//        Integer[] arr = new Integer[6];
//        generateTestCase(0, arr);
//        File file = new File("./result.txt");
//        FileOutputStream fos = new FileOutputStream(file);
//
//        FileWriter fileWriter = new FileWriter(file);
//        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
//        System.out.println(test_data.size());
//        for (int i = 0; i < test_data.size(); i++) {
//            ans = "";
//            Integer[] array = test_data.get(i);
//            bufferedWriter.append(Arrays.toString(array));
//            try {
//                dfs(Arrays.stream(array).mapToInt(s -> s).toArray(), 0, new StringBuilder());
//            } catch (Exception e) {
//                System.out.println("exception----->");
//            }
//            String formation = "最大的时间是:" + (ans.isEmpty() ? "invalid\n" : ans.substring(0, 2) + ":" + ans.substring(2, 4) + ":" + ans.substring(4)+"\n");
//            bufferedWriter.append(formation);
//        }
    }

    static boolean[] used = new boolean[6];

    static String ans = "";

    public static void dfs(int[] arr, int i, StringBuilder sb) {

        if (i == 2 && Integer.parseInt(sb.toString()) >= 24) {
            return;
        }
        if (i == 4 && Integer.parseInt(sb.substring(2, 4)) >= 60) {
            return;
        }
        // 到结尾了
        if (i == 6) {
            if (Integer.parseInt(sb.substring(4)) >= 60) {
                return;
            }
            // 加入结果中去
            if (sb.toString().compareTo(ans) > 0) {
                ans = sb.toString();
            }
            return;
        }

        for (int j = 0; j < arr.length; j++) {
            if (!used[j]) {
                sb.append(arr[j]);
                used[j] = true;
                dfs(arr, i + 1, sb);
                sb.deleteCharAt(sb.length() - 1);
                used[j] = false;
            }
        }
    }

    static boolean[] use = new boolean[10];

    public static void generateTestCase(int i, Integer[] arr) {
        if (i == 6) {
            test_data.add(Arrays.copyOf(arr, arr.length));
            return;
        }
        for (int j = 0; j < 10; j++) {
            arr[i] = j;
            generateTestCase(i + 1, arr);
        }
    }


}

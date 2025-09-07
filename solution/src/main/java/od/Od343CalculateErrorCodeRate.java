package od;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025-09-06 23:32:04
 */
public class Od343CalculateErrorCodeRate {
    public static void main1(String[] args) throws IOException {
        File file = new File("a.in");
        FileReader fileReader = new FileReader(file);
        BufferedReader reader = new BufferedReader(fileReader);
        String s = reader.readLine();

        Runtime rt = Runtime.getRuntime();
        long used = (rt.totalMemory() - rt.freeMemory()) / 1024 / 1024;
        long max = rt.maxMemory() / 1024 / 1024;
        System.out.println("已使用内存: " + used + " MB, 最大可用内存: " + max + " MB");
        long start = System.currentTimeMillis();
        String s1 = unCompress(s);
        String s2 = s1;
        // 逐位比较
        int errorCnt = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                errorCnt++;
            }
        }
        System.out.println(errorCnt + "/" + s1.length());
        long end = System.currentTimeMillis();
        System.out.println("耗时:"+(end-start) /1000);
        long used2 = (rt.totalMemory() - rt.freeMemory()) / 1024 / 1024;
        long max2 = rt.maxMemory() / 1024 / 1024;
        System.out.println("已使用内存: " + used2 + " MB, 最大可用内存: " + max2 + " MB");
    }

    public static String unCompress(String str) {
        int cur = 0;
        char[] s = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length; i++) {
            char c = s[i];
            if (Character.isDigit(c)) {
                cur = cur * 10 + c - '0';
            } else {
                // 是字母 就结算
                for (int j = 0; j < cur; j++) {
                    sb.append(c);
                }
                cur = 0;
            }
        }
        return sb.toString();
    }

    public static void main3(String[] args) throws IOException {
        File file = new File("a.in");
        FileReader fileReader = new FileReader(file);
        BufferedReader reader = new BufferedReader(fileReader);
        String s1 = reader.readLine();
        String s2 = s1;
        int i = 0, j = 0;
        Runtime rt = Runtime.getRuntime();
        long used = (rt.totalMemory() - rt.freeMemory()) / 1024 / 1024;
        long max = rt.maxMemory() / 1024 / 1024;
        System.out.println("已使用内存: " + used + " MB, 最大可用内存: " + max + " MB");
        long start = System.currentTimeMillis();
        int len1 = s1.length(), len2 = s2.length();
        long errorCnt = 0, total = 0;

        int count1 = 0, count2 = 0;
        char c1 = 0, c2 = 0;

        while (i < len1 || count1 > 0 || j < len2 || count2 > 0) {
            // 如果当前段消耗完了，就解析下一段
            if (count1 == 0 && i < len1) {
                int num = 0;
                while (i < len1 && Character.isDigit(s1.charAt(i))) {
                    num = num * 10 + (s1.charAt(i) - '0');
                    i++;
                }
                c1 = s1.charAt(i++);
                count1 = num;
            }
            if (count2 == 0 && j < len2) {
                int num = 0;
                while (j < len2 && Character.isDigit(s2.charAt(j))) {
                    num = num * 10 + (s2.charAt(j) - '0');
                    j++;
                }
                c2 = s2.charAt(j++);
                count2 = num;
            }

            // 比较 min(count1, count2) 段
            int min = Math.min(count1, count2);
            if (c1 != c2) {
                errorCnt += min;
            }
            total += min;
            count1 -= min;
            count2 -= min;
        }

        System.out.println(errorCnt + "/" + total);
        long end = System.currentTimeMillis();
        System.out.println("耗时:"+(end-start) /1000);
        long used2 = (rt.totalMemory() - rt.freeMemory()) / 1024 / 1024;
        long max2 = rt.maxMemory() / 1024 / 1024;
        System.out.println("已使用内存: " + used2 + " MB, 最大可用内存: " + max2 + " MB");
    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        test();
        File file = new File("a.in");
        FileWriter fileWriter = new FileWriter(file);

//        for (int i = 0; i < 1000000; i++) {
//            if (i % 2 == 0) {
//                fileWriter.append('1').append('A');
//            } else {
//                fileWriter.append('1').append('B');
//            }
//        }
        in.nextInt();
    }

    private static void test() throws IOException {
        File file = new File("a.in");
        FileReader fileReader = new FileReader(file);
        BufferedReader reader = new BufferedReader(fileReader);
        String s1 = reader.readLine();
        String s2 = s1;
        Runtime rt = Runtime.getRuntime();
        long used = (rt.totalMemory() - rt.freeMemory()) / 1024 / 1024;
        long max = rt.maxMemory() / 1024 / 1024;
        System.out.println("已使用内存: " + used + " MB, 最大可用内存: " + max + " MB");
        long start = System.currentTimeMillis();
        List<Pair> list1 = parse(s1);
        List<Pair> list2 = parse(s2);

        long errors = 0;
        long total = 0;

        int i = 0, j = 0;
        long c1 = list1.get(0).count, c2 = list2.get(0).count;
        char ch1 = list1.get(0).ch, ch2 = list2.get(0).ch;

        while (i < list1.size() && j < list2.size()) {
            long use = Math.min(c1, c2);
            total += use;
            if (ch1 != ch2) {
                errors += use;
            }
            c1 -= use;
            c2 -= use;

            if (c1 == 0 && ++i < list1.size()) {
                c1 = list1.get(i).count;
                ch1 = list1.get(i).ch;
            }
            if (c2 == 0 && ++j < list2.size()) {
                c2 = list2.get(j).count;
                ch2 = list2.get(j).ch;
            }
        }

        System.out.println(errors + "/" + total);
        long end = System.currentTimeMillis();
        System.out.println("耗时:"+(end-start) /1000);
        long used2 = (rt.totalMemory() - rt.freeMemory()) / 1024 / 1024;
        long max2 = rt.maxMemory() / 1024 / 1024;
        System.out.println("已使用内存: " + used2 + " MB, 最大可用内存: " + max2 + " MB");
//        File file = new File("a.in");
//        FileWriter fileWriter = new FileWriter(file);
//
//        for (int i = 0; i < 100000000; i++) {
//            if (i % 2 == 0) {
//                fileWriter.append('1').append('A');
//            } else {
//                fileWriter.append('1').append('B');
//            }
//        }
    }

    static class Pair {
        long count;
        char ch;

        Pair(long c, char ch) {
            this.count = c;
            this.ch = ch;
        }
    }

    private static List<Pair> parse(String s) {
        List<Pair> list = new ArrayList<>();
        int n = s.length();
        int i = 0;
        while (i < n) {
            int j = i;
            long num = 0;
            while (j < n && Character.isDigit(s.charAt(j))) {
                num = num * 10 + (s.charAt(j) - '0');
                j++;
            }
            char ch = s.charAt(j);
            list.add(new Pair(num, ch));
            i = j + 1;
        }
        return list;
    }


}

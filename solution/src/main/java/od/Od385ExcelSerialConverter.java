package od;


import java.util.Scanner;

/**
 * #P00070—正整数到excel编号之间的转换
 *
 * @author chenghu
 * @since 2025-09-28 00:47:06
 */
public class Od385ExcelSerialConverter {

    /**
     * 用过excel的都知道excel的列编号是这样的：
     * a b c .... z aa ab ac .... az ba bb bc .... yz za zb zc .... zz aaa aab aac ....
     * 分别代表以下编号：
     * 1 2 3 .... 26 27 28 29 .... 52 53 54 55 .... 676 677 678 679 .... 702 703 704 705 .... 请写个函数，完成从一个正整数到这种字符串之间的转换。
     * <p>
     * 输入描述：
     * <p>
     * 一行，一个数字
     * <p>
     * 输出描述：
     * <p>
     * excel样式的字符串
     * <p>
     * <p>
     * 示例1：
     * <p>
     * 输入：
     * <p>
     * 1
     * <p>
     * 输出：
     * <p>
     * a
     * <p>
     * 示例2：
     * <p>
     * 输入：
     * <p>
     * 26
     * <p>
     * 输出：
     * <p>
     * z
     * <p>
     * 示例3：
     * <p>
     * 输入：
     * <p>
     * 27
     * <p>
     * 输出：
     * <p>
     * aa
     *
     * @param args
     */


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(convert(n));
    }

    public static String convert(int n) {
        StringBuilder sb = new StringBuilder();
        while (n != 0) {
            n--;
            int x = n % 26;
            sb.append((char) ('a' + (x)));
            n = n / 26;
        }
        return sb.reverse().toString();
    }

}

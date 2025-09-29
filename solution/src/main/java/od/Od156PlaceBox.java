package od;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * #P00100—箱子之字形摆放
 *
 * @author chenghu
 * @since 2025-09-27 21:15:27
 */
public class Od156PlaceBox {

    /**
     * 题目：之字形摆放箱子
     * <p>
     * 题目描述：
     * 有一批箱子（形式为字符串，设为str），要求将这批箱子按从上到下以之字形的顺序摆放在宽度为n的空地，请输出箱子的摆放位置。
     * <p>
     * 例如：箱子ABCDEFG，空地宽度为3，摆放结果如下：
     * AFG
     * BE
     * CD
     * <p>
     * 输入描述：
     * 输入一行字符串，通过空格分隔，前面部分为字母或数字组成的字符串str，表示箱子；
     * 后面部分为数字n，表示空地的宽度。
     * 例如：ABCDEFG 3
     * <p>
     * 输出描述：
     * 按照之字形顺序输出箱子的摆放位置。
     * <p>
     * 备注：
     * 1. 请不要在最后一行输出额外的空行
     * 2. str只包含字母和数字，1 <= len(str) <= 1000
     * 3. 1 <= n <= 1000
     * <p>
     * 示例1：
     * 输入：
     * ABCDEFG 3
     * 输出：
     * AFG
     * BE
     * CD
     * <p>
     * 示例2：
     * 输入：
     * A1B2C3D4 2
     * 输出：
     * A1C3
     * B2D4
     * <p>
     * 示例3：
     * 输入：
     * ABCDE 4
     * 输出：
     * AE
     * B
     * C
     * D
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] split = s.split(" ");
        String str = split[0];
        int n = Integer.parseInt(split[1]);
        List<List<String>> lists = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            lists.add(new ArrayList<>());
        }
        StringBuilder sb = new StringBuilder();
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            list.add(String.valueOf(c));
        }
        if (sb.length() != 0) {
            list.add(sb.toString());
        }
        int step = 1;
        int index = 0;
        int size = lists.size();
        for (int i = 0; i < list.size(); i++) {
            String ss = list.get(i);
            lists.get(index).add(ss);
            index = index + step;
            if (index == size) {
                step = -1;
                index = size - 1;
            }
            if (index == -1) {
                step = 1;
                index = 0;
            }
        }
        for (int i = 0; i < size; i++) {
            System.out.println(String.join("", lists.get(i)));
        }
    }
}

package misc;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class Main2 {


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        int count = 0;
        char lastChar = ' ';
        int cur = 0;
        while ((line = reader.readLine()) != null) {
            String result = decompressString(line);
            System.out.println(result);
        }
    }

    public static boolean check(String param) {
        if (Character.isDigit(param.charAt(param.length() - 1))) {
            return false;
        }

        for (char c : param.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                continue;
            }
            return false;
        }

        return true;
    }

    // 判断字符是否为数字
    public static boolean isNumeric(char c) {
        return Character.isDigit(c);
    }

    // 解压缩字符串
    public static String decompressString(String input) {
        // 检查输入字符串是否合法
        if (!check(input)) {
            return "!error";
        }

        List<String> chList = new ArrayList<>(); // 存储连续个数和字符的列表
        String item = ""; // 当前连续个数的字符串表示
        boolean isNumber = false; // 标记前一个字符是否是数字
        String result = ""; // 解压后的字符串结果

        // 遍历输入字符串
        for (char c : input.toCharArray()) {
            if (isNumeric(c)) { // 当前字符是数字
                if (isNumber) { // 前一个字符也是数字
                    item += c; // 将数字字符拼接到连续个数的字符串表示中
                } else { // 前一个字符不是数字
                    item = Character.toString(c); // 更新连续个数的字符串表示
                    isNumber = true; // 标记前一个字符是数字
                }
            } else { // 当前字符是字母
                if (isNumber) { // 前面的字符是数字
                    chList.add(item); // 将连续个数的字符串表示添加到列表中
                    item = ""; // 重置连续个数的字符串表示
                    isNumber = false; // 标记前一个字符不是数字
                }
                chList.add(Character.toString(c)); // 将当前字母添加到列表中
            }
        }

        boolean flag = false; // 标记前一位是否是数字
        // 遍历连续个数和字符的列表
        for (int i = 0; i < chList.size(); i++) {
            String n = chList.get(i);
            if (n.length() == 1) { // 单个字符，可能是数字或字母
                if (isNumeric(n.charAt(0))) { // 是数字
                    int length = Integer.parseInt(n); // 连续个数
                    if (length <= 2) { // 连续个数小于等于2，不合法
                        return "!error";
                    }
                    // 将字符按连续个数拼接到结果中
                    result += new String(new char[length]).replace("\0", chList.get(i + 1));
                    flag = true;
                } else { // 是字母
                    if (!flag) { // 前一位不是数字
                        result += n; // 直接拼接到结果中
                    }
                    flag = false;
                }
            } else { // 多个字符，肯定是数字
                int length = Integer.parseInt(n); // 连续个数
                flag = true;
                // 将字符按连续个数拼接到结果中
                result += new String(new char[length]).replace("\0", chList.get(i + 1));
            }
        }

        return result;
    }

}

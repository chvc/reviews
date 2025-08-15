package od;


import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025-08-10 11:09:44
 */
public class Od2 {

    String pattern = "[+-]?\\d+(\\.\\d+)?";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        while (scanner.hasNext()) {
//            String input = scanner.nextLine();
//
//            char[] charArray = input.toCharArray();
//
//            int len = 0;
//            int l = 0;
//            int r = 0;
//            String ans = "";
//            while (r < charArray.length) {
//                char c = charArray[r];
//                // 不是数字 那么可能是 . + -
//                if (!Character.isDigit(c)) {
//                    // 如果是中途的+-也不能算入
//                    if (c == '+' || c == '-') {
//                        if (r > l) {
//                            int tempLen = r - l + 1;
//                            if (tempLen >= len) {
//                                len = tempLen;
//                                ans = input.substring(l, r + 1);
//                            }
//                            // 计算完结果后
//                            l = r;
//                        } else {
//                            // 否则就是开头了
//                            // 判断下一个字符是不是数字
//                            if (r + 1 < charArray.length) {
//                                // 数字是有效的
//                                if (!Character.isDigit(charArray[r + 1])) {
//                                    r++;
//                                    l = r;
//                                } else {
//                                    r++;
//                                }
//                            } else {
//                                r++;
//                                l = r;
//                            }
//                        }
//                    } else if (c == '.') {
//                        // 说明不是开头 可以继续走
//                        if (r > l) {
//                            // 判断下 r 可以到多远的为止上去 也就是 r接下来的位置必须都是 数字
//                            while (r + 1 < charArray.length && Character.isDigit(charArray[r + 1])) {
//                                r++;
//                            }
//                            int tempLen = r - l + 1;
//                            if (tempLen >= len) {
//                                len = tempLen;
//                                ans = input.substring(l, r + 1);
//                            }
//                            r++;
//                            // 计算完结果后
//                            l = r;
//                        } else {
//                            // 如果是开头的话 都跳到下一个位置上去
//                            r++;
//                            l = r;
//                        }
//                    }
//                    // 如果是字母 那么一定不能加入 计算结果
//                    else {
//                        int tempLen = r - l;
//                        if (tempLen >= len) {
//                            len = tempLen;
//                            ans = input.substring(l, r);
//                        }
//                        r++;
//                        l = r;
//                    }
//                } else {
//                    r++;
//                }
//            }
//            System.out.println(ans);
//        }

        System.out.println("avc".substring(0));
    }


}

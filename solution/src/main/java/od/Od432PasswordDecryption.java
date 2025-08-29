package od;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025-08-19 21:09:18
 */
public class Od432PasswordDecryption {

    static char[] mapping = new char[]{
            '0', 'a', 'b', 'c', 'd', 'e',
            'f', 'g', 'h', 'i', 'j', 'k',
            'l', 'm', 'n', 'o', 'p', 'q',
            'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'
    };

    //todo 需要重新写 太复杂了

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = null;

        while ((line = reader.readLine()) != null) {
            char[] charArray = line.toCharArray();
            int i = 0;
            StringBuilder sb = new StringBuilder();
            int cur = 0;
            while (i < charArray.length) {
                // 如果当前是数字的话
                if (Character.isDigit(charArray[i])) {
                    cur = charArray[i] - '0';
                    if (charArray[i] == '1' || charArray[i] == '2') {
                        // 等于1 或者2 的时候 才需要看下两个
                        // 下一个也是数字
                        if (i + 1 >= charArray.length) {
                            // 找当前的cur
                            while (cur != 0) {
                                if (cur > 10) {
                                    int x = cur / 10;
                                    cur = cur % 10;
                                    sb.append(mapping[x]);
                                } else {
                                    if (cur == 10) {
                                        sb.append(mapping[1]);
                                        sb.append(mapping[0]);
                                        cur = 0;
                                    } else {
                                        sb.append(mapping[cur]);
                                        cur = 0;
                                    }
                                }
                            }
                            i = i + 1;
                        } else {
                            if (Character.isDigit(charArray[i + 1])) {
                                cur = cur * 10 + (charArray[i + 1] - '0');
                                // 如果已经大于26了 没有必要再看了 只能解析成单个的了
                                if (cur > 26) {
                                    sb.append(mapping[cur / 10]);
                                    sb.append(mapping[cur % 10]);
                                    cur = 0;
                                    i = i + 2;
                                } else {
                                    // 超出界了
                                    if (i + 2 >= charArray.length) {
                                        // 15
                                        while (cur != 0) {
                                            if (cur > 10) {
                                                int x = cur / 10;
                                                cur = cur % 10;
                                                sb.append(mapping[x]);
                                            } else {
                                                if (cur == 10) {
                                                    sb.append(mapping[1]);
                                                    sb.append(mapping[0]);
                                                    cur = 0;
                                                } else {
                                                    sb.append(mapping[cur]);
                                                    cur = 0;
                                                }
                                            }
                                        }
                                        i = i + 3;
                                    } else {
                                        // 大于10 小于26的 如果第三个还是数字 那就只能单个处理了
                                        if (i + 2 < charArray.length && Character.isDigit(charArray[i + 2])) {
                                            sb.append(mapping[cur / 10]);
                                            sb.append(mapping[cur % 10]);
                                            sb.append(mapping[charArray[i] - '0']);
                                            i = i + 3;
                                            cur = 0;
                                        } else if (i + 2 < charArray.length && charArray[i + 2] == '*') {
                                            sb.append(mapping[cur]);
                                            cur = 0;
                                            i = i + 3;
                                        } else {
                                            // 其他字符 单个解析
                                            sb.append(mapping[cur / 10]);
                                            sb.append(mapping[cur % 10]);
                                            sb.append(charArray[i]);
                                            i = i + 3;
                                            cur = 0;
                                        }
                                    }
                                }
                            } else {
                                sb.append(mapping[cur]);
                                cur = 0;
                                i = i + 1;
                            }
                        }
                    } else {
                        sb.append(mapping[charArray[i] - '0']);
                        i++;
                    }

                } else {
                    sb.append(charArray[i]);
                    i++;
                }
            }
            System.out.println(sb);
        }
    }

}

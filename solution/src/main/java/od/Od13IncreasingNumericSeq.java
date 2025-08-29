package od;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * P00253-非严格递增连续数字序列
 *
 * @author chenghu
 * @since 2025-08-19 01:02:31
 */
public class Od13IncreasingNumericSeq {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        while ((line = reader.readLine()) != null) {
            // 读取到了字符串
            char[] charArray = line.toCharArray();
            int l = 0;
            int r = 0;
            int cur = -1;
            int ans = 0;
            while (r < line.length()) {
                if ((charArray[r] >= 'a' && charArray[r] <= 'z' || (charArray[r] >= 'A' && charArray[r] <= 'Z'))) {
                    // 如果是字母的话 就跳过去
                    cur = -1;
                    r++;
                    l = r;
                } else {
                    if (charArray[r] - '0' >= cur) {
                        cur = charArray[r] - '0';
                        r++;
                    } else {
                        cur = charArray[r] - '0';
                        l = r;
                        r++;
                    }
                }
                ans = Math.max(ans, r - l);
            }
            System.out.println(ans);
        }
    }
}

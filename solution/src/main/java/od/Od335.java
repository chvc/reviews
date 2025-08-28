package od;


import com.sun.deploy.nativesandbox.NativeSandboxBroker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025-08-18 23:37:20
 */
public class Od335 {


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        while ((line = reader.readLine()) != null) {
            int k = Integer.parseInt(reader.readLine());
            char[] dna = line.toCharArray();
            StringBuilder sb = new StringBuilder();
            int count = 0;
            double rate = 0;
            String ans = "";
            for (int i = 0; i < dna.length; i++) {
                // 加入
                char c = dna[i];
                if (c == 'C' || c == 'G') {
                    count++;
                }
                sb.append(c);
                if (k - i > 1) {
                    continue;
                }
                //更新
                double cur = (double) count / k;
                if (cur > rate) {
                    // 更新结果
                    ans = sb.toString();
                    rate = cur;
                }
                // 删除
                if (sb.charAt(0) == 'C' || sb.charAt(0) == 'G') {
                    count--;
                }
                sb.deleteCharAt(0);
            }
            System.out.println(ans);
        }
    }
}

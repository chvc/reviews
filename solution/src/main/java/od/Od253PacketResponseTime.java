package od;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *  P00004—报文响应时间 / 响应报文时间
 *
 * @author chenghu
 * @since 2025-08-19 22:59:01
 */
public class Od253PacketResponseTime {


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        while ((line = reader.readLine()) != null) {
            int num = Integer.parseInt(line);
            int ans = Integer.MAX_VALUE;
            for (int i = 0; i < num; i++) {
                String s = reader.readLine();
                String[] split = s.split(" ");
                int startTime = Integer.parseInt(split[0]);
                int respTime = Integer.parseInt(split[1]);
                if (respTime >= 128) {
                    // 计算高位时间
                    int base = 1;
                    int mant = 0;
                    int exp = 0;
                    for (int j = 0; j < 7; j++) {
                        int x = respTime & base;
                        if (j <= 3) {
                            if (x == base) {
                                mant += (int) Math.pow(2, j);
                            }
                        } else {
                            if (x == base) {
                                exp += (int) Math.pow(2, j - 4);
                            }
                        }
                        base = base << 1;
                    }
                    int resp = (mant | 0x10) << (exp + 3);
                    ans = Math.min(ans, startTime + resp);
                } else {
                    ans = Math.min(ans, startTime + respTime);
                }
            }
            System.out.println(ans);
        }

    }
}

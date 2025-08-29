package od;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *  P00047—最差产品奖
 *
 * @author chenghu
 * @since 2025-08-26 01:46:57
 */
public class Od120WorstProductAward {
    static Map<String, String> map = new HashMap<>();

    static boolean[] flag = new boolean[4];

    static int[] numAFlag = new int[11];
    static int[] numBFlag = new int[11];

    public static void main(String[] args) throws InterruptedException {

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        map.clear();

        for (int i = 0; i < n; i++) {
            String[] split = scanner.nextLine().split(" ");
            map.put(split[0], split[1]);
        }
        long start = System.currentTimeMillis();
        int count = 0;
        String ans = "";
        for (int i = 0; i < 10000; i++) {
            String s = generateNumStr(i);
            boolean br = false;
            for (Map.Entry<String, String> entry : map.entrySet()) {
                // 如果有一个false了 那就说明不是这个数字 直接退出
                if (!check(s, entry.getKey(), entry.getValue())) {
                    br = true;
                    break;
                }
            }
            // 全部都是true 说明命中了
            if (!br) {
                count++;
                ans = s;
            }
        }
        if (count == 1) {
            System.out.println(ans);
        } else {
            System.out.println("NA");
        }
        long end = System.currentTimeMillis();
        System.out.println("耗时:" + (end - start));
    }

    public static String generateNumStr(int n) {
        return String.format("%04d", n);
    }

    public static boolean check(String str, String guess, String pat) {
        int acount = 0;
        int bcount = 0;
        // 假设str是正确的
        Arrays.fill(flag, false);
        Arrays.fill(numAFlag, 0);
        Arrays.fill(numBFlag, 0);
        // 先判断a的数量
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == guess.charAt(i)) {
                acount++;
                flag[i] = true;
            } else {
                numAFlag[str.charAt(i) - '0']++;
                numBFlag[guess.charAt(i) - '0']++;
            }
        }
        // 判断b的数量
        for (int i = 0; i < numAFlag.length; i++) {
            // 都不为0 那就是出现了
            if (numAFlag[i] != 0 && numBFlag[i] != 0) {
                bcount += Math.min(numAFlag[i], numBFlag[i]);
            }
        }
        int actualACount = pat.charAt(0) - '0';
        int actualBCount = pat.charAt(2) - '0';
        return actualACount == acount && actualBCount == bcount;
    }


}

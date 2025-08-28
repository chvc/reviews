package od;


import java.util.Scanner;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025-08-27 21:50:58
 */
public class Od282 {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char[] s = str.toCharArray();
        int lastChaIndex = -1;
        int chaCount = 0;
        int maxLen = 0;
        // [l..r] 维持数量
        for (int l = 0, r = l; l < s.length && r < s.length; ) {
            // 右 一步一步的走
            while (r < s.length && (chaCount == 0 || (chaCount == 1 && !Character.isLetter(s[r])))) {
                if (Character.isLetter(s[r])) {
                    chaCount++;
                    lastChaIndex = r;
                }
                r++;
            }
            maxLen = Math.max(maxLen, r - l);
            chaCount = 0;
            l = lastChaIndex + 1;
        }
        System.out.println(maxLen);
    }


}

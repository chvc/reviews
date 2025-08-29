package od;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * P00213-密室逃生游戏/寻找关键钥匙
 *
 * @author chenghu
 * @since 2025-08-19 22:23:01
 */
public class Od53EscapeRoom {


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        while ((line = reader.readLine()) != null) {
            String[] passwords = reader.readLine().split(" ");
            int[] words = new int[26];
            for (int i = 0; i < line.length(); i++) {
                words[line.charAt(i) - 'a']++;
            }
            for (int i = 0; i < passwords.length; i++) {
                int[] parse = parse(passwords[i]);
                boolean flag = true;
                for (int j = 0; j < parse.length; j++) {
                    if (words[j] != 0 && parse[j] == 0) {
                        flag = false;
                        break;
                    }
                    if (words[j] == 0 && parse[j] != 0) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    System.out.println(i + 1);
                    return;
                }
            }
            System.out.println(-1);
        }
    }

    public static int[] parse(String pd) {
        int[] chars = new int[26];
        for (int i = 0; i < pd.length(); i++) {
            // 如果是字母 就对应的加进去
            if (Character.isLetter(pd.charAt(i))) {
                chars[Character.toLowerCase(pd.charAt(i)) - 'a']++;
            }
        }
        return chars;
    }


}

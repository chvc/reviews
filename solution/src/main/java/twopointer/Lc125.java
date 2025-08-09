package twopointer;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025/7/25
 */
public class Lc125 {

    public boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;
        char[] charArray = s.toCharArray();
        while (l < r) {
            char lc = charArray[l];
            char rc = charArray[r];
            if (!isVaild(lc)){
                l++;
                continue;
            }
            if (!isVaild(rc)){
                r--;
                continue;
            }
            int res = Character.toLowerCase(lc) ^ Character.toLowerCase(rc);
            if (res != 0) {
                return false;
            } else {
                l++;
                r--;
            }
        }
        return true;
    }

    public boolean isVaild(Character character) {
        return Character.isLetterOrDigit(character);
    }

    public static void main(String[] args) {
        Lc125 lc125 = new Lc125();
        System.out.println(lc125.isPalindrome(".,"));
    }



}

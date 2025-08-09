package binarysearch;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025/7/28
 */
public class Lc744 {

    public char nextGreatestLetter(char[] letters, char target) {
        int l = 0;
        int r = letters.length;
        while (l < r) {
            int mid = (r - l) / 2 + l;
            if (letters[mid] <= target) {
                l = mid+1;
            }else {
                r = mid;
            }
        }
        return r == letters.length ? letters[0] : letters[r];
    }

    public static void main(String[] args) {
        System.out.println(new Lc744().nextGreatestLetter(new char[]{
                'c', 'f', 'j'
        }, 'c'));
    }
}

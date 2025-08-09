package slidewindow;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025/7/25
 */
public class Lc345 {

    public String reverseVowels(String s) {
        int l = 0;
        int r = s.length() - 1;
        char[] ca = s.toCharArray();
        while (l < r) {
            if (!isVowels(s.charAt(l))) {
                l++;
                continue;
            }
            if (!isVowels(s.charAt(r))) {
                r--;
                continue;
            }
            swap(l,r,ca);
            l++;
            r--;
        }
        return ca.toString();
    }


    public boolean isVowels(Character c){
        return c=='a' || c=='e' || c=='i' || c=='o' ||c =='u'
                || c=='A' || c=='E' || c =='I' || c=='O' ||c =='U';
    }

    public void swap(int a ,int b ,char[] ca){
        char temp = ca[a];
        ca[a]= ca[b] ;
        ca[b] = temp;
    }


    public static void main(String[] args) {
        System.out.println(new Lc345().reverseVowels("IceCreAm"));
    }
}

package bit;


/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025-08-10 18:12:31
 */
public class Lc476 {

    public int findComplement(int num) {
        return (1 << (32 - Integer.numberOfLeadingZeros(num))) - 1 - num;
    }

    public static void main(String[] args) {
        Lc476 lc476 = new Lc476();
        System.out.println(lc476.findComplement(5));
    }

}

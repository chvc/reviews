package od;


import java.util.Scanner;

/**
 * #P00101—字符串加密
 *
 * @author chenghu
 * @since 2025-09-27 20:35:57
 */
public class Od88StringEncryption {

    /**
     * 给你一串未加密的字符串str，通过对字符串的每一个字母进行改变来实现加密，加密方式是在每一个字母str[i]偏移特定数组元素a[i]的量，数组a前三位已经赋值：a[0]=1,a[1]=2,a[2]=4。
     * <p>
     * 当i>=3时，数组元素a[i]=a[i-1]+a[i-2]+a[i-3]。
     * <p>
     * 例如：原文 abcde 加密后 bdgkr，其中偏移量分别是1,2,4,7,13。
     * <p>
     * 输入描述:
     * <p>
     * 第一行为一个整数n（1<=n<=1000），表示有n组测试数据，每组数据包含一行，原文str（只含有小写字母，0<长度<=50）。
     * <p>
     * 输出描述:
     * <p>
     * 每组测试数据输出一行，表示字符串的密文。
     * <p>
     * 示例1  输入输出示例仅供调试，后台判题数据一般不包含示例
     * <p>
     * 输入
     * <p>
     * 1
     * <p>
     * xy
     * <p>
     * 输出
     * <p>
     * ya
     * <p>
     * 说明
     * <p>
     * 第一个字符x偏移量是1，即为y，第二个字符y偏移量是2，即为a。
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[] nums = f();
        for (int i = 0; i < n; i++) {
            String str = sc.nextLine();
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < str.length(); j++) {
                char c = str.charAt(j);
                char x = (char) ('a' + (c - 'a' + nums[j]) % 26);
                sb.append(x);
            }
            System.out.println(sb.toString());
        }
    }

    public static int[] f() {
        int[] nums = new int[50];
        nums[0] = 1;
        nums[1] = 2;
        nums[2] = 4;
        for (int i = 3; i < nums.length; i++) {
            nums[i] = (nums[i - 2] % 26 + nums[i - 1] % 26 + nums[i - 3] % 26) % 26;
        }
        return nums;
    }

}

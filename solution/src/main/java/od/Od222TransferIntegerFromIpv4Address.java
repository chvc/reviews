package od;


import java.util.Scanner;

/**
 * P00333—IPv4地址转换成整数
 *
 * @author chenghu
 * @since 2025-08-25 20:51:38
 */
public class Od222TransferIntegerFromIpv4Address {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        if (s == null || s.isEmpty()) {
            System.out.println("invalid IP");
            return;
        }
        String[] split = s.split("#");

        // 要判断格式是否正确
        if (split.length != 4) {
            System.out.println("invalid IP");
            return;
        }
        String s1 = split[0];
        if (s1.charAt(0) == '0' && s1.length() > 1) {
            System.out.println("invalid IP");
            return;
        }
        String s2 = split[1];
        if (s2.charAt(0) == '0' && s2.length() > 1) {
            System.out.println("invalid IP");
            return;
        }
        String s3 = split[2];
        if (s3.charAt(0) == '0' && s3.length() > 1) {
            System.out.println("invalid IP");
            return;
        }
        String s4 = split[3];
        if (s4.charAt(0) == '0' && s4.length() > 1) {
            System.out.println("invalid IP");
            return;
        }
        int a1 = 0;
        int a2 = 0;
        int a3 = 0;
        int a4 = 0;
        try {
            a1 = Integer.parseInt(s1);
            a2 = Integer.parseInt(s2);
            a3 = Integer.parseInt(s3);
            a4 = Integer.parseInt(s4);
        } catch (NumberFormatException e) {
            System.out.println("invalid IP");
            return;
        }
        if (a1 < 1 || a1 > 128) {
            System.out.println("invalid IP");
            return;
        }
        if (a2 < 0 || a2 > 255) {
            System.out.println("invalid IP");
            return;
        }
        if (a3 < 0 || a3 > 255) {
            System.out.println("invalid IP");
            return;
        }
        if (a4 < 0 || a4 > 255) {
            System.out.println("invalid IP");
            return;
        }
        long ans = (long) (Math.pow(2, 0) * a4 + Math.pow(2, 8) * a3 + Math.pow(2, 16) * a2 + Math.pow(2, 24) * a1);
        System.out.println(ans);
    }


}

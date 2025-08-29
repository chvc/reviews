package od;


import java.util.Arrays;
import java.util.Scanner;

/**
 * P00407—5键键盘
 *
 * @author chenghu
 * @since 2025-08-28 20:22:38
 */
public class Od62FiveKeyBoard {


    /**
     * 有一个特殊的5键键盘，上面有a，ctrl-c， ctrl-x， ctrl-v， ctrl-a五个键。
     * a键在屏幕上输出一个字母a;
     * ctrl-c将当前选择的字母复制到剪贴板;
     * ctrl-x将当前选择的字母复制到剪贴板，并清空选择的字母;
     * ctrl-v将当前剪贴板里的字母输出到屏幕;
     * ctrl- a选择当前屏幕上的所有字母。
     * 注意：
     * 1、剪贴板初始为空，新的内容被复制到剪贴板时会覆盖原来的内容
     * 2、当屏幕上没有字母时，ctrl-a无效
     * 3、当没有选择字母时，ctrl-c和ctrl-x无效
     * 4、当有字母被选择时，a和ctrI-v这两个有输出功能的键会先清空选择的字母，再进行输出
     * 给定一系列键盘输入，输出最终屏幕上字母的数量。
     */

    static StringBuilder screen = new StringBuilder();

    static StringBuilder board = new StringBuilder();

    static StringBuilder sel = new StringBuilder();


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sel.setLength(0);
        board.setLength(0);
        screen.setLength(0);
        int[] nums = Arrays.stream(sc.nextLine().trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            // 输入a
            if (num == 1) {
                if (sel.length() == 0) {
                    screen.append('a');
                } else {
                    screen.setLength(0);
                    sel.setLength(0);
                    screen.append('a');
                }
            }
            // ctrl+c
            if (num == 2) {
                if (sel.length() != 0) {
                    board.setLength(0);
                    board.append(sel.toString());
                }
            }
            // ctrl+x
            if (num == 3) {
                if (sel.length() != 0) {
                    board.setLength(0);
                    board.append(sel.toString());
                    screen.setLength(0);
                    sel.setLength(0);
                }
            }
            // ctrl+v
            if (num == 4) {
                if (sel.length() == 0) {
                    String s = board.toString();
                    screen.append(s);
                } else {
                    screen.setLength(0);
                    sel.setLength(0);
                    screen.append(board.toString());
                }
            }
            // ctrl+a
            if (num == 5) {
                if (screen.length() > 0) {
                    sel.setLength(0);
                    sel.append(screen.toString());
                }
            }
        }
        System.out.println(screen.length());
    }

}

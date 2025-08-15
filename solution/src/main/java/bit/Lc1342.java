package bit;


/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025-08-10 17:58:41
 */
public class Lc1342 {

    public int numberOfSteps(int num) {
        int times = 0;
        while (num != 0) {
            if ((num & 1) == 0) {
                num = num >> 1;
            } else {
                num = num & (num - 1);
            }
            times++;
        }
        return times;
    }

}

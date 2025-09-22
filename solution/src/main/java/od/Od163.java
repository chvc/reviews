package od;


/**
 * #P00208—日志首次上报最多积分
 *
 * @author chenghu
 * @since 2025-09-11 23:28:24
 */
public class Od163 {

    public static void main(String[] args) {

    }

    public static int f(int[] nums) {
        int t = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum > 100) {
                sum = 100;
                t = i;
            }
            // 减去之前没有上报的
            int sub = 0;
            int j = i - 1;
            while (j>=0 ){
                
            }
        }
        return 0;
    }

}

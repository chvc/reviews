package bit;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025/7/31
 */
public class Lc287 {

    public int findDuplicate(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res = res ^ (nums[i] ^ (i + 1));
        }
        return res;
    }

    public static void main(String[] args) {
        
    }

}

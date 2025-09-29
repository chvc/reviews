package od;


import java.util.Arrays;
import java.util.Scanner;

/**
 * #P00122—太阳能板最大面积
 *
 * @author chenghu
 * @since 2025-09-27 23:34:21
 */
public class Od264MaxAreaSunEnergy {

    /**
     * 给航天器一侧加装长方形或正方形的太阳能板（图中的红色斜线区域），需要先安装两个支柱（图中的黑色竖条），再在支柱的中间部分固定太阳能板。
     * <p>
     * 但航天器不同位置的支柱长度不同，太阳能板的安装面积受限于最短一侧的那根支柱长度。
     * <p>
     * 现提供一组整形数组的支柱高度数据，假设每根支柱间距离相等为1个单位长度，计算如何选择两根支柱可以使太阳能板的面积最大。
     * <p>
     * 输入描述:
     * <p>
     * 10,9,8,7,6,5,4,3,2,1
     * <p>
     * 注：支柱至少有2根，最多10000根，能支持的高度范围1~10^9的整数。柱子的高度是无序的，例子中递减只是巧合。
     * <p>
     * 输出描述:
     * <p>
     * 可以支持的最大太阳能板面积：（10米高支柱和5米高支柱之间）
     * <p>
     * 25
     * <p>
     * 示例1   输入输出示例仅供调试，后台判题数据一般不包含示例
     * <p>
     * 输入
     * <p>
     * 10,9,8,7,6,5,4,3,2,1
     * <p>
     * 输出
     * <p>
     * 25
     * <p>
     * 备注:
     * <p>
     * 10米高支柱和5米高支柱之间宽度为5，高度取小的支柱高也是5，面积为25。
     * 任取其他两根支柱所能获得的面积都小于25。
     * 所以最大的太阳能板面积为25。
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nums = Arrays.stream(sc.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        System.out.println(f(nums));
    }

    public static long f(int[] nums) {
        long ans = 0;
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int hl = nums[l];
            int hr = nums[r];
            ans = Math.max(ans, (long) Math.abs(l - r) * Math.min(hl, hr));
            if (hl <= hr) {
                l++;
            } else {
                r--;
            }
        }
        return ans;
    }

}

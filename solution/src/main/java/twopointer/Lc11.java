package twopointer;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025/7/24
 */
public class Lc11 {
    public int maxArea(int[] height) {
        int l =0;
        int r = height.length-1;
        int max = 0;
       while (l<r){
           int i1 = height[l];
           int i2 = height[r];
           max = Math.max(max, (r-l) * Math.min(i1,i2));
           if (i1<i2){
               l++;
           }else {
               r++;
           }
       }
       return max;
    }



}

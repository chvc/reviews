package dp;


/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025-08-16 00:19:48
 */
public class Lc983 {
    int[] cost =new int[]{
            1,7,30
    };

    public int mincostTickets(int[] days, int[] costs) {
        // 代表着 可以往后越多少天
        int res = dfs(0, days, costs);
        return res;
    }


    // 第i天 前 3天 前1天 前30天
    public int dfs(int i ,int [] days,int[] costs){
        if (i==days.length){
            return 0;
        }

        int j = i;
        int ans =Integer.MAX_VALUE;
        for (int k = 0; k < cost.length; k++) {
            // 可以往后面越i天
            while (j<days.length && days[i]+cost[k]>days[j]){
                j++;
            }
            ans = Math.min(ans,costs[k]+dfs(j,days,costs));
        }
        return ans;
    }

    public static void main(String[] args) {
        Lc983 lc983 = new Lc983();
        System.out.println(lc983.mincostTickets(new int[]{
                1, 4, 6, 7, 8, 20
        }, new int[]{
                2, 7, 15
        }));
    }

}

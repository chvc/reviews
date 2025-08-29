package od;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * P00405-停车场车辆统计 / 最少停车数
 *
 * @author chenghu
 * @since 2025-08-28 21:48:07
 */
public class Od8SmallestParking {


    public static void main(String[] args) {
        // 找到连续的1
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] cars = s.split(",");
        int cnt = 0;
        List<Integer> car = new ArrayList<>();
        for (int i = 0; i < cars.length; i++) {
            if (cars[i].equals("0")) {
                if (cnt != 0) {
                    car.add(cnt);
                    cnt = 0;
                }
            } else {
                cnt++;
            }
        }
        if (cnt != 0) {
            car.add(cnt);
        }
        // 对car的每个元素都做 /3 /2 /1的操作
        int res = 0;
        for (int i = 0; i < car.size(); i++) {
            Integer x = car.get(i);
            int n = x / 3;
            res += n;
            x = x % 3;
            if (x != 0) {
                int m = x / 2;
                res += m;
                x = x % 2;
                if (x != 0) {
                    int z = x;
                    res += z;
                }
            }
        }
        System.out.println(res);
    }
}

//package listnode;
//
//import java.util.HashSet;
//import java.util.Set;
//
///**
// * 〈一句话功能简述〉
// *
// * @author chenghu
// * @since 2025/8/8
// */
//public class Lc457 {
//
//    Set<Integer> set = new HashSet<>();
//
//    public boolean circularArrayLoop(int[] nums) {
//        int n = 0;
//        while (true) {
//            n = f(nums, n);
//            if (set.contains(n)) {
//                return false;
//            }
//        }
//    }
//
//    public int f(int[] nums, int n) {
//        set.add(n);
//        if (n < 0) {
//            return nums[];
//        } else {
//            return (nums[n] + n) % nums.length;
//        }
//
//    }
//
//    public static void main(String[] args) {
//        Lc457 lc457 = new Lc457();
//        System.out.println(lc457.circularArrayLoop(new int[]{
//                -1, -2, -3, -4, -5, 6
//        }));
//    }
//
//}

package binarysearch;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Lc658 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i] - x;
        }
        // 对结果进行排序
        List<Integer> collected = Arrays.stream(res).boxed().sorted((o1, o2) -> {
            int abs1 = Math.abs(o1);
            int abs2 = Math.abs(o2);
            if (abs1 != abs2) {
                return abs1 - abs2;
            } else {
                return o1 - o2;
            }
        }).collect(Collectors.toList());
        List<Integer> integers = collected.subList(0, Math.min(k + 1, arr.length));
        return integers.stream().map(i -> i + x).sorted().collect(Collectors.toList());
    }

//    public int lower(int[] nums, int target) {
//        // 小于等于的第一个值 [l,r]
//        int l = 0;
//        int r = nums.length - 1;
//        while (l <= r) {
//            int mid = (r - l) / 2 + l;
//            if (nums[mid] <= target) {
//                l = mid + 1;
//            } else {
//                r = mid - 1;
//            }
//        }
//        return r;
//    }
//
//    public int upper(int[] nums, int target) {
//        // 大于等于的第一个值 [l,r)
//        int l = 0;
//        int r = nums.length;
//        while (l < r) {
//            int mid = (r - l) / 2 + l;
//            if (nums[mid] >= target) {
//                r = mid;
//            } else {
//                l = mid + 1;
//            }
//        }
//        return r;
//    }

    public static void main(String[] args) {
        System.out.println(new Lc658().findClosestElements(new int[]{
                1,1,1,10,10,10
        }, 1, 9));
    }

}
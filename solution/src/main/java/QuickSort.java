//import java.util.Stack;
//
//class QuickSort {
//
//    public static void main(String[] args) {
//        Integer[] arr = ArrayGenerator.generateRandomArray(100000, 100000);
//        SortingHelper.sortTest("QuickSort", arr);
//    }
//
//    public static <E extends Comparable<E>> void sort(E[] arr) {
//        // 快排
//        sort(arr, 0, arr.length - 1);
//    }
//
//    public static <E extends Comparable<E>> void sort(E[] arr, int l, int r) {
//        if (l >= r) {
//            return;
//        }
//        int p = partition(arr, l, r);
//        sort(arr, l, p - 1);
//        sort(arr, p + 1, r);
//    }
//
//    public static <E extends Comparable<E>> int partition(E[] arr, int l, int r) {
//        // l ...j j+1 ... i-1
//        int j = l;
//        E t = arr[l];
//        for (int i = l; i <= r; i++) {
//            if (arr[i].compareTo(t) < 0) {
//                j++;
//                swap(arr, i, j);
//            }
//        }
//        swap(arr, j, l);
//        return j;
//    }
//
//    private static <E extends Comparable<E>> void swap(E[] arr, int i, int j) {
//        E t = arr[i];
//        arr[i] = arr[j];
//        arr[j] = t;
//    }
//
//}
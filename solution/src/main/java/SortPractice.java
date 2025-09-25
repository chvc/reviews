import java.util.*;

public class SortPractice {

    // 冒泡排序
    public static void bubbleSort(int[] arr) {
        // TODO: 在这里实现冒泡排序
    }

    // 选择排序
    public static void selectionSort(int[] arr) {
        // TODO: 在这里实现选择排序
    }

    // 插入排序
    public static void insertionSort(int[] arr) {
        // TODO: 在这里实现插入排序
    }

    // 打印数组
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i != arr.length - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();       // 输入数组长度
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // 复制数组，分别测试三种排序
        int[] arr1 = Arrays.copyOf(arr, n);
        int[] arr2 = Arrays.copyOf(arr, n);
        int[] arr3 = Arrays.copyOf(arr, n);

        bubbleSort(arr1);
        System.out.print("冒泡排序结果: ");
        printArray(arr1);

        selectionSort(arr2);
        System.out.print("选择排序结果: ");
        printArray(arr2);

        insertionSort(arr3);
        System.out.print("插入排序结果: ");
        printArray(arr3);
    }
}

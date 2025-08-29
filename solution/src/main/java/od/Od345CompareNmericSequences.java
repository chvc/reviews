package od;


import java.io.IOException;
import java.util.Arrays;

/**
 * P00138—数字序列比大小
 *
 * @author chenghu
 * @since 2025-08-15 21:28:26
 */
public class Od345CompareNmericSequences {
    static int[] A;
    static int[] B;

    public static void main(String[] args) throws IOException {
        //todo 田忌赛马 需要重新实现
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        StreamTokenizer in = new StreamTokenizer(reader);
//        PrintWriter out = new PrintWriter(System.out);
//        while (in.nextToken() != StreamTokenizer.TT_EOF) {
//            int n = (int) in.nval;
//            A = new int[n];
//            B = new int[n];
//            for (int i = 0; i < n; i++) {
//                in.nextToken();
//                int num = (int) in.nval;
//                A[i] = num;
//            }
//            for (int i = 0; i < n; i++) {
//                in.nextToken();
//                int num = (int) in.nval;
//                B[i] = num;
//            }
//            // 比较
//            System.out.println(game(A, B));
//        }
        System.out.println(game(new int[]{
                4, 8, 10
        }, new int[]{
                3, 6, 4
        }));
    }

    public static int game(int[] arrA, int[] arrB) {
        Arrays.sort(arrA);
        Arrays.sort(arrB);
        // 尽量找稍大于该数的第一个数
        int l = 0;
        int count = 0;
        for (int i = 0; i < arrB.length; i++) {
            int index = search(arrA, arrB[i], l, arrA.length - 1);
            if (index == arrA.length) {
                count--;
            } else {
                if (arrA[index] > arrB[i]) {
                    count++;
                }
            }
            l = index + 1;
        }
        return count;
    }


    public static int search(int[] arrA, int target, int l, int r) {
        int ans = arrA.length;
        // [l,r]
        while (l <= r) {
            int m = (l + r) >> 1;
            if (arrA[m] >= target) {
                ans = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return ans;
    }


}

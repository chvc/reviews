package binarysearch;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025/7/26
 */
public class Lc374 {
    int pick;
    Lc374( int pick){
        this.pick = pick;
    }

    public int guessNumber(int n) {
        int left = 1;
        int right = n;
        while (left <= right) {
            int mid = (left + right) / 2;
            int res = guess(mid);
            if (res == 0) {
                return mid;
            } else if (res == -1) {
                right = mid-1 ;
            } else {
                left = mid +1;
            }
        }
        return 0;
    }

    private int guess(int mid) {
        if (mid==pick){
            return 0;
        }else if (mid<pick){
            return 1;
        }else {
            return -1;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Lc374(1702766719).guessNumber(2126753390));
    }


}

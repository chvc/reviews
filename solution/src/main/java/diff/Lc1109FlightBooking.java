package diff;


import java.util.Arrays;

/**
 * 航班预订统计
 *
 * @author chenghu
 * @since 2025-08-30 04:06:48
 */
public class Lc1109FlightBooking {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] diff = new int[n + 2];

        for (int i = 0; i < bookings.length; i++) {
            int[] booking = bookings[i];
            diff[booking[0]] += booking[2];
            diff[booking[1] + 1] -= booking[2];
        }
        for (int i = 1; i < diff.length; i++) {
            diff[i] += diff[i - 1];
        }
        return Arrays.copyOfRange(diff, 1, diff.length - 1);
    }

}

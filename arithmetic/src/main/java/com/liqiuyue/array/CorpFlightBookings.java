package com.liqiuyue.array;

/**
 * @ClassName: CorpFlightBookings
 * @Description: 航班预订统计
 * @Author: liqiuyue
 * @Date: 2021-08-31
 */
public class CorpFlightBookings {


    /**
     * https://leetcode-cn.com/problems/corporate-flight-bookings/
     */

    /**
     * 暴力破万象
     */
    public static int[] corpFlightBookings(int[][] bookings, int n) {
        int[] booking;
        int[] statBookings = new int[n];
        for (int[] ints : bookings) {
            booking = ints;
            for (int j = booking[0]; j <= booking[1]; j++) {
                statBookings[j-1] += booking[2];
            }
        }
        return statBookings;
    }

    /**
     * 差分 + 前缀和
     */
    public static int[] difference(int[][] bookings, int n) {
        int[] statBookings = new int[n];
        for (int[] booking : bookings) {
            statBookings[booking[0] - 1] += booking[2];
            if (booking[1] < n) {
                statBookings[booking[1]] -= booking[2];
            }
        }

        for (int i = 1; i < n; i++) {
            statBookings[i] += statBookings[i - 1];
        }
        return statBookings;
    }

    public static void main(String[] args) {
        int[][] bookings = new int[][]{{1,2,10},{2,3,10},{2,5,25}};
        int[] ints = corpFlightBookings(bookings, 5);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }


        ints = difference(bookings, 5);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }
}

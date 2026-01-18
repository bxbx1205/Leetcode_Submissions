package BinarySearch.Medium;

import java.util.*;

public class MinimumNumberofDaystoMakemBouquets {
    static void main(String[] args) {
        int[] arr = {1, 10, 3, 10, 2};
        int m = 3;
        int k = 1;
        System.out.println(minDays(arr, m, k));
    }

    static boolean possbile(int[] arr, int day, int m, int k) {
        int count = 0, bouquets = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= day) {
                count++;
            } else {
                bouquets = bouquets + count / k;
                count = 0;
            }
        }
        bouquets = bouquets + count / k;
        return bouquets >= m;
    }
    static public int minDays(int[] bloomDay, int m, int k) {
        long totalFlowers = (long) m * k;
        if (totalFlowers > bloomDay.length) return -1;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int x : bloomDay) {
            min = Math.min(x, min);
            max = Math.max(x, max);
        }
        int low = min;
        int high = max;
        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (possbile(bloomDay, mid, m, k)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}

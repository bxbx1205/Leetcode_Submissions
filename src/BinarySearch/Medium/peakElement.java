package BinarySearch.Medium;

public class peakElement {
    static void main(String[] args) {
        int[] nums = {1, 2, 1, 3, 5, 6, 4};
        System.out.println(findPeakElement(nums));
    }

    static public int findPeakElement(int[] nums) {
        int n = nums.length;
        if (nums[0] > nums[1]) {
            return 0;
        }
        if (nums[n - 1] > nums[n - 2]) {
            return n-1;
        }
        int left = 1;
        int right = n - 2;
        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                return mid;
            } else if (nums[mid] > nums[mid - 1]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static class CapacitytoShipPackagesWithinDDays {
        static void main(String[] args) {
            int[] weight = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
            int days = 5;
            System.out.println(shipWithinDays(weight, days));
        }

        static public int shipWithinDays(int[] weights, int days) {
            int low = 0, high = 0;
            for (int w : weights) {
                low = Math.max(low, w);
                high += w;
            }

            int ans = high;

            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (possible(weights, days, mid)) {
                    ans = mid;
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            return ans;
        }

        public static boolean possible(int[] weights, int days, int number) {
            int weight = number;
            int estiDate = 1;
            for (int i = 0; i < weights.length; i++) {
                if (weights[i] > weight) {
                    estiDate++;
                    weight = number;
                }

                weight = weight - weights[i];

            }

            return estiDate <= days;
        }
    }
}

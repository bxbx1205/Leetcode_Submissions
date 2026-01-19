package BinarySearch.Medium;

public class FindtheSmallestDivisorGivenaThreshold {
    static void main(String[] args) {
        int[] nums = {1, 2, 5, 9};
        int threshold = 6;
        System.out.println(smallestDivisor(nums, threshold));
    }


    public static int smallestDivisor(int[] nums, int threshold) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int x : nums) {
            min = Math.min(x, min);
            max = Math.max(x, max);
        }
        int ans = 0;
        int low = 1;
        int high = max;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (possible(nums, mid) <= threshold) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static int possible(int[] nums, int divide) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += (nums[i] + divide - 1) / divide;

        }
        return sum;
    }
}

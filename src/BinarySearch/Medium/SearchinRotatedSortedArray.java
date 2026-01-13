package BinarySearch.Medium;

import java.util.Arrays;

public class SearchinRotatedSortedArray {
    static void main(String[] args ) {
        int[] arr = {3, 1};
        System.out.println(search(arr, 1));
    }


    static public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = right - left / 2;
            if (nums[mid] == target) return mid;


            if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[mid] < target && nums[right] >= target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}

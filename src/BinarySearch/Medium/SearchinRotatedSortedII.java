package BinarySearch.Medium;

public class SearchinRotatedSortedII {
    static void main(String[] args) {
        int[] arr = {2, 5, 6, 0, 0, 1, 2};
        System.out.println(search(arr, 0));
    }


    static public boolean search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = right - left / 2;
            if (nums[mid] == target) return true;
            if ((nums[mid] == nums[left]) && (nums[mid] == nums[right])) {
                left++;
                right--;
                continue;
            }

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
        return false;
    }
}


package BinarySearch.Easy;

public class BS {
    static void main(String[] args) {
        int[] nums={1,3,5,6};
        System.out.println(searchInsert(nums,5));
    }
    static public int searchInsert(int[] nums, int target) {

        int low =0;
        int high= nums.length-1;
        while (low<=high){
            int mid = low+(high-low)/2;
            if (nums[mid]==target) return mid;
            if (nums[mid]<target){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return -1;

    }
}

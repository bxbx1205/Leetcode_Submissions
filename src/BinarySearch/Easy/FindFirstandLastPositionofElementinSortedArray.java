package BinarySearch.Easy;

import java.util.Arrays;

public class FindFirstandLastPositionofElementinSortedArray {
    static void main(String[] args) {
        int[] arr= {1};
        System.out.println(Arrays.toString(searchRange(arr,1)));
    }

    static public int[] searchRange(int[] arr, int x) {
        int[] ans = new int[2];
        ans[0] = BS(arr, x, true);
        ans[1] = BS(arr, x, false);

        return ans;
    }
    static int BS(int[] nums, int target,boolean findFirst){
        int start=0;
        int end=nums.length-1;
        int ans=-1;

        while (start<=end){
            int mid = start + (end - start) / 2;
            if (nums[mid]<target){
                start=mid+1;
            } else if (nums[mid]>target) {
                end=mid-1;
            }
            else {
                ans=mid;
                if (findFirst){
                    end=mid-1;
                }
                else {
                    start=mid+1;
                }
            }
        }
        return ans;
    }
}

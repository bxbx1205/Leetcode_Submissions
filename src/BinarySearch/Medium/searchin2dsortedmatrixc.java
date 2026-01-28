package BinarySearch.Medium;

import java.util.Arrays;

public class searchin2dsortedmatrixc {
    static void main(String[] args) {
        int[][] matrix={
                {1,3,5,7},
                {10,11,16,20},
                {23,30,34,60},
        };
        System.out.println(searchMatrix(matrix,3));
    }

    static public boolean searchMatrix(int[][] matrix, int target) {

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] <= target && target <= matrix[i][matrix[i].length - 1]){
                return findwithBinarySearch(matrix[i],target);
            }

        }
    return false;
    }

    static public boolean findwithBinarySearch(int[] arr , int target){
        int low=0;
        int high= arr.length-1;
        while (low<=high){
            int mid = low+(high-low)/2;
            if (arr[mid]==target) {
                return true;

            }
            else if (arr[mid]>target) {
                high=mid-1;
            }
            else {
                low=mid+1;
            }
        }
        return false;
    }
}

package Array.Medium;

import java.util.Arrays;

public class RemoveDuplicatesfromSortedArrayII {
    static void main(String[] args) {
        int[] arr={1,1,1,2,2,3};
        System.out.println(removeDuplicates(arr));
    }

    static public int removeDuplicates(int[] nums) {
        int k =1;
        int counter=1;

        for (int i = 1; i < nums.length ; i++) {

            if (nums[i]==nums[i-1]){
                counter++;
            }
            else counter=1;

            if (counter<=2){
                nums[k]=nums[i];
                k++;
            }
        }
        System.out.println(Arrays.toString(nums));
        return k;
    }
}

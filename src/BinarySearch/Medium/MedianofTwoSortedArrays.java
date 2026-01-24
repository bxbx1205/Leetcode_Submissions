package BinarySearch.Medium;

import java.util.Arrays;

public class MedianofTwoSortedArrays {
    static void main(String[] args) {
        int[] nums1={1,3};
        int[] nums2={2};

        System.out.println(findMedianSortedArrays(nums1,nums2));
    }

    static public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int[] merged = new int[nums1.length + nums2.length];
        int i = 0, j = 0, m = 0;

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] > nums2[j]) {
                merged[m++] = nums2[j++];
            } else {
                merged[m++] = nums1[i++];
            }
        }

        while (i < nums1.length) {
            merged[m++] = nums1[i++];
        }

        while (j < nums2.length) {
            merged[m++] = nums2[j++];
        }
        if (merged.length%2==0){
            return (double) (merged[merged.length / 2 - 1] + (double)merged[merged.length / 2]) /2;

        }
        return (double) merged[merged.length/2];
    }

}

package BinarySearch.Easy;

public class Numberofoccurrence {
    static void main(String[] args) {
        int[] arr = {8, 9, 10, 12, 12, 12};
        System.out.println(countFreq(arr, 12));
    }

    static int countFreq(int[] arr, int target) {
        int left = 0;
        int ansL=-1;
        int ansR=-1;
        int right = arr.length-1;

        while (left <= right) {
            int mid = left+(right-left) / 2;
            if (arr[mid]==target){
                ansL=mid;
                right=mid-1 ;
            }
            else if (arr[mid] < target) {
                left=mid+1 ;
            } else {
                right=mid-1;
            }
        }
        int firstOccur=ansL;

         left = 0;
         right = arr.length-1;

        while (left <= right) {
            int mid = left+(right-left) / 2;
            if (arr[mid]==target){
                ansR=mid;
                left=mid+1 ;
            }
            else if (arr[mid] > target) {
                right=mid-1 ;
            } else {
                left=mid+1;
            }
        }

        int lastOccur=ansR;

        if (ansR ==-1 || ansL == -1) return 0;
        return (lastOccur - firstOccur + 1);
    }
}


package BinarySearch.Easy;

public class FloorSortedArray {
    static void main(String[] args) {
        int[] arr={1, 2, 8, 10, 10, 12, 19};
        System.out.println(findFloor(arr,5));
    }

    static  public int findFloor(int[] arr, int x) {
        int left=0;
        int right= arr.length-1;
        int ans=-1;
        while (left<=right){
            int mid = (left + right) / 2;
            if (arr[mid]>x){
                ans=mid;
                right=mid-1;
            }
            else{
                left=mid+1;
            }

        }
//        if (ans==arr.length-1) return -1;
        return left-1;
    }
}

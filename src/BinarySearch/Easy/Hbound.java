package BinarySearch.Easy;

public class Hbound {
    static void main(String[] args) {
        int[] arr ={2, 3, 7, 10, 11, 11, 25};
        System.out.println(upperBound(arr,9));


    }
    static int upperBound(int[] arr, int x) {
        int n = arr.length;
        int low = 0, high = n - 1;
        int ans = n;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (x < arr[mid]) {
                ans = mid;
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return low;
    }
}

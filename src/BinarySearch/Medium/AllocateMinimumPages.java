package BinarySearch.Medium;

public class AllocateMinimumPages {
    static void main(String[] args) {
        int[] arr = {12, 34, 67, 90};
        int k = 2;
        System.out.println(findPages(arr, k));
    }

    public static int findPages(int[] arr, int student) {
        if (student > arr.length) return -1;
        int low = 0;
        int high = 0;
        for (int x : arr) {
            high += x;
            low = Math.max(x, low);
        }

//        for (int i = max; i <= sum; i++) {
//            if (func(arr, i, student)) {
//                return i;
//            }
//        }
        int ans = 0;
//        int low=max;
//        int high=sum;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (func(arr, mid, student)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    public static boolean func(int[] arr, int page, int students) {
        int cntStudent = 1;
        int pagesStudent = 0;

        for (int i = 0; i < arr.length; i++) {
            if (pagesStudent + arr[i] <= page) {
                pagesStudent += arr[i];
            } else {
                cntStudent++;
                pagesStudent = arr[i];
            }
        }
        return cntStudent <= students;
    }
}

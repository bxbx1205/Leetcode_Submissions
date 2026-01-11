package Array.Hard;

public class CountInversions {
    public static void main(String[] args) {
        int[] arr ={2, 4, 1, 3, 5};
        System.out.println(inversionCount(arr));

        // o(n^2)
    }
    public static int inversionCount(int[] arr) {
        int count=0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length ; j++) {
                if (i<j && arr[i]>arr[j]) count++;
            }
        }
        return count;
    }
}

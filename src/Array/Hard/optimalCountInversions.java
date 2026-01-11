package Array.Hard;

public class optimalCountInversions {
    public static void main(String[] args) {
        int[] arr={1,421, 5132,1,2,1242,14,321};
        System.out.println(inversionCount(arr));
    }
    static int inversionCount(int[] arr) {
        int count=0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length ; j++) {
                if (i<j && arr[i]>arr[j]) count++;
            }
        }
        return count;
    }
}

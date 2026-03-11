package Array.Easy;

public class MaxElement {
    static void main(String[] args) {
        int[] arr = {3,4,9,6,7,8};
        System.out.println(maxELE(arr));
    }

    static public int maxELE(int[] nums){
        int max= Integer.MIN_VALUE;

        for (int numsa :nums){
            max=Math.max(numsa,max);
        }


        return max;
    }
}

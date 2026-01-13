package Array.Easy;

import java.util.HashMap;

public class frequency {
    static void main(String[] args) {
int[] arr ={1, 1, 2, 2, 2, 2, 3};
        System.out.println(countFreq(arr,4));
    }

    static int countFreq(int[] arr, int target) {
        int count=0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]==target) count++;
        }

        return count;
    }
}

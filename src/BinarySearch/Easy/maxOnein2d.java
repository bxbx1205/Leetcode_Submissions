package BinarySearch.Easy;

import java.util.Arrays;

public class maxOnein2d {
    static void main(String[] args) {
        int[][] mat = {
                {0,1},
                {1, 0},

        };

        System.out.println(Arrays.toString(rowAndMaximumOnes(mat)));
    }

    static public int[] rowAndMaximumOnes(int[][] mat) {

        int rowIndex = Integer.MIN_VALUE;
        int maxOnes = Integer.MIN_VALUE;

        for (int i = 0; i < mat.length; i++) {
            int firstOneIndex = getOne(mat[i]);

            int countOnes = (firstOneIndex == -1) ? 0 : mat[i].length - firstOneIndex;

            if (countOnes > maxOnes) {
                maxOnes = countOnes;
                rowIndex = i;
            }
        }


        return new int[]{rowIndex, maxOnes};
    }

    static int getOne(int[] arr) {
        int ans = -1;
        int low = 0;
        int high = arr.length-1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == 1) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }


        return ans;
    }
}

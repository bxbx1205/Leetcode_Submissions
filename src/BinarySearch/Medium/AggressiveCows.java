package BinarySearch.Medium;

import java.util.Arrays;
import java.util.Collections;

public class AggressiveCows {
    static void main(String[] args) {
        int[] stalls={1, 2, 4, 8, 9};
        int k =3;

        System.out.println(aggressiveCows(stalls,k));
    }

    static public int aggressiveCows(int[] stalls, int k) {
        Arrays.sort(stalls);


//        for (int i = 1; i < stalls[stalls.length-1]-stalls[0]; i++) {
//            if (isPossible(stalls,i,k)){
//                continue;
//            }
//            else return (i-1);
//        }
        int left =1;
        int right=stalls[stalls.length-1]-stalls[0];
        int ans=0;
        while (left<=right){
            int mid = left+(right-left)/2;
            if (isPossible(stalls,mid,k)){
                ans=mid;
                left=mid+1;
            }
            else {
                right=mid-1;
            }

        }

        return ans;
    }

    static public boolean isPossible(int[] arr, int dist, int cows){
        int cntcows=1;
        int last=arr[0];
        for (int i =1; i < arr.length ; i++) {
            if (arr[i]-last>=dist){
                cntcows++;
                last=arr[i];
                if (cntcows>=cows) return true;
            }

        }
        return false;
    }
}

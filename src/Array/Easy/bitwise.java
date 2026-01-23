//package Array.Easy;
//
//import java.util.*;
//
//public class bitwise {
//    static void main(String[] args) {
//        int[] arr = {2, 3, 5, 7};
//
//
//        System.out.println(Arrays.toString(minBitwiseArray(arr)));
//    }
//
//    static public int[] minBitwiseArray(List<Integer> list) {
//        int[] nums = new int[list.size()];
//        for (int i = 0; i < list.size(); i++) {
//            nums[i] = list.get(i);
//        }
//
//
//        int n = nums.length;
//        int[] ans = new int[n];
//
//        for (int i = 0; i < n; i++) {
//            int current = nums[i];
//            for (int j = 0; j <= current+1; j++) {
//                if (j==current+1) ans[i]=-1;
//                if ((j | j + 1) == current) {
//                    ans[i] = j;
//                    break;
//                }
//
//            }
//        }
//        return ans;
//    }
//
//
//}
//
//

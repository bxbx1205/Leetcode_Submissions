package Array.Hard;

import java.util.HashMap;

public class CountnumberofsubarrayswithgivenxorK {
    public static void main(String[] args) {
        int[] nums ={5, 6, 7, 8, 9};
        System.out.println(subarraysWithXorK(nums, 5));
    }

    static public int subarraysWithXorK(int[] nums, int k) {
        int count=0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int xor=0;
        for (int i = 0; i < nums.length; i++) {
            xor^=nums[i];
            if (map.containsKey(xor^k)){
                count+=map.getOrDefault(xor^k,0);
            }
                map.put(xor,map.getOrDefault(xor,0)+1);
        }
        return count;
    }
}

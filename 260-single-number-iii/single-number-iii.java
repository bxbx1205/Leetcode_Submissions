class Solution {
    public int[] singleNumber(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int[] ans= new int[2];

        for(int num:nums){
            if(map.containsKey(num)){
                map.put(num,map.get(num)+1);
            }
            else {
               map.put(num,1); 
            }
        }

        int i =0;

     for(int num:map.keySet()){
            if (map.get(num)==1) {
                ans[i++]=num;
                
            }
            if (i==2) break;
    }

    return ans;
    }
}
class Solution {
    public int helper(int[] nums,int k){
         int total=0;
        int right=0;
        int left=0;
        int n= nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();

        while(right<n){
            map.put(nums[right],map.getOrDefault(nums[right],0)+1);

            while(map.size()>k){
                map.put(nums[left],map.getOrDefault(nums[left],1)-1);

                if(map.get(nums[left])<=0){
                    map.remove(nums[left]);

                }
                left++;
            }
            total+=right-left+1;
            right++;
        }
        return total;
    }
    public int subarraysWithKDistinct(int[] nums, int k) {
       return helper(nums,k)-helper(nums,k-1);
    }
}
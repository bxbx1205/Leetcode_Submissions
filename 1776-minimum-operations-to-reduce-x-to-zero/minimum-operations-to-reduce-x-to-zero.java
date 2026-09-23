class Solution {
    public int minOperations(int[] nums, int x) {
        int sum=0;
        
        int n = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);

        for(int i=0;i<n;i++){

            sum+=nums[i];
            map.put(sum,i);
        }

        if(sum<x) return -1;
        int target = sum-x;
        int ans=Integer.MIN_VALUE;
        sum=0;
        for(int i=0;i<n;i++){
            sum+=nums[i];

            int findSum = sum-target;
            
            if(map.containsKey(findSum)){
                int index= map.get(findSum);

                ans = Math.max(i-index,ans);
            }
        }
        return ans == Integer.MIN_VALUE ? -1 : n - ans;
    }
}
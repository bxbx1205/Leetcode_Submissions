class Solution {
    public long[] findPrefixScore(int[] nums) {
        int n = nums.length;
        long[] ans = new long[n];

        long prefix =0;

        int max=Integer.MIN_VALUE;

        for(int i=0;i<n;i++){
            max = Math.max(max,nums[i]);
            ans[i]=nums[i]+max;
            prefix+=ans[i];
            ans[i]=prefix;
        }

        // for(int i=0;i<n;i++){
            
        // }
        return ans;
    }
}
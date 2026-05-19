class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int ans=0;
        int conseq=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){
                conseq++;
                ans=Math.max(conseq,ans);
            }
            else {
                conseq=0;
            }
        }
        return ans;
    }
}
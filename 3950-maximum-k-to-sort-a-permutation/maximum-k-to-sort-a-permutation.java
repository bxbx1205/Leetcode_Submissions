class Solution {
    public boolean isSorted(int[] nums){
        int n = nums.length;
        int prev = nums[0];

        for(int i=1;i<n;i++){
            if(nums[i]<prev){
                return false;
            }
            prev=nums[i];
        }

        return true;
    }
    public int sortPermutation(int[] nums) {
        if(isSorted(nums)) return 0;
        int n = nums.length;
        int cnt=Integer.MAX_VALUE;
        
        for(int i=0;i<n;i++){
            if(nums[i]!=i){
                cnt=cnt&i;
            }
        }

        return cnt;
    }
}
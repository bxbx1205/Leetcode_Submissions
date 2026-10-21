class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if(nums.length==3){
            return nums[0]+nums[1]+nums[2];
        }
        
        Arrays.sort(nums);
        int n = nums.length;
        int ans = Integer.MAX_VALUE;

        for(int k=0;k<n-2;k++){
            int i=k+1;
            int j =n-1;

            while(i<j){
                int sum = nums[i]+nums[j]+nums[k];
                if(Math.abs(target-sum)<Math.abs(target-ans)){
                    ans=sum;
                }
                if(sum<target){
                    i++;
                }
                else{
                    j--;
                }
            }
        }
        return ans;

    }
}
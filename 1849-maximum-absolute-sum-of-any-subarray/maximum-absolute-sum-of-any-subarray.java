class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int n = nums.length;
        int maxS =0;
        int minS = 0;

        int sum=0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
            if(sum<0) sum=0;

            maxS=Math.max(maxS,sum);
        }   

        sum=0;

        for(int i=0;i<n;i++){
            sum+=nums[i];

            if(sum>0) sum=0;

            minS=Math.min(minS,sum); 
        }

        return Math.max(maxS,Math.abs(minS));
    }
}
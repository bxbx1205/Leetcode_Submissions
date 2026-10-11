class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n= nums.length;
        int minLength=Integer.MAX_VALUE;
        int i=0;
        int j=0;
        int sum=0;

        while(j<n){
           sum+=nums[j];
           j++;

           while(sum>=target){
                int length=j-i;

                minLength=Math.min(minLength,length);
                sum-=nums[i];
                i++;
           }
        }
        return (minLength==Integer.MAX_VALUE)?0:minLength;
    }
}
class Solution {
    static int helper(int num){
        int sum=0;

        while(num!=0){
            sum=sum+num%10;
            num=num/10;
        }
        return sum;
    }

    public int minElement(int[] nums) {
        int n =nums.length;
        int min=Integer.MAX_VALUE;

        for(int i =0;i<n;i++){
            nums[i]=helper(nums[i]);
            min=Math.min(min,nums[i]);
        }

        return min;
    }
}
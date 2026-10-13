class Solution {
    public long maxAlternatingSum(int[] nums) {
        long sum =0;
        int n = nums.length;
        // int[] sortedArray = new int[n];

        for(int i=0;i<n;i++){
            nums[i]=Math.abs(nums[i]);
        }

        Arrays.sort(nums);
        int left=0;
        int right=n-1;

        while(left<right){

            long curr = (nums[right]*nums[right])-(nums[left]*nums[left]);
            sum+=curr;
            left++;
            right--;
        }

        if(left==right){
            sum+=nums[right]*nums[right];
        }
        
        return sum;
    }
}
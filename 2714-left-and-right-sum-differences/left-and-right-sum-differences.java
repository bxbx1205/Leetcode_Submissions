class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;
        int[] leftSum = new int[n];
        int[] rightSum = new int[n];

        int tempSum = 0;
        leftSum[0] = 0;

        for (int i = 1; i < n; i++) {
            leftSum[i] = tempSum + nums[i - 1];
            tempSum = leftSum[i];
        }

        tempSum = 0;
        rightSum[n - 1] = 0;

        for (int i = n - 2; i >= 0; i--) {
            tempSum += nums[i + 1];
            rightSum[i] = tempSum;
        }

        for(int i =0;i<n;i++){
            nums[i]=Math.abs(leftSum[i]-rightSum[i]);
        }


        return nums;
    }
}
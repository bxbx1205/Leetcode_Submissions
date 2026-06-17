class Solution {
    public int minimumDifference(int[] nums, int k) {
        if(k<=1) return 0;

        int ans = Integer.MAX_VALUE;
        Arrays.sort(nums);

        int left=0;
        int right = k-1;

        while(right<nums.length){
            int current = nums[right]-nums[left];
            ans=Math.min(ans,current);
            left++;
            right++;
        }
    return ans;
    }
}
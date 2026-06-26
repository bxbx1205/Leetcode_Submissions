class Solution {
    public int goal(int[] nums, int goal){
        if(goal<0) return 0;
        int left=0;
        int right=0;
        int n = nums.length;
        int sum=0;
        int cnt=0;

        while(right<nums.length){
            sum+=nums[right];

            while(sum>goal){
                sum-=nums[left];
                left++;
            }
            cnt=cnt+(right-left+1);
            right++;
        }

        return cnt;
    }

    public int goalm1(int[] nums, int goal){
        if(goal<0) return 0;
        int left=0;
        int right=0;
        int n = nums.length;
        int sum=0;
        int cnt=0;

        while(right<nums.length){
            sum+=nums[right];

            while(sum>goal){
                sum-=nums[left];
                left++;
            }
            cnt=cnt+(right-left+1);
            right++;
        }

        return cnt;
    }


    public int numSubarraysWithSum(int[] nums, int goal) {
        return goal(nums,goal)-goalm1(nums,goal-1);
    }
}
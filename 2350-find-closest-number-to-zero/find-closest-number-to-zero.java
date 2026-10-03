class Solution {
    public int findClosestNumber(int[] nums) {
        int ans = nums[0]; 
        
        for (int i = 1; i < nums.length; i++) {
            int current = nums[i];
            
            if (Math.abs(current) < Math.abs(ans)) {
                ans = current;
            } 
            else if (Math.abs(current) == Math.abs(ans)) {
                ans = Math.max(ans, current);
            }
        }
        
        return ans;
    }
}

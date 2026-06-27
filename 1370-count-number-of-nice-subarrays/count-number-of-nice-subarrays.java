class Solution {
    public int goal(int[] nums, int goal) {
        if (goal < 0)
            return 0;
        int left = 0;
        int right = 0;
        int cnt = 0;
        int n = nums.length;
        int sum = 0;

        while (right < n) {
            sum += nums[right];

            while (sum > goal) {
                sum -= nums[left++];
            }

            cnt = cnt + (right - left + 1);
            right++;
        }
        return cnt;
    }

    public int numberOfSubarrays(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = (nums[i] % 2 == 0) ? 0 : 1;
        }

        return goal(nums, k) - goal(nums, k - 1);
    }
}
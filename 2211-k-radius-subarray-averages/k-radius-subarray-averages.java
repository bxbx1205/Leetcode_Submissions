class Solution {
    public int[] getAverages(int[] nums, int k) {

        int n = nums.length;
        int[] ans = new int[n];

        Arrays.fill(ans, -1);

        int j = 0;
        long sum = 0;

        while (j < n && j < 2 * k + 1) {
            sum += nums[j++];
        }

        if (j < 2 * k + 1) {
            return ans;
        }

        ans[k] = (int)(sum / (2 * k + 1));

        int i = 0;

        while (j < n) {
            sum += nums[j];
            sum -= nums[i];

            ans[j - k] = (int)(sum / (2 * k + 1));

            j++;
            i++;
        }

        return ans;
    }
}
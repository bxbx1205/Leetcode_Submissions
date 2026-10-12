class Solution {
    public long[] distance(int[] nums) {
        int n = nums.length;
        long[] ans = new long[n];

        HashMap<Integer, Long> sum = new HashMap<>();
        HashMap<Integer, Integer> freq = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int current = nums[i];

            ans[i] = (long)freq.getOrDefault(current,0) * i - sum.getOrDefault(current,0L);
            freq.put(current, freq.getOrDefault(current, 0) + 1);
            sum.put(current, sum.getOrDefault(current, 0L) + i);

        }

        sum.clear();
        freq.clear();

        for (int i = n - 1; i >= 0; i--) {
            int current = nums[i];

            ans[i] +=  sum.getOrDefault(current,0L) - (long)freq.getOrDefault(current,0) * i;
            freq.put(current, freq.getOrDefault(current, 0) + 1);
            sum.put(current, sum.getOrDefault(current, 0L) + i);
        }

        return ans;
    }
}
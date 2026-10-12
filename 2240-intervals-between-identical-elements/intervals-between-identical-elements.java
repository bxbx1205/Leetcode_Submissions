class Solution {
    public long[] getDistances(int[] arr) {
        int n = arr.length;
        long[] ans = new long[n];

        HashMap<Integer, Integer> freq = new HashMap<>();
        HashMap<Integer, Long> sum = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int current = arr[i];

            ans[i] = (long) freq.getOrDefault(current, 0) * i - (long) sum.getOrDefault(current, 0L);

            freq.put(current, freq.getOrDefault(current, 0) + 1);
            sum.put(current, sum.getOrDefault(current, 0L) + i);

        }

        freq.clear();
        sum.clear();

        for (int i = n - 1; i >= 0; i--) {
            int current = arr[i];
            ans[i] += (long) sum.getOrDefault(current, 0L) - (long) freq.getOrDefault(current, 0) * i;

            freq.put(current, freq.getOrDefault(current, 0) + 1);
            sum.put(current, sum.getOrDefault(current, 0L) + i);
        }

        return ans;
    }
}
class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        long ans = 0;
        int n = nums1.length;
        // PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int[] arr = new int[100001];
        Arrays.fill(arr, 0);

        for (int i = 0; i < n; i++) {
            int n1 = nums1[i];
            int n2 = nums2[i];
            int diff = Math.abs(n1 - n2);

            arr[diff]++;
        }

        int k = k1 + k2;
        int index = 100000;

        while (k > 0 && index >0) {
            if (arr[index] == 0) {
                index--;
                continue;
            }

            int count = Math.min(k, arr[index]);

            arr[index] -= count;
            arr[index - 1] += count;

            k -= count;

        }

        for (int i = 1; i < arr.length; i++) {
            ans += (long) i * i * arr[i];
        }

        return ans;
    }
}
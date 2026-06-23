class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] ans = new int[k];
       PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        Arrays.sort(nums);

        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                count++; 
            } else {
                maxHeap.add(new int[]{nums[i - 1], count}); 
                count = 1; 
            }
        }
        maxHeap.add(new int[]{nums[nums.length - 1], count});


        int index=0;
        while (k > 0 && !maxHeap.isEmpty()) {
            ans[index++] = maxHeap.poll()[0]; 
            k--; 
        }

        return ans;

    }
}
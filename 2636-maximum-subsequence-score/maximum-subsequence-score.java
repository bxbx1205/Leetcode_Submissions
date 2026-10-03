class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;

        int[][] nums = new int[n][2];

        for(int i=0;i<n;i++){
            nums[i][0]=nums1[i];
            nums[i][1]=nums2[i];
        }

        Arrays.sort(nums,(a,b)->b[1]-a[1]);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        long sum=0;
        long ans=0;
        for(int i=0;i<n;i++){
            int first = nums[i][0];
            int second = nums[i][1];

            sum+=first;

            pq.offer(first);

            if(pq.size()>k) sum-=pq.poll();

            if(pq.size()==k){
                long curr =sum*second;

                ans = Math.max(ans,curr); 
            }
        }
        return ans;
    }
}
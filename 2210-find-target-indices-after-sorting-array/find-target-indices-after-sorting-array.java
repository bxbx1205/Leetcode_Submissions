class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int num:nums){
            pq.offer(num);
        }

        int index=0;

        while(!pq.isEmpty()){
            int curr = pq.poll();
            if(curr==target){
                ans.add(index);
            }
            index++;
        }

        return ans;
    }
}
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int n =nums.length;
        int subset = 1<<n;
        List<List<Integer>> ans = new ArrayList<>();

        for(int number=0;number<subset;number++){
            List<Integer> ds= new ArrayList<>();
            for(int i =0;i<n;i++){
                if((number&(1<<i))!=0){
                    ds.add(nums[i]);
                }
            }
            ans.add(ds);
        }

        return ans;
    }
}
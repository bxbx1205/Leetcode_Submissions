class Solution {

    static void subset(int index,List<List<Integer>> ans, List<Integer> ds,int[] nums){

        if(index==nums.length){
            ans.add(new ArrayList<>(ds));
            return;
        }

        ds.add(nums[index]);
        subset(index+1,ans,ds,nums);
        ds.remove(ds.size()-1);
        subset(index+1,ans,ds,nums);
    }

    public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> ans = new ArrayList<>();

    subset(0,ans,new ArrayList<Integer>(),nums);

    return ans;    
    }
}
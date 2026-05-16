class Solution {

    static void subset(int index,List<List<Integer>> ans, List<Integer> ds,int[] nums){

        if(index==nums.length){
            ans.add(new ArrayList<>(ds));
            return;
        }

        ds.add(nums[index]);
        subset(index+1,ans,ds,nums);
        ds.remove(ds.size()-1);
        while (index + 1 < nums.length && nums[index] == nums[index + 1]) {
            index++;
        }
        subset(index+1,ans,ds,nums);
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
    List<List<Integer>> ans = new ArrayList<>();
     Arrays.sort(nums);

    subset(0,ans,new ArrayList<Integer>(),nums);

    return ans;    
    }
}
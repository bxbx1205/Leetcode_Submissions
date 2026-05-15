class Solution {

    private void recurse(int[] nums,List<List<Integer>> ans,List<Integer> ds, HashMap<Integer,Integer> map){  

 if (ds.size() == nums.length) {
            ans.add(new ArrayList<>(ds));
            return;
        }
        for(int i =0;i<nums.length;i++){
            if(!(map.containsKey((i)))){
                ds.add(nums[i]);
                map.put(i,1);
                 recurse(nums, ans, ds, map);
                ds.remove(ds.size() - 1);
                map.remove(i);
            }
        }
    }



    public List<List<Integer>> permute(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> ds = new ArrayList<>();

        recurse(nums,ans,ds,map);

        return ans;
    }
}
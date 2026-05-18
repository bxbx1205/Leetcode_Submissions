class Solution {


    static void recurse(HashMap<Integer,Integer> map, List<List<Integer>> ans,List<Integer> ds,int[] nums){
        if(ds.size()==nums.length){
            ans.add(new ArrayList<>(ds));
            return;
        }


        for(int num:map.keySet()){

             int count = map.get(num);

             if (count>0){
           
            ds.add(num);
            map.put(num, map.get(num) - 1);
            recurse(map,ans,ds,nums);


            map.put(num,count);
            ds.remove(ds.size()-1);
             }
           
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();

        recurse(map,ans,ds,nums);

        return ans;
}
}
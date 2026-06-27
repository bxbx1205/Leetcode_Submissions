class Solution {
    public List<Integer> findLonely(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<Integer,Integer> set = new HashMap<>();

        for(int num:nums){
            set.put(num,set.getOrDefault(num,0)+1);
        }

        for(int num:nums){
            if(set.containsKey(num-1)|| set.containsKey(num+1)|| set.get(num)>=2 ){
                continue;
            }
            else{
                list.add(num);
            }
        }
        return list;
    }
}
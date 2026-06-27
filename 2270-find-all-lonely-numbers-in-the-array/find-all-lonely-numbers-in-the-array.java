class Solution {
    public List<Integer> findLonely(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;

        for(int i=0;i<n;i++){
            if((i>0 && nums[i]==nums[i-1]) ||
               (i<n-1 && nums[i]==nums[i+1])
            ){
                continue;
            }

            if((i>0 && nums[i]==nums[i-1]+1) ||
               (i<n-1 && nums[i]==nums[i+1]-1)
            ){
                continue;
            }

            list.add(nums[i]);
        }
        return list;
    }
}
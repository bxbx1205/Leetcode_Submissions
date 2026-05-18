class Solution {

    static void swap(int i, int j, int[] nums){
        int temp =nums[i];
        nums[i]=nums[j];
        nums[j]=temp;

        return;
    }


    static void recurse(int index,List<List<Integer>> ans,int[] nums){
        if(index==nums.length){

            List<Integer> ds = new ArrayList<>();
            for(int i=0;i<nums.length;i++){
                ds.add(nums[i]);
            }

            ans.add(ds);
            return;
        }

        

        for(int i =index;i<nums.length;i++){
            swap(i,index,nums);
            recurse(index+1,ans,nums);
            swap(i,index,nums);
        }
    }
    public List<List<Integer>> permute(int[] nums) {


        List<List<Integer>> ans = new ArrayList<>();

        recurse(0,ans,nums);

        return ans;
    }
}
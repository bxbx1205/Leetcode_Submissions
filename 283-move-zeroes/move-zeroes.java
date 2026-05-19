class Solution {
    static void swap(int i,int j,int[] nums){
        int temp =nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
        return;
    }
    public void moveZeroes(int[] nums) {
        int j=0;
        int i=0;
        while(j<nums.length){
            if(nums[j]!=0){
                swap(i,j,nums);
                i++;
                
            }
            j++;
        }
        return;
    }
}
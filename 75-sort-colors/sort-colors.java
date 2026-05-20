class Solution {
    static void swap(int i, int j, int[] nums){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;

        return; 
    }
    public void sortColors(int[] nums) {
        int low=0;
        int mid=0;
        int high=nums.length-1;

        while(mid<=high){

            if(nums[mid]==1){  
                mid++;
            }
            else if(nums[mid]==0){
                swap(low++,mid++,nums);
            }
            else{
                swap(mid,high--,nums);
            }
        }
        return;
    }
}
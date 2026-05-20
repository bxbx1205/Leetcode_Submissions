class Solution {
    public void sortColors(int[] nums) {
        int zerocnt=0;
        int onecnt=0;
        int twocnt=0;

        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                zerocnt++;
            }
            else if (nums[i]==1){
                onecnt++; 
            }
            else{
                twocnt++;
            }
        }

        int i=0;
        while(zerocnt>0){
            nums[i]=0;
            i+=1;
            zerocnt--;
        }
         while(onecnt>0){
            nums[i]=1;
            i+=1;
            onecnt--;
        }
         while(twocnt>0){
            nums[i]=2;
            i+=1;
            twocnt--;
        }

        return;
    }
}
class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        int hPivot=0;
        int[] ans = new int[n];

        int index=0;
        for(int num: nums){
            if(num<pivot){
                ans[index++]=num;
            }
            else if(num==pivot){
                hPivot++;
            }
        }

        while(hPivot!=0){
            ans[index++]=pivot;
            hPivot--;
        }

         for(int num: nums){
            if(num>pivot){
                ans[index++]=num;
            }
         }

    return ans;
    }
}
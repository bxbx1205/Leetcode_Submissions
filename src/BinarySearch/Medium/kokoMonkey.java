package BinarySearch.Medium;

public class kokoMonkey {
    static void main(String[] args) {
        int [] arr={3,6,7,11};
        System.out.println(minEatingSpeed(arr,8));


    }
    static public int minEatingSpeed(int[] arr, int h) {
        int max= Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max=Math.max(max,arr[i]);
        }
        int left=1;
        int right=max;
        int ans=max;
        while (left<=right){
            int mid= right+left/2;
            int hours= counter(arr,mid);
            if (hours<=h){
                ans=mid;
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return ans;
    }

    static public int counter(int[] nums,int rate){
        int takenHours=0;
        for (int i = 0; i < nums.length; i++) {
            takenHours+= (int) Math.ceil((double) nums[i]/(double) rate);
        }

        return takenHours;
    }
}

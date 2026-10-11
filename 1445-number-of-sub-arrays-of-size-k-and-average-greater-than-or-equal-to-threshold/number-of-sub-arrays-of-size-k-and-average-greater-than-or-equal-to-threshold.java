class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int cnt=0;
        int n = arr.length;
        int i=0;
        int j=0;
        int sum=0;

        while(j<k){
            sum+=arr[j++];
        }
        if (sum >= k * threshold) {
            cnt++;
        }

        while(j<n){
            sum-=arr[i++];
            sum+=arr[j++];
            if (sum >= k * threshold) {
            cnt++;
            }
        }

        return cnt;
    }
}
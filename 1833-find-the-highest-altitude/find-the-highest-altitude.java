class Solution {
    public int largestAltitude(int[] gain) {
        int current=0;
        int ans=Integer.MIN_VALUE;

        for(int num : gain){
            current = current+num;  
            ans=Math.max(current,ans);        
        }

        return ans<0?0:ans;
    }
}
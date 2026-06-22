class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n =s.length();
        if(n==0) return 0;
        int max=Integer.MIN_VALUE;

        for(int i=0;i<n;i++){
            String ans="";
            for(int j=i;j<n;j++){
                char current=s.charAt(j);
                if(ans.contains(current+"")){
                    break;
                }
                ans=ans+s.charAt(j);
                max=Math.max(max,ans.length());
            }
        }

        return max;
    }
}
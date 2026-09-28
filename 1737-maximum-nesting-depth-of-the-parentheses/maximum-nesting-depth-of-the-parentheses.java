class Solution {
    public int maxDepth(String s) {
        int ans=0;
        int depth=0;
        int n = s.length();

        for(int i=0;i<n;i++){
            if(s.charAt(i)=='('){
                depth++;
                ans=Math.max(ans,depth);
            }
            else if(s.charAt(i)==')'){
                depth--;
            }
            else{
                continue;
            }
        }
        return ans;
    }
}
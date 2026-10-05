class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s.length()!=0 && t.length()==0) return false;
        if(s.length()==0 && t.length()!=0) return true;
        if(s.length()==0 && t.length()==0) return true;
        int i=0;
        int j=0;
        while(j<t.length()){
            // if(i==s.length()) return true;
            char curr=s.charAt(i);
            if(curr==t.charAt(j)){
                i++;
                if(i==s.length()) return true;
                j++;
            }
            else{
                j++;
            }

        }
        return false;
    }
}
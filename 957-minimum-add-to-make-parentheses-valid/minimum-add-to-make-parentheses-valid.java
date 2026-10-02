class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> st = new Stack<>();
        int n = s.length();
        int unmatchedClosing=0;
        
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='('){
                st.push('(');
            }
            else{
                if (!st.isEmpty()) {
                    st.pop(); 
                } else {
                    unmatchedClosing++; 
                }
            }
        }

        return st.size()+unmatchedClosing;
    }
}
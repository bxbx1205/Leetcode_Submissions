class Solution {
    public int longestValidParentheses(String s) {
        int cnt=0;
        Stack<Integer> st = new Stack<>();
        int n = s.length();
        st.push(-1);

        for(int i=0;i<n;i++){
            if(s.charAt(i)=='('){
                st.push(i);
            }
            else if(s.charAt(i)==')'){
                st.pop();
                if(st.isEmpty()){
                    st.push(i);
                }
                else{
                    cnt=Math.max(cnt,i-st.peek());
                }
            }
        }
        return cnt;
    }
}
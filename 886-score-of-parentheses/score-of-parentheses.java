class Solution {
    public int scoreOfParentheses(String s) {
        int cnt=0;
        int depth=0;
        Stack<Character> st = new Stack<>();
        for(char ch : s.toCharArray()){
            if(ch=='('){
                depth++;
                st.push('(');
            }
            else{
                if(st.pop()=='('){
                    depth--;
                    int current = (int)Math.pow(2,depth);
                    cnt+=current;
                }
                else{
                    depth--;
                }
                
                st.push(')');
                
                
                // cnt=Math.max(cnt,current);
                // depth--;

            }
        }

        return cnt;
    }
}
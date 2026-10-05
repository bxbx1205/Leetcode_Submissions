class Solution {
    public int scoreOfParentheses(String s) {
        int cnt=0;
        int depth=0;
        // Stack<Character> st = new Stack<>();
        char prev='z';
        for(char ch : s.toCharArray()){
            if(ch=='('){
                depth++;
                prev='(';
                // st.push('(');
            }
            else{
                if(prev=='('){
                    depth--;
                    int current = (int)Math.pow(2,depth);
                    cnt+=current;
                }
                else{
                    depth--;
                }
                prev=')';
                // st.push(')');
                
                
                // cnt=Math.max(cnt,current);
                // depth--;

            }
        }

        return cnt;
    }
}
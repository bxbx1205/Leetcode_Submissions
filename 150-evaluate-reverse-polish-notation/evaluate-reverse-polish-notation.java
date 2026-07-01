class Solution {
    public int evalRPN(String[] tokens) {
        int n =tokens.length;
        Stack<Integer> st = new Stack<>();
        int ans=0;

        for(String s:tokens){
            
            if(s.equals("+")){
                int n1=st.pop();
                int n2=st.pop();
                st.push(n1+n2);
            }
            else if(s.equals("-")){
                int n1=st.pop();
                int n2=st.pop();
                st.push(n2-n1);
            }
            else if (s.equals("*")){
                int n1=st.pop();
                int n2=st.pop();
                st.push(n1*n2);
            }
            else if(s.equals("/")){
                int n1=st.pop();
                int n2=st.pop();
                st.push(n2/n1);
            }
            else{
                int current = Integer.parseInt(s);
                st.push(current);
            }
            
        }

        return st.pop();
    }
}
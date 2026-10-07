class Solution {
    public int minSwaps(String s) {
        Stack<Character> st = new Stack<>();

        for(char ch : s.toCharArray()){
            if(ch=='['){
                st.push('[');
            }
            else{
                if(st.isEmpty()){
                    st.push(']');
                }
                else if(st.peek()=='['){
                    st.pop();
                }
            }
        }
        return st.size()/2;
    }
}
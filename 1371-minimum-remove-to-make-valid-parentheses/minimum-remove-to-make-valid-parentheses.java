class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> st = new Stack<>();
        char[] str = s.toCharArray();

        for(int i =0;i<str.length;i++){

            if(str[i]>= 'a' && str[i]<='z'){
                continue;
            }

            if(str[i]=='('){
                st.push(i);
            }
            else{
                if(!st.isEmpty()){
                    st.pop();
                }
                else{
                    str[i]='#';
                }
            }
        }

        while(!st.isEmpty()){
            str[st.pop()]='#';
        }

        String ans = new String();
        
        for(int i =0;i<str.length;i++){
            if(str[i]!='#'){
                ans=ans+s.charAt(i);
            }
        }

        return ans;
    }
}
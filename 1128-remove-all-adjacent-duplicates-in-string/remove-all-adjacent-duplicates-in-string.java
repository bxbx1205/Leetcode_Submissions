class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> st = new Stack<>();

        for(char str : s.toCharArray()){

           if(!st.isEmpty() && st.peek()==str){
                st.pop();
            }
            else{
                st.push(str);
            }
        }
        

         StringBuilder ans = new StringBuilder();
            while(!st.isEmpty()){
               ans.append(st.pop()); 
            }

        return ans.reverse().toString();
    }
}
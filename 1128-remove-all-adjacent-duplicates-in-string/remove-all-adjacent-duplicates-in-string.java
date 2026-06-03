class Solution {
    public String removeDuplicates(String s) {
        // Stack<Character> st = new Stack<>();
        StringBuilder ans = new StringBuilder();

        for(char str : s.toCharArray()){
           int n = ans.length();


           if(n!=0 && ans.charAt(n-1)==str){
                ans.setLength(n-1);
            }
            else{
                ans.append(str);
            }
        }
        

        //     while(!st.isEmpty()){
        //        ans.append(st.pop()); 
        //     }

        return ans.toString();
    }
}
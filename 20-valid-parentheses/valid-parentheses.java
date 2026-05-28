class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        int n =s.length();
        if(n==0 || n==1) return false;

        for(int i=0;i<n;i++){
            char ss=s.charAt(i);
            if(ss=='(' ||ss=='['||ss=='{'){
                stack.push(ss);
            }
            else{
                if(stack.isEmpty()){
                    return false;
                }
                char ch = stack.peek();
                stack.pop();
                if((ch=='(' && ss!=')' )||(ch=='{' && ss!='}' )||(ch=='[' && ss!=']' )){
                    return false;
                }
            }
        }
        if(!stack.isEmpty()) return false;

        return true;
    }
}
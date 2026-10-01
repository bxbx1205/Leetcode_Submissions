class Solution {
    public boolean isValid(String s) {
        int n = s.length();
        Stack<Character> stack = new Stack<>();

        for(int i=0;i<n;i++){
            char current = s.charAt(i);
            if(current=='(' || current=='{' || current=='['){
                stack.push(current);
            }
            else{
                if(stack.isEmpty()) return false;
                char poped = stack.pop();
                if(current==')' && poped == '(' ||current==']' && poped == '[' ||current=='}' && poped == '{'){
                    continue;
                }
                else{
                    return false;
                }
            }
        }

        if(stack.isEmpty()) return true;

        return false;
    }
}
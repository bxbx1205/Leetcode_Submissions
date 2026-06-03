class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Character> stackChar = new Stack<>();
        Stack<Integer> stackCnt = new Stack<>();
        int n = s.length();

        for(int i = 0 ; i < n ; i++){
            char ch = s.charAt(i);
            if(!stackChar.isEmpty() && stackChar.peek()==ch){
                stackCnt.push(stackCnt.peek()+1);
            }
            else {
                stackCnt.push(1);
            }
            stackChar.push(ch);

            if(stackCnt.peek()==k){
                int fakeK=k;
                while(fakeK>0){
                    stackCnt.pop();
                    stackChar.pop();
                    fakeK--;
                }
            }

        }

        StringBuilder ans = new StringBuilder();

        while(!stackChar.isEmpty()){
            ans.append(stackChar.pop());
        }

    return ans.reverse().toString();
    }
}
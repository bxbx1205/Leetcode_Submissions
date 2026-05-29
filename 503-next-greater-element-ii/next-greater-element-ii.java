class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n =nums.length;
        Stack<Integer> stack = new Stack<>();
        int[] answer=new int[n];

        for(int i=2*n-1;i>=0;i--){

            while(!stack.isEmpty() && nums[i%n]>= stack.peek()){
                stack.pop();
            }

            if(i<n){

                if(stack.isEmpty()){
                    answer[i%n]=-1;
                }
                else{
                    answer[i%n]=stack.peek();
                }
            }

            stack.push(nums[i%n]);
        }

        return answer;
    }

}
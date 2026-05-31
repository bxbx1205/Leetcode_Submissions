class Solution {
    
    public void reverse(int[] nums){
        int left=0;
        int right=nums.length-1;

        while(left<right){
            int temp=nums[left];
            nums[left]=nums[right];
            nums[right]=temp;

            left++;
            right--;
        }
        return;
    }

    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        int n=asteroids.length;

        for(int i=0;i<n;i++){
            int absVal=Math.abs(asteroids[i]);

            if(asteroids[i]>0){
                stack.push(asteroids[i]);
            }
            else{

                while(!stack.isEmpty() && stack.peek() > 0 && stack.peek()<absVal){
                    stack.pop();
                }
            

            if(!stack.isEmpty() && stack.peek()==absVal){
                stack.pop();
            }
            else if(stack.isEmpty() || stack.peek()<0){
                stack.push(asteroids[i]);
            }
        }
        }

        int nS = stack.size();
        int[] ans = new int[nS];

        int index=0;
        while(!stack.isEmpty()){
            ans[index++]=stack.pop();
        }

        reverse(ans);
        return ans;
    }
}
class Solution {
    public int trap(int[] height) {
        int trappedWater=0;
        Stack<Integer> stack = new Stack<>();
        int n=height.length;


        for(int current=0;current<n;current++){

            while(!stack.isEmpty() && height[stack.peek()]<height[current]){
                int bottomIdx=stack.pop();

                if(stack.isEmpty()) break;

                int left = stack.peek();
                int right=current;

                int width=right-left-1;
                int min=Math.min(height[left],height[right]);
                int minHeight=min-height[bottomIdx];

                trappedWater+=minHeight*width;
            }


            stack.push(current);
        }

        return trappedWater;
    }
}
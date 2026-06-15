class Solution {
    public int[] pse(int[] nums){
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[nums.length];

        for(int i =0;i<nums.length;i++){

            while(!st.isEmpty() && nums[st.peek()]>=nums[i]){
                st.pop();
            }

            if(st.isEmpty()){
                ans[i]=-1;
            }
            else{
                ans[i]=st.peek();
            }
            st.push(i);
        }

        return ans;
    }

    public int[] nse(int[] nums){
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[nums.length];

        for(int i =nums.length-1;i>=0;i--){

            while(!st.isEmpty() && nums[st.peek()]>=nums[i]){
                st.pop();
            }

            if(st.isEmpty()){
                ans[i]=nums.length;
            }
            else{
                ans[i]=st.peek();
            }
            st.push(i);
        }

        return ans;
    }

    public int largestRectangleArea(int[] heights) {
        int[] pse = pse(heights);
        int[] nse = nse(heights);
        int area =0;

        for(int i =0;i<heights.length;i++){
            int current = heights[i]*(nse[i]-pse[i]-1);
            area=Math.max(area,current);
        }

        return area;
    }
}
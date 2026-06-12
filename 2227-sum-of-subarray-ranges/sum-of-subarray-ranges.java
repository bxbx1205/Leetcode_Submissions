class Solution {

    public long subMin(int[] nums){
        int n = nums.length;
        int[] nse = new int[n];
        Stack<Integer> st = new Stack<>();

        for(int i = n-1;i>=0;i--){

            while(!st.isEmpty() && nums[st.peek()]>= nums[i]){
                st.pop();
            }
            if(st.isEmpty()){
                nse[i]=n;
            }
            else{
                nse[i]=st.peek();
            }

            st.push(i);
        }

        st.clear();

        int[] psee = new int[n];

        for(int i = 0;i<n;i++){

            while(!st.isEmpty() && nums[st.peek()]> nums[i]){
                st.pop();
            }
            if(st.isEmpty()){
                psee[i]=-1;
            }
            else{
                psee[i]=st.peek();
            }

            st.push(i);
        }

        long answer=0;

        for (int i = 0; i < n; i++) {

            long left = i - psee[i];
            long right = nse[i] - i;

            long contri = left * right * nums[i];

           answer += contri;
        }

        return answer;

    }

    public long subMax(int[] nums){
        int n = nums.length;
        int[] nge = new int[n];
        Stack<Integer> st = new Stack<>();

        for(int i = n-1;i>=0;i--){

            while(!st.isEmpty() && nums[st.peek()]<= nums[i]){
                st.pop();
            }
            if(st.isEmpty()){
                nge[i]=n;
            }
            else{
                nge[i]=st.peek();
            }

            st.push(i);
        }

        st.clear();

        int[] pgee = new int[n];

        for(int i = 0;i<n;i++){

            while(!st.isEmpty() && nums[st.peek()]< nums[i]){
                st.pop();
            }
            if(st.isEmpty()){
                pgee[i]=-1;
            }
            else{
                pgee[i]=st.peek();
            }

            st.push(i);
        }

        long answer=0;

        for (int i = 0; i < n; i++) {

            long left = i - pgee[i];
            long right = nge[i] - i;

            long contri = left * right * nums[i];

           answer += contri;
        }

        return answer;

    }

    public long subArrayRanges(int[] nums) {
        return (subMax(nums)-subMin(nums));
    }
}
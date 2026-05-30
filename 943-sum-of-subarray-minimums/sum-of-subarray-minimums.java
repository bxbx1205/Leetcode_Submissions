class Solution {
    static int[] pse(int[] nums,int n){
        Stack<Integer> stack = new Stack<>();
        int[] pse = new int[n];
        
        for(int i=0;i<n;i++){

            while(!stack.isEmpty() && nums[stack.peek()]>nums[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                pse[i]=-1;
            }
            else{
                pse[i]=stack.peek();
            }

            stack.push(i);
        }
        return pse;
    }

    static int[] nse(int[] nums,int n){
        Stack<Integer> stack = new Stack<>();
        int[] nse = new int[n];
        

        for(int i=n-1;i>=0;i--){

            while(!stack.isEmpty() && nums[stack.peek()]>=nums[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                nse[i]=n;
            }
            else{
                nse[i]=stack.peek();
            }

            stack.push(i);
        }


        return nse;
    }

    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        long sum = 0;
        long mod = 1000000007;

        int[] pse = pse(arr, n);
        int[] nse = nse(arr, n);

        for (int i = 0; i < n; i++) {

            long left = i - pse[i];
            long right = nse[i] - i;

            long contri = left * right * arr[i];

            sum = (sum + contri) % mod;
        }

        return (int)sum;

    }
}
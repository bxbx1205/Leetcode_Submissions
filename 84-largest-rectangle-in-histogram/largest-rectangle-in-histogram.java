class Solution {
    
    public static int[] pse(int[] arr) {
        int n = arr.length;
        Stack<Integer> st = new Stack();
        int[] ans = new int[n];
        
        for(int i = 0 ;i<n ;i++){
            
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
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

    public static int[] nse(int[] arr) { 
    int n = arr.length; 
    Stack<Integer> st = new Stack<>(); 
    int[] ans = new int[n]; 
    
    for(int i = n - 1; i >= 0; i--){ 
        while(!st.isEmpty() && arr[st.peek()] >= arr[i]){ 
            st.pop(); 
        } 
        
        if(st.isEmpty()){ 
            ans[i] = n; 
        } else { 
            ans[i] = st.peek(); 
        } 
        
        st.push(i); 
    } 
    return ans; 
    }
    public int largestRectangleArea(int[] heights) {
        int[] nse = nse(heights);
        int[] pse = pse(heights);
        int area=0;

        for(int i=0;i<heights.length;i++){
            int current= heights[i]*(nse[i]-pse[i]-1);
            area=Math.max(area,current);
        }


        return area;
    }
}
class StockSpanner {
    Stack<int[] > st;
    int idx;

    public StockSpanner() {

    st = new Stack<>();
    idx=-1;    
    }
    
    public int next(int price) {
        idx++;

        while(!st.isEmpty() && st.peek()[0]<=price){
            st.pop();
        }
        int ans;
        if(st.isEmpty()){
            ans=idx+1;
        }
        else{
            ans=idx-st.peek()[1];
        }

        st.push(new int[]{price,idx});

        return ans;

    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
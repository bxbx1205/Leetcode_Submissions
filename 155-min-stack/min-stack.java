class MinStack {
    Stack<Long> stack;
    long minimum=Long.MAX_VALUE;

    public MinStack() {
        stack= new Stack<>();
    }
    
    public void push(int val) {
        long value=val;
        if(stack.isEmpty()){
            stack.push(value);
            minimum=value;
        }
        else if(value>minimum){
            stack.push(value);
        }
        else{
            stack.push(2*value-minimum);
            minimum=value;
        }
        return;
    }
    
    public void pop() {
        if(stack.isEmpty()){
            return;
        }
        long  x=stack.peek();
        stack.pop();
        if(x<minimum){
            minimum=2*minimum-x;
        }
        return;
    }
    
    public int top() {
         if (stack.isEmpty()) return -1;
        
        long x = stack.peek();
        if (x < minimum) {
            return (int) minimum;
        }
        return (int) x;
    }
    
    public int getMin() {
        return (int) minimum;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
class MyQueue {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> helper = new Stack<>();

    public MyQueue() {
       
    }

    public void push(int x) {
         if(stack.size()==0){
            stack.push(x);
        }
        else{

            while(stack.size()!=0){
                helper.push(stack.pop());
            }
            stack.push(x);
            while(helper.size()!=0){
                stack.push(helper.pop());
            }

        }
    }

    public int pop() {
        return stack.pop();
    }

    public int peek() {
        return stack.peek();
    }

    public boolean empty() {
        return stack.size() == 0;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
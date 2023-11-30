class MyQueue {
    Stack<Integer> stack1=new Stack<>();
    Stack<Integer> stack2=new Stack<>();


    public MyQueue() {
        
    }
    
    public void push(int x) {
        stack1.add(x);
    }
    
    public int pop() {
        if(stack2.empty()){
            while(!stack1.isEmpty()){
                stack2.add(stack1.peek());
                stack1.pop();
            }
        }
        
        return stack2.pop();
    }
    
    public int peek() {
        if(stack2.empty()){
            while(!stack1.isEmpty()){
                stack2.add(stack1.peek());
                stack1.pop();
            }
        }
        return stack2.peek();
    }
    
    public boolean empty() {
        return stack1.empty() && stack2.empty();
    }
}

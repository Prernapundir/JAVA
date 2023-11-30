// Time complexity ~ O(1) amortized 

class MyQueue {
    Stack<Integer> stack1=new Stack<>(); // Input stack for push
    Stack<Integer> stack2=new Stack<>(); // Output stack for peek/pop


    public MyQueue() {
        
    }
    
    public void push(int x) {
        stack1.add(x);
    }
    
    public int pop() {
        peek();
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

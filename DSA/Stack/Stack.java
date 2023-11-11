import java.util.Arrays;

public class Stack {
    private int[] arr;
    private int capacity=10;
    int size=0;

    public Stack(int capacity){
        this.capacity=capacity;
        arr=new int[this.capacity];
    }

    public void push(int val) throws Exception {
        if(isFull()) {
            System.out.println("Overflow");
            throw new Exception("Overflow");
        }
        arr[this.size]=val;
        size++;
    }

    public int pop() throws Exception {
        if(isEmpty()) {
            System.out.println("Underflow");
            throw new Exception("Underflow");
        }
        int element=arr[size];
        size--;
        return element;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public boolean isFull(){
        return this.size==this.capacity;
    }

    public void display(){
       for(int i=0;i<size;i++){
           System.out.print(arr[i]+",");
       }
        System.out.println();
    }

    public static void main(String[] args) throws Exception {
        Stack stack=new Stack(30);
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.display();

        stack.pop();
        stack.pop();

        stack.display();

        System.out.println(stack.isEmpty());
        System.out.println(stack.isFull());
    }


}

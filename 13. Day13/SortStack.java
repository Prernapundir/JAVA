import java.util.* ;
import java.io.*; 
public class Solution {

	public static void sortedInsert(int s,Stack<Integer> stack){
		if(stack.isEmpty() || s>=stack.peek()){
			stack.add(s);
			return;
		}
		int top=stack.peek();
		stack.pop();
		sortedInsert(s,stack);
		stack.push(top);
	}
	public static void sortStack(Stack<Integer> stack) {
		if(stack.isEmpty()) return ;

		Integer top=stack.peek();
		stack.pop();
		sortStack(stack);
		sortedInsert(top,stack);
	}

}

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack=new Stack<>();

        for(int i=0;i<s.length();i++){
            char x=s.charAt(i);
            if(x=='(' || x=='{' || x=='['){
                stack.add(x);
            }else if(!stack.isEmpty()) {
                if( (x==')' && stack.peek()=='(') || (x=='}' && stack.peek()=='{') || (x==']' && stack.peek()=='[')){
                    stack.pop();
                }else return false;
            }else return false;
        }

        return stack.isEmpty();
    }
}

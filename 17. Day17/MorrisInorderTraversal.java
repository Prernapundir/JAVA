class Solution {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();

        while(root!=null || !stack.isEmpty()){
            if(root!=null){
                stack.add(root);
                root=root.left;
            }else{
                root=stack.peek();
                stack.pop();
                ans.add(root.val);
                root=root.right;
            }
        }

        return ans;
    }
}

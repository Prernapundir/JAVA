class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
       List<Integer> ans=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();

        while(root!=null || !stack.isEmpty()){
            if(root!=null){
                ans.add(root.val); // Add before going to children
                stack.add(root);
                root=root.right;
            }else{
                TreeNode node=stack.pop();
                root=node.left;
            }
        }
        Collections.reverse(ans);
        return ans;
    }
}

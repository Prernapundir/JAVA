class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();

        while(root!=null || !stack.isEmpty()){
            if(root!=null){
                ans.add(root.val); // Add before going to children
                stack.add(root);
                root=root.left;
            }else{
                TreeNode node=stack.pop();
                root=node.right;
            }
        }
        return ans;
    }
}

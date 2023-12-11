class Solution {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();

        while(root!=null || !stack.isEmpty()){
            if(root!=null){
                stack.add(root);
                root=root.left;
            }else{
                TreeNode node=stack.pop();
                ans.add(node.val); // Add after all left children
                root=node.right;
            }
        }

        return ans;
    }
}

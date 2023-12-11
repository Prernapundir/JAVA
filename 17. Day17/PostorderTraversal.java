class Solution {
     public void inorder(TreeNode root,List<Integer> ans){
        if(root==null) return ;
        inorder(root.left,ans);
        inorder(root.right,ans);
        ans.add(root.val);

    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        inorder(root,ans);
        return ans;
    }
}

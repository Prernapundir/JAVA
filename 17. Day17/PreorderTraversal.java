class Solution {
     public void inorder(TreeNode root,List<Integer> ans){
        if(root==null) return ;
        ans.add(root.val);
        inorder(root.left,ans);
        inorder(root.right,ans);
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        inorder(root,ans);
        return ans;
    }
}

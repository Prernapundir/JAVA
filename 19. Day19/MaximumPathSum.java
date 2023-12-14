class Solution {
    int ans=Integer.MIN_VALUE;

    public int recur(TreeNode root){
        if(root==null) return 0;
        
        int left=recur(root.left);
        int right=recur(root.right);

        ans=Math.max(ans,left+right+root.val);
        return root.val+Math.max(left,right);
    }

    public int maxPathSum(TreeNode root) {
        recur(root);
        return ans;
    }
}

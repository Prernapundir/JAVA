class Solution {
    int d=0;
    public int height(TreeNode root){
        if(root==null) return 0;
        int left=height(root.left);
        int right=height(root.right);
        d=Math.max(d,left+right);
        return Math.max(left,right)+1;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        int diameter=0;
        height(root);
        return d;
    }
}

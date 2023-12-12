class Solution {
    boolean isBalanced=true;
    public int height(TreeNode root){
        if(root==null) return 0;
        int left=height(root.left);
        int right=height(root.right);

        if(Math.abs(left-right)>1){
            isBalanced=false;
            return 0;
        }

        return Math.max(left,right)+1;
    }

    public boolean isBalanced(TreeNode root) {
        height(root);
        return isBalanced;
    }
}

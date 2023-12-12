class Solution {
    public void dfs(TreeNode root,List<String> ans,String temp){
        if(root==null) return;
        temp+=root.val;
        if(root.left==null && root.right==null){
            ans.add(temp);
            return;
        }
        temp+="->";
        dfs(root.left,ans,temp);
        dfs(root.right,ans,temp);
    }
    public List<String> binaryTreePaths(TreeNode root) {
        String s="";
        List<String> ans=new ArrayList<>();
        dfs(root,ans,s);
        return ans;
    }
}

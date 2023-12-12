
class Solution {
    class Hold{
        TreeNode node;
        int index;
        Hold(TreeNode node,int index){
            this.node=node;
            this.index=index;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        Queue<Hold> queue=new LinkedList<>();
        queue.add(new Hold(root,0));
        int ans=0;
        int start=0,end=0;

        while(!queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<size;i++){
                Hold rn=queue.poll();
                if(i==0) start=rn.index;
                if(i==size-1) end=rn.index;

                if(rn.node.left!=null){
                    queue.add(new Hold(rn.node.left,2*rn.index+1));
                }
                if(rn.node.right!=null){
                    queue.add(new Hold(rn.node.right,2*rn.index+2));
                }
            }
            ans=Math.max(ans,end-start+1);
        }
        return ans;
    }
}

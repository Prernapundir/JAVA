class Tree
{
    ArrayList<Integer> leftView(Node root)
    {
      ArrayList<Integer> ans=new ArrayList<>();
      if(root==null) return ans;
     
      Queue<Node> queue=new LinkedList<>();
      queue.add(root);
      
      while(!queue.isEmpty()){
          int size=queue.size();
          for(int i=0;i<size;i++){
              Node node=queue.poll();
              if(i==0) ans.add(node.data);
              if(node.left!=null) queue.add(node.left);
              if(node.right!=null) queue.add(node.right);
          }
      }
      return ans;
    }
}

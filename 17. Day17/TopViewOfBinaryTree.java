class Solution
{
    static class Pair{
        Node node;
        int vd;
        Pair(Node node,int vd){
            this.node=node;
            this.vd=vd;
        }
    }
    static ArrayList<Integer> topView(Node root)
    {
        ArrayList<Integer> ans=new ArrayList<>();
        if(root==null) return ans;
        TreeMap<Integer,Node> map=new TreeMap<>();
        Queue<Pair> queue=new LinkedList<>();
        queue.add(new Pair(root,0));
        map.put(0,root);
        
        while(!queue.isEmpty()){
            Pair p=queue.poll();
            if(!map.containsKey(p.vd)){
                map.put(p.vd,p.node);
            }
            if(p.node.left!=null){
                queue.add(new Pair(p.node.left,p.vd-1));
            }
            if(p.node.right!=null){
                queue.add(new Pair(p.node.right,p.vd+1));
            }
        }
        
        for(Map.Entry<Integer,Node> m: map.entrySet()){
            ans.add(m.getValue().data);
        }
        
        return ans;
        
    }
}

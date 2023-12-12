class Solution {
    class Tuple{
        TreeNode node;
        int vd;
        int hd;
        Tuple(TreeNode node,int vd,int hd){
            this.node=node;
            this.vd=vd;
            this.hd=hd;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        if(root==null) return ans;
        TreeMap<Integer,TreeMap<Integer,List<Integer>>> map=new TreeMap<>();
        Queue<Tuple> queue=new LinkedList<>();
        queue.add(new Tuple(root,0,0));
        
        while(!queue.isEmpty()){
            Tuple p=queue.poll();
            if(!map.containsKey(p.vd)){
                map.put(p.vd,new TreeMap<>());
            }
            if(!map.get(p.vd).containsKey(p.hd)){
                map.get(p.vd).put(p.hd,new ArrayList<>());
            }

            map.get(p.vd).get(p.hd).add(p.node.val);

            if(p.node.left!=null){
                queue.add(new Tuple(p.node.left,p.vd-1,p.hd+1));
            }
            if(p.node.right!=null){
                queue.add(new Tuple(p.node.right,p.vd+1,p.hd+1));
            }
        }
        
        for(Map.Entry<Integer,TreeMap<Integer,List<Integer>>> m: map.entrySet()){
            List<Integer> temp=new ArrayList<>();
            for(Map.Entry<Integer,List<Integer>> node: m.getValue().entrySet()){
                node.getValue().stream().sorted().forEach(x->temp.add(x));
            }
            ans.add(temp);
        }
        
        return ans;
    }
}

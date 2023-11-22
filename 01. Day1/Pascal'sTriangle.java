class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans=new ArrayList<>();

        List<Integer> temp=new ArrayList<>();
        temp.add(1);
        ans.add(temp);

        for(int i=1;i<numRows;i++){
            temp=new ArrayList<>();
            temp.add(1);

            List<Integer> prev=ans.get(i-1);
            for(int j=1;j<prev.size();j++){
                temp.add(prev.get(j-1)+prev.get(j));
            }

            temp.add(1);
            ans.add(temp);
        }

        return ans;
    }
}

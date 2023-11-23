class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int count1=0;
        int count2=0;
        int val1=-0;
        int val2=0;
        int n=nums.length;
        List<Integer> ans=new ArrayList<>();
        
        for(int i :nums){
            if(i==val1) count1++;
            else if(i==val2) count2++;
            else if(count1==0){
                count1++;
                val1=i;
            }else if(count2==0){
                count2++;
                val2=i;
            }else {
                count1--;
                count2--;
            }
        }

        count1=0;
        count2=0;
        for(int x:nums){
            if(x==val1) count1++;
            else if(x==val2) count2++;
        }

        if(count1>n/3) ans.add(val1);
        if(count2>n/3) ans.add(val2);

        return ans;
    }
}

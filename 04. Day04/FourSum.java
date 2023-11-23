class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int n=nums.length;
        List<List<Integer>> ans=new ArrayList<>();

        for(int i=0;i<n;i++){
            if(i>0 && nums[i]==nums[i-1]) continue;
            for(int j=i+1;j<n;j++){
                if(j>i+1 && nums[j]==nums[j-1]) continue;
                long sum1=nums[i]+nums[j];
                int k=j+1;
                int l=n-1;
                while(k<l){
                    long sum2=nums[k]+nums[l];
                    if(sum1+sum2==target){
                        List<Integer> lis=new ArrayList<>();
                        lis.add(nums[i]);
                        lis.add(nums[j]);
                        lis.add(nums[k]);
                        lis.add(nums[l]);
                        ans.add(lis);
                        while(k<l && nums[k]==nums[k+1]) k++;
                        while(k<l && nums[l]==nums[l-1]) l--;
                        k++;
                        l--;
                    }else if(sum2+sum1>target) l--;
                    else k++;
                }
            }
        }
        return ans;
    }
}

class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        int ans=0;

        for(int i=0;i<nums.length;i++){
            map.put(nums[i],i);
        }
        for(int x:nums){
            if(!map.containsKey(x-1)){
                int count=0;
                int temp=x;
                while(map.containsKey(temp)){
                    count++;
                    temp++;
                }
                ans=Math.max(ans,count);
            }
        }
        return ans;
    }
}

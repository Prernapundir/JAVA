class Solution {
    public int majorityElement(int[] nums) {
        int count=0;
        int val=-1;
        int i=0;

        while(i<nums.length){
            if(count==0){
                count++;
                val=nums[i];
            }else if(nums[i]==val){
                count++;
            }else{
                count--;
            }
            i++;
        }
        return val;
    }
}

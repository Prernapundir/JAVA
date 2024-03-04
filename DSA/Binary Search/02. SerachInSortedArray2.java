
/*
Same approach like searchInSortedArray, just avoid the duplicates for the case 3 3 1 2 3 3 , so check
nums[low]==nums[mid]==nums[high]
*/

class Solution {
    public boolean search(int[] nums, int target) {
        int low=0,high=nums.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]==target) return true;
           if((nums[mid]==nums[low]) && (nums[mid]==nums[high])){   // duplicates case
                low++;
                high--;
            }else{
                if(nums[mid]>=nums[low]){
                    if(target>=nums[low] && target<=nums[mid]){
                        high=mid-1;
                    }else low=mid+1;
            }else{
                    if(target>=nums[mid] && target<=nums[high]){
                        low=mid+1;
                    }else high=mid-1;
                }
            }
        }
        return false;
    }
}

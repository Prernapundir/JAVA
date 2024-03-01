class Solution {
    public int maxProduct(int[] nums) {
        int max_so_far=nums[0];
        int min_product=nums[0];
        int max_product=nums[0];

        for(var x: nums){
            int temp=max_product;
            max_product=Math.max(Math.max(x,max_product*x),x*min_product);
            min_product=Math.max(Math.min(x,min_product*x),temp*x);
            max_so_far=Math.max(max_so_far,max_product);
        }
        return max_so_far;
    }
}

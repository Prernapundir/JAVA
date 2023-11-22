class Solution {
    public int maxProfit(int[] prices) {
        int max_profit=0;
        int curr=prices[0];

        for(int i=1;i<prices.length;i++){
            if(prices[i]>curr){
                max_profit=Math.max(max_profit,prices[i]-curr);
            }else if(prices[i]<curr){
                curr=prices[i];
            }
        }

        return max_profit;
    }
}

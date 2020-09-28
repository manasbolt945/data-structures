class Solution {
    public int maxProfit(int[] prices) 
    {
        int k=prices.length-2;
        int buy = -1;
        int sell = 0;
        while(k>=0)
        {
            buy = Math.max(buy,prices[k+1]);
            sell = Math.max(sell,buy-prices[k]);
            k--;
        }
        if(prices.length==0 || prices.length==1)
            return 0;
        else
        return(sell);
    }
}

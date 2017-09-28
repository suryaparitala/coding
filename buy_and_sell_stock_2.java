class Solution {
    public int maxProfit(int[] prices) {
        
        if(prices.length == 0){
            return 0;
        }
        int sum = 0;
        for(int i = 1; i < prices.length ; i++){// since we want max profit and can do mutiple buy and sells we only do those trasactions that are profittable 
            
            if(prices[i] - prices[i-1] >=0 ){
                sum = sum + prices[i] - prices[i-1];
            }
            
        }
        return sum;
    }
}
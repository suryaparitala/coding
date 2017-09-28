class Solution {
    public int maxProfit(int[] prices) {
        
        int max = 0;
        int sum =0;
        //Doing multiple small transactions is same as doing one big trasaction i.e 6-1 is a sum of 5-1,3-2,6-3 
        
        for(int i=1; i< prices.length ; i++ ){
            
            
            
            sum =  Math.max( 0 , sum +=  prices[i] - prices[i-1]);// if adding the new net profit to the old sum brings down the total profit so far to zero then reset the sum to 0. Or else keep continuing and check which will be the max sum (profit) obtained so far. 
            //if a we find a trasaction that is so bad that it brings down the entire profit earend so far to -ve that means that corresponig trasaction has a value which is very low and hence make it our new low point and start checking for high point corresponidng to that low point 
            max = Math.max(sum , max);
            
        }
        return max;
    
        
        
        
    }
}
public class Solution {
    public int climbStairs(int n) {
        
        if(n < 0)
            return 0;
        
        if(n == 2)
            return 2;
        if(n  == 1 || n == 2) // since we are starting loop from 3 rd step we need to handle the other two cases.
            return 1;
        
       
        int secondlast = 1;// for the 0 th step , we need to keep value as 1 for 0 th step because there is also a possible way from step 0
        int last = 1;// for the 1 st step
        int curr =0;
        
        for(int i= 2 ; i<= n ; i++){
            
            curr =  secondlast + last;
            secondlast = last;
            last = curr;
        }
        return curr;
        
    }
}
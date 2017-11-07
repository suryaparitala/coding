class Solution {
    public int mySqrt(int x) {
        
        if(x == 0 || x == 1){ // for x = 0 and x =1 it goes into a loop also the answer is number itself
            return x;
        }
        
        long mid = x/2;// always sqrt is less than half , because x/2 * x/2 = x^2/4 < x^2
        
        
        while(mid > 0){
            
           
            if(mid * mid > x){ // if mid squre is more than val then further decrese mid 
                
                mid = mid/2;
                
            }
            else if( mid * mid <= x){ // since we want answer in int not exact answer ex - sqrt(2) = 1 not 1.414 we try to bound and give the integer answer instead of trying to compute for eacg value
                
                if(mid * mid == x){ // typical if mid square is ans return mid
                    return (int) mid;
                }
                else if((mid+1) * (mid+1) > x){ // now once we have a mid such that mid^2 < val and (mid+1)^2 > val then it means that actual answer  is some where between mid and mid+1, since we want int answer we need not compute we just return mid
                    return (int)(mid );
                }
                else{ // it comes here only when mid+1 square is still less than val in that case increase mid and try again
                    mid = mid +1;
                }
                
                
            }
            
            
            
        }
        
        return -1; // dummy return , code will never reach here
        
    }
}
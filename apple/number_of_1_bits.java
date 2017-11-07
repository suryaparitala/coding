public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        if(n == 0){
            return 0;
        }
        
        int count = 0;
        while( n != 0 ){// we cant do n>0 because after integer limit is reached it goes to -Integer.MIN_VALUE even in thst case we must count 
            
            if((n & 1) == 1){
                count++;
            }
            n = n >>> 1; // this is shift bits without sigh extension and that is what we want
        }
        
        
       return count; 
    }
}
class Solution {
    public String convertToTitle(int n) {
        
        
        
        StringBuilder sb = new StringBuilder();
        // This is similar to convert a base 10 to base 2 . Because any number can be wriiten as AAZ = 1*26^2 + 1*26^1 + 26*26^0
        we get the numbers 1,1,26 by continous mod and division.
        while( n > 0){
            
            
            sb.insert(0 , (char) ('A' + (n-1) % 26 ));// we do n-1 because we map 26% 26 which is 0 + 65 = A but 26 must be Z so when do n-1 we get 25% 26 + 65 = z , since the count is starting from zero 
            
            n = n-1 /26; // also since we are calcualting for n-1 but actually havent reduced n so again do n-1
            
            
            
        }
        
       return sb.toString(); 
    }
}
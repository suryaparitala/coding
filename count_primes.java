class Solution {
    public int countPrimes(int n) {
        
        boolean[] arr = new boolean[n];
        
        if(n < 3){
            return 0; 
        }
        
        arr[0] = true;
        arr[1] = true;
        
        for(int i = 2 ; i <= n/2 ; i++ ){  // can go upto n/2 because after n/2 everthing is divisble by 2, also do <= n/2
            
            for(int j = 2 ; i*j < n ; j++){ // start from j = 2 because if we do j =1 the number itself will be made true, also always make sure i*j is less than n
                
                arr[i*j] = true;
                
            }
            
            
        }
        int count = 0;
        for(int i = 1 ; i < n ;i ++ ){
            
            if(arr[i] == false){
                count++;
            }
            
        }
        
        return count;
        
    }
}
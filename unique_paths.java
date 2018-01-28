class Solution {
    public int uniquePaths(int m, int n) {
        
        int[][] dp = new int[m][n];
        
        
        for(int i =0;i < m ; i++ ){
            for( int j = 0;j<n;j++){
                
                
                if(i== 0){ // if i = 0 then it means it is the first row , for any element in first row the only possible way is to have a path from right. So its is always 1
                    dp[i][j] = 1;
                    
                    
                }
                else if(j == 0){ // similarly for first column the only possible path is to come from the top
                    dp[i][j] = 1;
                    
                }
                else{
                    
                    dp[i][j] = dp[i][j-1] + dp[i-1][j];// else in other case we can come from the top or the left
                    
                    
                }
                
                
                
                
                
            }
            
            
        }
        return dp[m-1][n-1];
        
        
    }
}
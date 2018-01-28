class Solution {
    public int minPathSum(int[][] grid) {
        
        int rows = grid.length;
        int coloumns = grid[0].length;
        
        for(int i = 0;i < rows ;i++){
            
            for(int j =0 ; j < coloumns ; j++){
                
                if(i == 0 && j == 0){
                    
                    continue;
                }
                else if(i == 0){ // here cumilate the sums from the left, because for the first row the only possible path is from its left
                    
                    grid[i][j] = grid[i][j] + grid[i][j-1];
                    
                }
                else if(j == 0){// here cumilate the sums from the top , because for the first coloumn the only possible path is fromt the top
                    
                    grid[i][j] = grid[i][j] + grid[i-1][j];
                    
                }
                
                else{
                    grid[i][j] = grid[i][j] + Math.min(grid[i][j-1],grid[i-1][j]);
                }
                
            }
        }
        
        return grid[rows-1][coloumns-1];
        
    }
}
class Solution {
    public void rotate(int[][] matrix) {
        
        if(matrix.length == 0 && matrix[0].length == 0 ){
            return;
        }
        
        // rotate coloums wise
        int m = matrix.length;
        int n = matrix[0].length;
        
        for(int i = 0; i < m/2 ; i++ ){ // swap rows top and bottom layer by layer, dont swap completlry only till half swp it or else we will end up swapping the already swapped
            
            for(int j=0;j<n;j++){
                
                int temp = matrix[i][j];
                
                matrix[i][j] = matrix[(m-1)-i][j];
                
                matrix[(m-1)-i][j] = temp;
                
            }
        }
        
        for(int i=0;i<m;i++ ){
            
            for(int j=i; j < n; j++ ){// here keep j=i or else we will visit the already inverted elemnents counter part  again re-reverse it
                
               int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
                
                
                
            }
            
        }
        return;
        
    }
}
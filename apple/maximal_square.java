class Solution {
    public int maximalSquare(char[][] matrix) {
        
        
        
        
        
        if(matrix.length == 0 ){
            return 0;
        }
        
        int[] pre = new int[matrix[0].length];// to store previous array dp answers
        int[] curr = new int[matrix[0].length];// to store current array dp answers
        
        // note we need to maintain a current array seperate from previous array , if we were to have only 1 array and dynamically calculate new dp and store it it wouldnt work , new dp array requires old dp array  and previous element in new dp array
        
        int max = 0;
        
        for(int i=0;i<matrix[0].length;i++){
            
            pre[i] = matrix[0][i] - '0';
            max = Math.max(max , pre[i] );
            
        }
       //System.out.println(Arrays.toString(ans) + " ans ");
        
        
        
        for(int i=1;i<matrix.length;i++){
            
            
            curr[0] = matrix[i][0] -'0';// for curr assigning the first element 
            max = Math.max(max , curr[0]);// instead of wrintg a loop again we are calculating the max here directly.
            for(int j=1;j < matrix[0].length; j++){
                
                if(matrix[i][j] == '1'){
                    
                    
                    
                    curr[j] = Math.min(curr[j-1] , Math.min(pre[j],pre[j-1])) +1;
                    max = Math.max(max , curr[j]);
                    
                
                    
                }
                
            }
            
            pre = curr;
            curr = new int[matrix[0].length];// if we dont assign curr to a new array it will be still pointing to pre and any change to curr will change pre
            //System.out.println(ans + " and ans1 " + ans1);
           
            
            
        }
        return max*max;
        
    }
}
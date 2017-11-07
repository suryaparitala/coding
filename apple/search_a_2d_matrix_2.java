class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        if(matrix.length == 0 || matrix[0].length == 0){
            return false;
        }
        int i = 0;
        int j = matrix[0].length-1;
        
        while(i < matrix.length && j >= 0){// here the i can go upto matrix.length not matrix[0].length because matrix[0].length gives number of coloumsn but we want rows
            
            if(matrix[i][j] == target){
                
                return true;
            }
            
            if(matrix[i][j]  < target){
                System.out.println(" going  down ");
                i++;
                
            }
            else if(matrix[i][j] > target){
               System.out.println(" going  left ");
                j--;
                
            }
            
            
        }
        
        return false;// it will break out of loop when boundry conditions fails that when it means no element found
    }
}



// not working but logic correct


class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        if(matrix.length == 0 || matrix[0].length == 0){// write first matrix.length = 0 because if matrix.length is zero then there is no matrix at all and then if we try to access matrix[0] it will give exception. If we write that one first and its true it will never cocme to second one as we are using an or operator
            
            return false;
            
        }
        
        
        int start = 0;
        int end = matrix.length - 1;// we find mid matrix since all are arranges as [1,2,5],[2,4,6,],[6,8,9] we first do binary serach on first element of each row to check if we can cosnider that row.
        
        while(start < end ){// serach first index of each coloum
            
            
           int mid = start + (end - start)/2;
            
            if(matrix[mid][0] == target){
                return true;
                
            }
            if(matrix[mid][0] < target && matrix[mid][matrix[0].length-1] <= target){
                
                if(find(matrix , target , mid)){
                    return true;
                }
                
            }
            
                
            if(find(matrix , target , mid+1)){
                    return true;
                }
                
           if(find(matrix , target , mid-1)){
                    return true;
                }
                
        }
        
        return false;
        
}
    
    public boolean find( int[][] matrix , int target,int row ){// search a row 
        
        int start = 0;
        int end = matrix[start].length-1;
        
        while(start < end){
            
            int mid = start + (end - start)/2;
            if(matrix[row][mid] == target){
                return true;
            }
            else if(matrix[row][mid] < target){
                
                start = mid + 1;
                
                
            }
            else if(matrix[row][mid] > target){
                
                end = mid-1;
                
                
            }
            
        }
        
        return false;
        
        
    }
}
class Solution {
    public boolean isValidSudoku(char[][] b) {
        
        HashSet<String> set = new HashSet<String>();
        
        for(int i=0; i < b.length ;i++){
            
            for(int j=0; j <  b[0].length;j++){
                
               if(b[i][j] != '.'){ 
                
                char num = b[i][j];
                
                String temp = "("+  num + ")";
                
                if( !set.add(i + temp ) || !set.add(temp + j) || !set.add(i/3 + temp + j/3 ) ){// by doing i/3 and j/3 we are giving same representations to numbers in a grid ex - 00,01,02 and 10,11,12 and 20,21,22 all are same grid. they all have same i/3 and j/3 i.e since 0/3 = 0  , 1/3 = 0 and 2/3 = 0 and this i/ 3 and j/3 is unique for each grid
                    
                    return false;
                }
                   
               }
                
                
                
                
                
            }
            
        }
        
        return true;
        
    }
}
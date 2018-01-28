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


	00 01 02 03 04 05 06 07 08  00 00 00 01 01 01 02 02 02
	10 11 12 13 14 15 16 17 18	00 00 00 01 01 01 02 02 02
	20 21 22 23 24 25 26 27 28 	00 00 00 01 01 01 02 02 02
								10 10 10 11 11 11 12 12 12 
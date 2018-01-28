class Solution {
    public int findLength(int[] a, int[] b) {// same as  to longest commmon substring
        
        
        if(a.length == 0 || b.length == 0){
            
            return 0;
        }
        
        int[][] ans = new int[a.length + 1 ][b.length + 1];// by default everything is zero
        int max = 0;
        
        for(int i = 1 ; i <= a.length ; i++){
            
            for(int j = 1 ; j <= b.length ; j++){
                
                if(a[i-1] == b[j-1]){// note since we are starting from 1 and words are zero based indexed
                    ans[i][j] = ans[i-1][j-1] + 1;
                }
                max = Math.max(max , ans[i][j]);
                
            }
            
        }
        
        return max;
        
    }
}
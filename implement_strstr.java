class Solution {
    public int strStr(String haystack, String needle) {
        
        if(haystack == null || needle == null){
            return 0;
        }
        
        int ans = -1;
        
        char[] hs = haystack.toCharArray();
        char[] nd= needle.toCharArray();
        int hslen = hs.length;
        int ndlen = nd.length;
        
        
        if(ndlen == 0 && hslen ==0){
            return 0;
        }
        if(ndlen == 0 && hslen != 0 ){
            return 0;
        }
        if(ndlen == 0 || hslen ==0){
            return ans;
        }
        
        if(ndlen > hslen){
            return ans;
        }
        
        
        for(int i=0 ; i< (hs.length) - (nd.length ) + 1; i++){
            
            
            int j = 0;
            int x = i;// dont directly use i in the while loop becuase inside while loop we are doing x++ and j++. If we direclty use i in some cases we will miss out matching combinaitons of i in between , Ex = "mississippi" and "issip" in this case in the if we directly use i we issip =! issis in the first checkin of i but we will missout the letter i which is in between
            
            if( x+ ndlen-1 < hslen  && hs[x] == nd[j] ){// must check if x + ndlen-1 doesnt exceed the bounds we do ndlen -1 beacuse we are already at first postion of common element
                System.out.println("code is here " + x);
                 ans = i;
                while(j < ndlen){
                    
                    
                    if(hs[x] != nd[j]){
                        ans = -1;
                        break;
                    }
                    if(hs[x] == nd[j] && j == ndlen -1){
                        return ans;
                    }
                    x++;
                    j++;
                    
                    
                    
                }
            }
            
            
            
        }
        return ans;
        
    }
}
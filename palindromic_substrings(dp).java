class Solution {
    
    public int countSubstrings(String s) {
        
        int count =0;
        if(s.length() == 0){
            return 0;
        }
        
        char[] ch = s.toCharArray();
        
        boolean[][] dp = new boolean[s.length() ][s.length() ];
        
        for(int i = ch.length -1 ; i>=0 ;i--){
            
            for(int j=i ; j < ch.length ; j++ ){//starting from the i index go again until end covering all possiblities
            
            dp[i][j] =  ((ch[i] == ch[j] && j-i < 3) || (ch[i] == ch[j] &&dp[i+1][j-1]) );// always ch[i] == ch[j] or else palindrome not possible, if j-i<3 it means only 1 ot 2 elesmnts so only condition needed is ch[i] == ch[j] , if the size is not less than 3 then again go and check the next condition if again the elements are same an then furhter check intenaly the elemetns are same or not using dp[i+1][j-1]
            if(dp[i][j]){// if that dp is true then its a palindrome
                count++;
            }
                
        }
        
        
    }
        return count;
}
}
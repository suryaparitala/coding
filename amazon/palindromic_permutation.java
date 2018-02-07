class Solution {
    
    int maxsize = 0;
    int start = 0;
    public String longestPalindrome(String s) {
        
        String ans = "";
        if(s.length() == 0){
            return "";
            
        }
        if(s.length() < 2){
            return s;
        }
        char[] ch = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i < ch.length -1 ; i++){
            extendpalindrome(ch ,i , i  );
            extendpalindrome(ch, i , i+1 );
        }
        
        return s.substring(start ,start + maxsize);
    }
    
    public void extendpalindrome(char[] ch , int left , int right ){
        
        if(left >= 0 && right < ch.length && ch[left] == ch[right]){
            
            
            while(left >= 0 && right < ch.length && ch[left] == ch[right]){
                left--;
                right++;
                
            }
            
            if(right - left - 1 > maxsize){
                
                start = left +1;
                maxsize = right - left - 1;
               // System.out.println(" max size is  " + maxsize + " and " + start);
                
            }
            
            
            
            
        }
        
        return;
        
    }
}



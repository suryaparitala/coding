public class Solution {
    public String reverseWords(String s) {
        
       String ans = "";
        if(s.length() == 0){
            return ans;
            
        }
        String[] str = s.split("\\s+");
        
        if(str.length == 0){
            return ans;
        }
        StringBuilder sb = new StringBuilder();
       
        
        for(int i= str.length - 1 ; i >=0 ; i--){
           // System.out.println(str[i] + "dasfdf");
            if(!str[i].equals("")){ // in some cases if we have "a " in the array we will get {a,""} to avoid the null we do it
            ans = ans + str[i] + " ";
            }
            
        }
        
        return ans.substring(0,ans.length() - 1);
        
        
    }
}




public class Solution {
    
    public String s ;
    public char[] ch ;
    public String reverseWords(String s) {
        
        this.s = s;
        if(s.length() == 0){
            return "";
        }
        s.trim();
       ch = s.toCharArray();
        
        swap(0 , s.length() - 1);
        int start = 0;
        int end = 0;
        while(start < ch.length){
            
            
            while( start < ch.length &&  ch[start] == ' ' ){
                start++;
                
            }
            end = start;
            
            while(end < ch.length && ch[end] != ' '){
                
                end++;
            }
            swap(start , end -1);
            
            start = end;
            
            
            
            
        }
        
        
        swap(start , ch.length -1);
        
        int i = 0;
        int j = 0;
        int n = ch.length;
    while (j < n) { // to clean spaces
              while (j < n && ch[j] == ' ') j++;             // skip spaces
              while (j < n && ch[j] != ' ') ch[i++] = ch[j++]; // keep non spaces
              while (j < n && ch[j] == ' ') j++;             // skip spaces
              if (j < n) ch[i++] = ' ';                      // keep only one space
    }
        
        
        return new String(ch).substring(0, i);
        
    }
    
    public void swap(int start , int end){
        
        
        while(start < end){
            
           char temp = ch[start];
            ch[start] = ch[end];
            ch[end] = temp;
            
            start++;
            end--;
            
            
        
        }
        
    }
}



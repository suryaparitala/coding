class Solution {
    
    int count = 0;
    public int countSubstrings(String s) {
        
        if(s.length() == 0){
            return 0;
        }
        char[] ch = s.toCharArray();
        for(int i=0;i < ch.length ; i++){
            extend(ch,i,i);// sending the same element to extend and find out
            extend(ch,i,i+1);// send i and i+1 i.e two elements at a time to extend and find out , dont worry about extending limits when sending i and i+1 as the extend function will take care of it
            
        }
        
        return count;
    }
    
    public void extend(char[] ch , int i , int j){
        
        if(i < 0 && i >= ch.length && j < 0 && j >= ch.length){// as we are going out of bounds return 
            
            return;
        }
        while(i>=0 && i<ch.length && j>= 0 && j< ch.length && ch[i] == ch[j]){//extends towards the left i-- and towards right j
            // and checks, if at any point they are not equal of bounds exceed it will quit the while loop and stop extending, because abca will never be a palndrome because b and c are differnt
            count++;
            i--;
            j++;
            
        }
        return;
        
    }
}
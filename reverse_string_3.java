class Solution {
    public String reverseWords(String s) {
        
        s = s.trim();// to remove white spaces at the edges
        char[] ch = s.toCharArray();
        
        int size = ch.length;
        
        int i=0;
        
        int start = 0;
        int end =0;
        
        while(i < size){
            
            while( i < size  &&ch[i] != ' ' ){// initially we will have start at 0 and i will stop on first space charcter
                
                i++;
                
                
            }

            end = i-1;// since the while loop quit because i was on space , so end would be i-1
            reverse(ch , start , end);// reverse the word
            
            
            while( i < size && ch[i] == ' '){// now previously i was on a space using this while loop we move over all the spcaes onto start of next word 
                System.out.println(" omiitng spcae " + i);
                i++;
            }
            
            start = i;// assigning start to i beacuse after while loop i moves over all the spaces onto first charcter on a new word . Again the while loop continues to find next stop and start
            
            
        }
        
        reverse(ch , start , i-1);// because before the while loop stopped because i was more than last index, thus for last word in the string which doesnt have a space we must manullay reverse it
        
        
           return new String(ch); 
            
        }
        
    
    
    
    public void reverse(char[] ch , int i ,int j){
        
        System.out.println( i + " and " + j);
        
        
        while(i < j){
            char temp = ch[i];
            ch[i] = ch[j];
            ch[j] = temp;
            i++;
            j--;
            
            
        }
        
        
    }
}
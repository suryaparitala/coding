import java.util.*;
public class kdigits {
    public String removeKdigits(String num, int k) {
      
       char[] stk = new char[num.length()];
       int fullsize = num.length() - k;
       int top = 0;
       if(num.length() == k) // if all elements in the string can be removed then return zero
       return "0";
       
       for(int i =0 ;i<num.length();i++){
           char c = num.charAt(i);
           while(top > 0 && k > 0 && stk[top-1] > c){ // till here all the big numbers are removed
               top = top -1;
               k = k-1;
               }
             stk[top++] = c;
       }
       int index = 0;
       
       while(index < fullsize && stk[index] == '0')// this gives a count of how many continuos 0's are present at the beginning
       index++;
       
       String str = new String(stk,index,fullsize - index); // String(some array , starting from index , how many values from that index )
       return index == fullsize ? "0": new String(stk, index, fullsize - index);
       
        
        
}
}
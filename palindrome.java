import java.util.*;
public class palindrome{
public static void main(String[] args){
    String s = "aabccda"; //multiples of 2 plus 1
        char[] cha = s.toCharArray();
        int count = 0;
        Hashtable<Character,Integer> tab = new Hashtable<Character,Integer>();
        for(char ch : cha){
            if(!tab.contains(ch))
                tab.put(ch,1);
            else
            tab.put(ch,tab.get(ch)+1);
            }
	        for(char ch : cha){
	            
	            System.out.println(ch + " elemet occurs " + tab.get(ch));
	            
	            }
        for(char ch : cha){
            if(tab.get(ch) == 1 ){
            System.out.println(ch + " count is" + tab.get(ch));
            count = count + tab.get(ch);
            }
            
        }  
            
            
         System.out.println(count+1);   
        }
		
    }

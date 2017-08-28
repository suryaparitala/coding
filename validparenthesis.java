public class Solution {
    public boolean isValid(String s) {
        if(s == null)
            return false;
        
        char[] ch = s.toCharArray();
        
        HashSet<Character> openlist = new HashSet<Character>();
        openlist.add('(');
        openlist.add('{');
        openlist.add('[');
        
        HashMap<Character , Character> map = new HashMap<Character , Character>();
        map.put('}' , '{');
        map.put(']' , '[');
        map.put(')' , '(');
        
        Stack<Character> stk = new Stack<Character>();
        int i = 0;
        if( ch.length % 2 != 0 ) //. if odd number of elements the something wrong.
            return false;
        while(i == 0 || i < ch.length && !stk.isEmpty()){ // for i=0 let it enter 
            char var = ch[i];
            if(openlist.contains(var)){
                System.out.println("adding" + ch[i] + "to stack" + i);
                stk.push(ch[i]); 
                i++;
            }
            else{
                if(stk.isEmpty()){// because if we have (){}[  then by the time we get [ the stack will be empty and nothing will be there to be compared with in the stack. Also if we direclty have ( as the first element and the stack is empty then return false
                    return false;
                }
                else{
                    
                    if(stk.peek() == map.get(ch[i])){// parentesis matched remove from stack
                        stk.pop();
                        i++;
                    }
                    else{// parenthesis not matched
                        return false;
                    }
                    
                }
            }
            
        }
        
        if(i == ch.length && !stk.isEmpty() ){ // there are some left over element in stack even though i reached its end i.e some unmatched elelmetns were left out. Ex - ({}() so at the end of while loop we have ( left out in th stk 
            return false;
        }
        
        return true;
        
    }
}
// solution using queue

class Solution {
    public List<String> letterCombinations(String digits) {//[""] ,iteration i=0  pick elements with size 0 from queue and add them with each alpahbet of digit[0]  string,
 //       ["a","b","c"] , iteration i=1 , pick elements with size 1 from queue and add them with each alpabet of digit[1] string 
        
        Queue<String> q = new LinkedList<String>();
        if(digits.length() ==0){
            return new ArrayList(q);
        }
        
        
        String[] list = {"0","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        
        q.add("");
        
        for(int i = 0 ; i < digits.length() ; i++){
            
            int digitval = Integer.parseInt(digits.charAt(i)+"");
            
            while(q.peek().length() == i){ // as long there is an element in the queue of length same i it means there are few unmultiplied elements 
              
                String temp = q.remove();
                
                for(char s : list[digitval].toCharArray()){
                   
                    q.add(temp + s);
                    
                }
                
                
            }
            
        }
       // System.out.println(q.size());
        
        return new ArrayList(q);
        
    }
}


class Solution {
    String[] list = {"0" , "1","abc","def","ghi", "jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        
        ArrayList<String> ans = new ArrayList<>();
        if(digits.length()==0){
            
            return ans;
            
        }
        
        
        
        comb(digits , ans, "" , 0 );
        
        return ans;
        
    }
    
    public void comb(String digits , ArrayList<String> ans, String temp ,int offset){
        
        if(temp.length() == digits.length() ){
            
            ans.add(temp);
            return;
        }
        
        int digitval = Integer.parseInt(digits.charAt(offset) + "");// from the offset get the next digit value
        
        String newadd = list[digitval];// get the corresponding string to the digit
        
        for(int i=0;i<newadd.length();i++){
            
            comb(digits , ans , temp + newadd.charAt(i), offset+1);// for the old temp add each character from new word using for loop and recurse down , also incremrnt offset so that next digit can be processed 
            
            
        }
        
        return;
        
        
    }
}
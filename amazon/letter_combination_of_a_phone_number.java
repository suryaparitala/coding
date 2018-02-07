
//recrsive approach
class Solution {
    public List<String> letterCombinations(String digits) {
        
        
        
        List<String> anslist = new ArrayList<String>();
        if(digits.length() == 0){
            return anslist;
            
        }
        
        String[] arr = {"0","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        anslist.add("");
        combine("", 0 , anslist , arr , digits);// initillalt offset is zero so String ar digit[0] is appended to ""
        
        anslist.remove("");
        return anslist;
        
    }
    
    
    public void combine(String temp , int offset , List<String> anslist , String[] arr , String digits){// offset tells how deep we are inside and to consider which index in the digit
        
        if(offset > digits.length()){
            return;
            
        }
        if(offset == digits.length()){
            anslist.add(temp);
            return;
        }
        
        int indexval= Integer.parseInt(digits.charAt(offset) + "");
        String addstr = arr[indexval];
        
        for(char x : addstr.toCharArray()){
            
            combine(temp + x , offset + 1 , anslist , arr , digits );
            
        }
        
        
    }
}


// iterarative appraoch

class Solution {
    public List<String> letterCombinations(String digits) {
        
        
        
        List<String> anslist = new ArrayList<String>();
        
        if(digits.length() == 0){
            
            return anslist;
        }
        
        String arr[] = {"0","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        
        Queue<String> que = new LinkedList<String>();
        
        
        
        que.add("");// keep adding everthing to queue
        
        
        for(int i = 0;i < digits.length() ; i++ ){
            
            int indexval = Integer.parseInt(digits.charAt(i)+"");
            
            
                
                while(!que.isEmpty() && que.peek().length() == i){// inside que pick elements whose length is same as i, and add the new string to that value . ex- when index i =1 it means it needs all the string with size 1 so that it can add append
                    String temp = que.poll();
                    
                    for(char x : arr[indexval].toCharArray()){
                         que.add(temp + x);
                     }
                
                
               }
            
            
            
            
        }
        
        
        while(!que.isEmpty()){
            
            anslist.add(que.poll());
            
        }
        
        return anslist;
    }
}







//my appraoch works but is very slow
// works but very slow , got time limit exceeded
class Solution {
    public List<String> letterCombinations(String digits) {
        
        
        
        List<String> anslist = new ArrayList<String>();
        
        if(digits.length() == 0){
            
            return anslist;
        }
        
        String arr[] = {"0","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        
        Queue<String> que1 = new LinkedList<String>();
        Queue<String> que2 = new LinkedList<String>();
        
        int index = Integer.parseInt(digits.charAt(0)+"");
        
        for(char x : arr[index].toCharArray()){
            
            que1.add(x+"");
            
        }
        
        
        
        for(int i = 1;i < digits.length() ; i++ ){
            
            int indexval = Integer.parseInt(digits.charAt(i)+"");
            
            
                
                while(!que1.isEmpty()){
                    String temp = que1.poll();
                    
                    for(char x : arr[indexval].toCharArray()){
                         que2.add(temp + x);
                     }
                
                
               }
            que1 = que2;
            
            
            
        }
        
        Queue<String> main = que1.size() == 0 ? que2 : que1;
        while(!main.isEmpty()){
            
            anslist.add(main.poll());
            
        }
        
        return anslist;
    }
}
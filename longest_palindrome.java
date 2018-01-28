class Solution {
    public int longestPalindrome(String s) {// for a palindorme all even or all even + only 1 odd occuring in the middle
        
        
        int size = s.length();
        
        HashSet<Character> set = new HashSet<>();
        
        for(char ch : s.toCharArray()){// add the element in the set if not there, remove the already existing elemnet,by doing so only the odd elements will be left in the set
            
            if(set.contains(ch)){
                set.remove(ch);
                
            }else{
                set.add(ch);
            }
            
            
        }
        
        int remaining = set.size();// all the odd elements are left in the set
        int pairs_formed = size - remaining; // total- odd elemenst will give all the even elements which all can form palindromes
        
        if(remaining > 0){// if set contians odd elements then we can keep an odd one in the centre and form a plaindrome
            return pairs_formed + 1;
        }else{// if set is empty no odd elements so , so the palindorme is made up of only even pairs
            return pairs_formed;
        }
        
        
        
        
        
        
        
        
        
    }
}
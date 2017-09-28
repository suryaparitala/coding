class Solution {
    public boolean isPalindrome(String s) {
        
        s = s.trim();
        char[] arr = s.toCharArray();
        int i = 0;
        int j = arr.length - 1;
        if(j <= 0)
            return true;
        
        
        
        while(i <= j){
            
           
            if(!Character.isLetterOrDigit(arr[i]) ){ // check if character is letter or digit
                i++;
            }
            
            else if(!Character.isLetterOrDigit(arr[j] )){
                j--;
            }
            
             else{// always keep else and inside the else check the condition if letters are matching. If we dont keep else and directly keep if condition which is down we will have issues. The code  after skipping i and j instead of going to the while loop  to get i<=j checked it will directly check if arr[i]!=arr[j] which will give errors as in case of ".;" after i increases and j decreases from the first two conditions we have i=1 and j=0 in this case even though i<=j fails it goes and checks if they are unequal or not and print false. But in reality the condition should stop at while loop as i>j.
            
            if(Character.toUpperCase(arr[i]) != Character.toUpperCase(arr[j]) ){
                
                System.out.println("here "+ arr[i] + " and " + arr[j] + " " + i + " and " + j);
                return false;
            }
            i++;
            j--;

        }
        }
            
        
        
        return true;
    }
}
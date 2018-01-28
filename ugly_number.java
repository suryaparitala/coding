class Solution {
    public boolean isUgly(int num) {
        
        if(num <= 0){ // since ugly number must be postive, also if it is zero is not divisble by anything 
            return false;
        }
        
        while(num > 0 && num % 2 == 0){// as long as the number is more than zero and its a factor of 2 keep divivding
            num = num/2;
            
        }
        
        while(num > 0 && num % 3 == 0){
            
            num = num /3;
        }
        
        while(num > 0 && num % 5 == 0){
            
            num = num /5;
            
        }
        
        return num == 1 ? true : false;// if it was ugly number after contiouns divisions by 2,3,5 only 1 will be left out
        
    }
}
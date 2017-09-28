public class Solution {
    public boolean isHappy(int n) {
        int x = n;
        int y = n;
        if(n == 0){
            return false;
        }
        while(x > 1){// put while x>0 or x>1 because if x = 0 only n=0 can give that and also if x =1 then it is happy 
            x = cal(x) ;
            if(x==1) return true ;
            y = cal(cal(y));// running the calc twice , so it behaces like a fast pointer
            if(y==1) return true ;

            if(x==y) return false;
        }
        return true ;
    }
    public int cal(int n){
        int x = n;
        int s = 0;
        while(x>0){
            s = s+(x%10)*(x%10);
            x = x/10;
        }
        return s ;
    }
}
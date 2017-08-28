public class Solution {
    public static int n;
    public List<String> generateParenthesis(int n) {
        this.n = n;
        ArrayList<String> list = new ArrayList<String>();
        if(n <= 0 )
            return list;
        
        StringBuilder sb = new StringBuilder();
        
        sb.append("(");
        
        generate(n-1 , n , 1 , sb , list); // start the iteration with n-1 as we are already adding a (  and starting the recursion
        
        return list;
        
    }
    
    public void generate(int openb , int closeb , int sum , StringBuilder sb , ArrayList<String> list){
        
        if(sum < 0 || openb < 0 || closeb < 0){ // if sum is -ve then it means more closing brackets than opening which is invalid ,also openbracket count and closed bracket count should be less than or equal to zero (note in can be equal to zero because in if n is given as 3 and we have ((( even though openb count is 0 we want to continue recurison  further down and try (((( for which it will fail and ((() which is valid and can be further continued.
            return;
        }
        if(sb.length() == n*2 ){
            list.add((new StringBuilder(sb)).toString()); // since sb is non primitive it is pass by reference so create a new obejct and add rather than just passing a reference
            return;
        }
        
        generate(openb-1 , closeb , sum + 1 , sb.append("("), list );// for a ( add 1 to compute the sum and ) subtract 1
        sb.deleteCharAt(sb.length()-1); // delete the mess we did since java string builder is non primitve it goes pass by refernce
        
        generate(openb , closeb - 1 , sum - 1 , sb.append(")"), list );//for a ( add 1 to compute the sum and ) subtract 1
        sb.deleteCharAt(sb.length()-1);
        
        return;
        
    }
}
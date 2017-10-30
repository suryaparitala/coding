
// using recurisin and start index to avoid duplicates
class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
       
        List<List<Integer>> anslist = new ArrayList<>();
        
        if(target == 0){
            return anslist;
        }
        HashSet<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();// since we are doing using start based recursin we dont need a set to check
        
        
            
            List<Integer> temp = new ArrayList<Integer>();
            
            find(nums , target , anslist , temp , set , 0, 0);
          return anslist;  
        }
        
        
        
    
    
    public void find(int[] nums ,  int target , List<List<Integer>> anslist ,List<Integer> temp , HashSet<ArrayList<Integer>> set , int sum , int start ){
        
        if(sum > target){
            return;
        }  
        // ArrayList<Integer >temp2 = new ArrayList<>(temp);
        if(sum  == target){
            
         // System.out.println(" target reached " + temp +  " is "+sum );
            
           
                
                // set.add(new ArrayList(temp2));
                anslist.add(new ArrayList(temp));
                return;
            }
            
        
        
        for(int i = start ; i< nums.length; i++){
            
            temp.add(nums[i]);
           // System.out.println("temp before czll" + temp);
         //  System.out.println(" sum is " + (sum + nums[i]));
            
            find(nums , target , anslist , temp , set , sum + nums[i] ,i);// since repetitions are allowed 2 -> 2 -> 2 , 2 -> 2 -> 3 , 2 -> 2 -> 6 , 2 -> 2 -> 7, if we do i+1 we wont get  2 -> 2 -> 2 as we are going to next one. Also we can do next set of iteratiosn from i as 2 -> 2 -> 2 is computed in a previous iteration , if we again start from index 0 for every element we will have 2 -> 3 -> 2 which is same as 2 -> 2 -> 3  so to avoid repeats do this. In case of peermutations problem we dont need a start at all as 2 -> 2 -> 3  is differnt from 2 -> 3 -> 2
            
            temp.remove( temp.size()-1);
            
        }
        
        
        
        
    }
}






//------------------------------------------------------trying to use a set and soritng -------------------------------------------------------------------------
class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
       
        List<List<Integer>> anslist = new ArrayList<>();
        
        if(target == 0){
            return anslist;
        }
        HashSet<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();// since we are doing using start based recursin we dont need a set to check
        
        
            
            List<Integer> temp = new ArrayList<Integer>();
            
            find(nums , target , anslist , temp , set , 0, 0);
          return anslist;  
        }
        
        
        
    
    
    public void find(int[] nums ,  int target , List<List<Integer>> anslist ,List<Integer> temp , HashSet<ArrayList<Integer>> set , int sum  ){
        
        if(sum > target){
            return;
        }  
        ArrayList<Integer >temp2 = new ArrayList<>(temp);
        if(sum  == target){
            
         // System.out.println(" target reached " + temp +  " is "+sum );
            
            Collections.sort(temp2);
            if(set.contains(temp2)){
                return;
            }else{
                
                set.add(new ArrayList(temp2));
                anslist.add(new ArrayList(temp2));
                return;
            }
            
        }
        
        for(int i=0 ; i< nums.length; i++){
            
            temp.add(nums[i]);
           // System.out.println("temp before czll" + temp);
         //  System.out.println(" sum is " + (sum + nums[i]));
            
            find(nums , target , anslist , temp , set , sum + nums[i] );// since repetitions are allowed 2 -> 2 -> 2 , 2 -> 2 -> 3 , 2 -> 2 -> 6 , 2 -> 2 -> 7, if we do i+1 we wont get  2 -> 2 -> 2 as we are going to next one. Also we can do next set of iteratiosn from i as 2 -> 2 -> 2 is computed in a previous iteration , if we again start from index 0 for every element we will have 2 -> 3 -> 2 which is same as 2 -> 2 -> 3  so to avoid repeats do this. In case of peermutations problem we dont need a start at all as 2 -> 2 -> 3  is differnt from 2 -> 3 -> 2
            
            temp.remove( temp.size()-1);
            
        }
        
        
        
        
    }
}



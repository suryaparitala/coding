class Solution {
    public int[] productExceptSelf(int[] nums) {// intially res[i] stores product of all elements to left of i in nums and again we replace the data in it at the last 
        
        
//ex for nums =  [3,2,0,6] intitallly res = [1,3 , 6 ,0 ] which stores left value to that corresponidng index and then again we start from last and keep right =1 and update res[i] by doing old res[i] which is left , then multily left * right ,so new res[i] = left(i.e old res[i])*right . Simultaneosly update right for the next iteration
        
        int[] res = new int[nums.length];
        res[0] = 1;// there is nothing to the left of first number so leave it as 1 and store that in res
        
        for(int i=1 ; i< nums.length;i++){
            
            System.out.println(res[i-1] + " and " + nums[i-1]);
            res[i] = res[i-1]*nums[i-1];// store all the products to index i's right
        }
        
        
        int right = 1;// for the value at last index the right is 1 as there is nothing else to its right
        for(int i = nums.length -1 ; i >= 0 ;i--){
            
            res[i] = res[i] * right;// since old res[i] is storig all the products to its left and right stores right product we do right*left
            right = right * nums[i];//preparing right for the next iteration
            
        }
        
        return res;
        
    }
}
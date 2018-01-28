class Solution { // use fischer yates algorithm , O(n) time and O(n) space complexity, choose a random index between current index and end, and swap those two, by doing so we can make sure everthing have equal probability

    int[] original;
    Random random = new Random();
    int[] nums;
    public Solution(int[] nums) {
        
        original = Arrays.copyOf(nums , nums.length);
        
        this.nums = nums;
        
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        
        return original;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        
        for(int i = 0 ; i < nums.length ; i++ ){
            
            int rand = random.nextInt(nums.length - i) + i;// nextInt(max - min) + min , nextInt(max - min) will give an integer in range of 0 - (max -min) , furether we add min to move its range form i to max 
            
            shuffle(i ,rand , nums);
            
        }
        
        return nums;
        
    }
    
    
    public void shuffle(int old, int newindex, int[] nums ){
        
        
       int temp =  nums[old];
       nums[old] = nums[newindex];
       nums[newindex] = temp;
        
        
        
        
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
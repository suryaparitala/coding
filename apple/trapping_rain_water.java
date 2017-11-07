class Solution {
    public int trap(int[] height) { // O(n) time and space is O(2n) because two array are being used
        
        int ans =0;
        if(height.length == 0){
                
            return ans;
        }
        int[] leftdp = new int[height.length];
        
        leftdp[0] = height[0];
        
        for(int i=1 ; i < height.length ; i++){// height array storing max left heights
            
            leftdp[i] = Math.max(leftdp[i-1] , height[i]);
            
        }
        
        int[] rightdp = new int[height.length];
        
        rightdp[height.length - 1] = height[height.length - 1];
        
        for(int i = height.length -2 ; i>=0 ;i--){// stores max right height upto that index
            
            rightdp[i] = Math.max(rightdp[i+1] , height[i]);
            
        }
        
        
        for(int i=0;i<height.length;i++){
            
            ans = ans + Math.min(leftdp[i],rightdp[i]) - height[i];// min of left and right heights because it is bounded by the two. Also subtract height[i] because its own height will block the water so remove it 
            
            
        }
        
        
        
        return ans;
        
        
    }
}
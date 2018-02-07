class Solution {
    public List<Integer> partitionLabels(String S) {
        
        int[] arr = new int[26];
        
        int index = 0;
        
        for(char ch : S.toCharArray()){
            
            arr[ch - 'a'] = index;
            index++;
            
        }
        int endpoint = 0;
        int start = 0;
        ArrayList<Integer> ans = new ArrayList<Integer>();
        
        for(int i = 0;i < S.length();i++ ){
            
            
            if(arr[S.charAt(i) - 'a'] > endpoint){ // if the endpoint is less than index of the character , then increase the endpoint
                endpoint = arr[S.charAt(i) - 'a'];
            }
            if(i == endpoint){ // if endpoint is same as index i then all the elements are with in the endpoint range,because if it was more than endpoint then endpoint would have increased.
                    ans.add(endpoint - start + 1);
                    start = endpoint+1;// start of new word is the one next to end of old word 
                    endpoint = -1;
            }
            
            
            
        }
        
        return ans;
        
        
    }
}




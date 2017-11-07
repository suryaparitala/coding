class Solution {
    public boolean canConstruct(String note, String mag) {
        
        if(mag.length() == 0 && note.length() == 0  ){
            return true;
        }
        if(note.length() == 0 && mag.length() != 0){
            
            return true;
        }
        
        int[] arr = new int[26];
        
        for(int i = 0; i < mag.length() ;i++){// 65-90 (A-B) and 97-122(a-b)
            
            int val = mag.charAt(i) - 'a';
            
            arr[val]++;
            
        }
        
        for(int i=0;i<note.length() ; i++){
            
            int val = note.charAt(i) - 'a';
            
            arr[val]--;
            
            if(arr[val] < 0){
                return false;
            }
            
            
        }
        
       return true; 
    }
}
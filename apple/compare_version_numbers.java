class Solution {
    public int compareVersion(String version1, String version2) {
        
        if(version1.length() == 0 && version2.length() != 0){
            
            return 1;
            
        }
        if(version1.length() != 0 && version2.length() == 0){
            
            return -1;
            
        }
        
        
        String[] ch1 = version1.split("\\.");// escape escape . with \ and escape \ with another \
        String[] ch2 = version2.split("\\.");
        
        for(int i = 0 ; i < Math.max(ch1.length,ch2.length ); i++ ){
            
         int ans1 =   i >= ch1.length ? 0 : Integer.valueOf(ch1[i]);
        
        int ans2 =   i >= ch2.length ? 0 : Integer.valueOf(ch2[i]);
            
            if(ans1 > ans2 ){
                return 1;
                
            }
            if(ans1 < ans2){
                return -1;
            }
            
            
            
        }
        
        return 0;
        
    }
}
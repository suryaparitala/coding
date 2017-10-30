class Solution {
    public String largestNumber(int[] nums) {
        
        String ans = ""; 
        if(nums.length == 0){
            return ans;
        }
        String[] str = new String[nums.length];
        int i=0;
        for(int x : nums){// converting numbers to strings to do sortig 
            str[i++] = x+"";
        }
        
        Arrays.sort(str, new Comparator<String>(){
            
            public int compare(String s1 ,String s2){// "1" and "2" if we sort compiler will autmatically do numnerical sort
                
                String a = s1 + s2;// check if "30" + "3" = 303 is bigger or 
                String b = s2 + s1;// check if "3" + "30" = 303 is bigger
                
                return a.compareTo(b);// compare among these which is bigger and place one before it
            }
            
            
        });
        if(str[str.length-1].charAt(0) == '0'){// this signifies a seqqnces of zeros for which we want answer as 0 not 00000
            return "0";
        }
        
        for(String s : str){// do s + ans as we are concatenating new values at the end 9,5,34,30,3 
            ans = s + ans;
            
        }
        
        return ans;
    }
}
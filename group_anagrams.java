class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        ArrayList<List<String>> finallist = new ArrayList<List<String>>();
        if(strs == null || strs.length == 0){
            return finallist;
        }
        
        
        HashMap<String , ArrayList<String>> map = new HashMap<String , ArrayList<String>>();
        for(String s : strs){
            // System.out.println(" Before sorting " + s);
            String dup = s;
            char[] ch = dup.toCharArray();
            Arrays.sort(ch);
            dup = new String(ch); // donot use tostring method as it will give references
            // System.out.println(" After sorting " + dup);
            
            
            if( map.containsKey(dup)){
                
                ArrayList temp = map.get(dup);
                temp.add(s);
                
            }
            else{
                System.out.println("adding a new string to map " + dup);
                ArrayList<String> newlist = new ArrayList<String>();
                newlist.add(s);
                map.put(dup , newlist);
            }
            
            
        }
        return new ArrayList<List<String>> (map.values());
        
    }
}
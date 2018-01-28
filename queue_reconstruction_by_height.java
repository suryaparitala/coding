class Solution {
    public int[][] reconstructQueue(int[][] people) {
        
        
        
        if(people == null ||people.length == 0 || people[0].length == 0){
            
            return new int[0][0];
            
        }
        
        int[][] ans = new int[people.length][people[0].length];
        
        Arrays.sort(people, new Comparator<int[]>(){
        
        public int compare(int[] a , int[] b){
            
            
            if(a[0] == b[0]){ // the they are same heights so sort them is ascensing order of k value so that we access the one with smaller k because we use k as the index and we if we directly use bigger index it will cause out of bounds exception
                
                
                return a[1] - b[1];// this is natural it will give ascending order
                
            }
            
            return  b[0] - a[0]; // for all the non same heights sort them in descending order
            
        }
        
        
        });
        
        
        ArrayList<int[]> anslist = new ArrayList<>();// use array list because we insert at desired location, but we cant do list.add(6,3) on an emply array list as it is still emplty , we can only add in between and at the end of list, i.e is why to overcome this problem we are sorting same elements based on their increasing k values
        
        for(int i=0;i< people.length ;i++){
            
            anslist.add(people[i][1] , new int[]{people[i][0],people[i][1]});// insert at the respective k index
        }
        
        
        
        
        for(int i=0;i<anslist.size();i++){
            
            int[] temp = anslist.get(i);
            ans[i][0] = temp[0];
            ans[i][1] = temp[1];
            
        }
        
        
        return ans;
        
        
        
        
    }
}
/*
// Employee info
class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
};
*/
class Solution {
    public int getImportance(List<Employee> employees, int id) {
        
        HashMap<Integer,Employee> map = new HashMap<>();
        for(Employee emp : employees){// need a map to have a mapping between employee id and the its employee structure
            
            map.put(emp.id , emp );
        }
        
        if(map.size() == 0){
            return 0;
            
        }
        
        
        int ans = find(employees , map , id);
        
        return ans;
        
    }
    
    
    public int find(List<Employee> employees , HashMap<Integer , Employee> map , int id){
        
        // no need a base case because if the sub ordinate list is empty it will just return ans which is nothing but current importance value
        List<Integer> sublist = map.get(id).subordinates;
        
        int ans = 0;
        ans = ans + map.get(id).importance;
        for(Integer emp : sublist){
            
            ans = ans + find(employees , map , emp);
            
        }
        
        return ans;
        
    }
}
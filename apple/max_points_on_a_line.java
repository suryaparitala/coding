/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
class Solution {
    public int maxPoints(Point[] points) {
        
        if(points.length == 0){
            
            return 0;
            
        }
        if(points.length <= 2){ // . if two point then staright line can be formed. If only 1 point even then a line is formed 
            
            return points.length;
        }
        
        
        
        int ans = 0;
        for(int i=0;i < points.length;i++){
            
            int samep = 0;
            int samex = 1;// when comparing with two points we are adding +1 if we find a corresponding value , but there are 2 numbers to be added 
            
            HashMap<Double,Integer> map = new HashMap<>();
            
            for(int j=0;j < points.length;j++){
                
                
                
                if(i != j){// skip the same element
                    
                  
                    if((points[j].x == points[i].x) && (points[j].y == points[i].y)){// if its a the same point make samep++,we are putting contine here but we are keeping it in the next check condition because if same point also contributes to same x criteria
                        samep++;
                        
                     }
                    
                    if(points[i].x == points[j].x ){// only need to care about x because it y1-y2 / x1 - x2 ; so if x are same then slope is infinite;
                        
                        samex++;
                        continue;
                        
                    }
                       
                    double val = (double)(points[j].y - points[i].y) /(double) (points[j].x - points[i].x);
                  //  System.out.println(val + " and " + points[i].x + " "+ points[i].y + " and " + points[j].x + " " + points[j].y);
                    if(map.containsKey(val)){
                        map.put(val , map.get(val)+1);// adding only once vecause already one of the slope point is there that is why we are getting 1
                    }
                    else{
                        map.put(val ,2);// since there are two points that make up the slope    
                    }
                    
                    ans = Math.max(ans , map.get(val)+samep);// same point will have same slope so just add here,simulatanously after adding the value compare if its a max 
                   
                }
                
                
                
                
            }
            //System.out.println("end of loop " + map);
            
            ans = Math.max(ans , samex);// samex deals with point on a vertical line, and the max calculated inside using val is for sloped lines, so we are comparing which have more points sloped lines or poins on a straight line(samex) 
            
         }
        
        return ans;
        
        
    }
}




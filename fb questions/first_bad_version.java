/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    
    public int firstBadVersion(int n) {

        if( isBadVersion(1) == true)
            return 1;
        
        int first =1;
        int last = n;
        int mid = 0;
        
        while(first < last){
            
            mid = first + (last - first) /2;
            // System.out.println(mid);
             if( mid+1 <= n && isBadVersion(mid) == false && isBadVersion(mid+1) == true){ // mid+1 <=n to check if mid=1 we dont do mid-1 which is zero and doesnt exist
                 // System.out.println("entered here1");
                 return mid + 1;
            }
            else if(mid >=2  && isBadVersion(mid) == true && isBadVersion(mid - 1) == false){// mid>=2 because wea re doing mid-1 
               // System.out.println("entered here2");
                return mid;
            }
            else if(isBadVersion(mid) == true){// since both the above conditions fail we our mid is surrounded by bad so decrease last
                // System.out.println("entered here3");
                last =  mid-1;
            }
            else{// it means our mid is surrouned by good so increase the start
                // System.out.println("entered here4");
               first = mid+1;
            }
            
            
            
        }
        
        return -1;
        
    }
}
class Solution {
    public int thirdMax(int[] nums) {
        
        if(nums.length == 0){
            return 0;
        }
        
        Integer fmax = null;// dont keep fmax as Integer.MIN_VAL as it will lead to some corner case
        Integer smax = null;
        Integer tmax = null;
        
        
        for(Integer num : nums){// run for all the numbers juding which is first , second and third
            
            if( fmax == null || num >= fmax){// biggest number so far so shift everything, also we are doing = also because if same number comes deal it here only or else it will go to next if and disturb
               
                if(num.equals(fmax)){// if we get a same number just ignore and continue, also use .equals not == because we are intially keeping fmax == null using .equlals as we want to compare values not references
                    continue;
                }
                tmax = smax;
                smax = fmax;
                fmax = num;
                
            }
            
           else if(smax == null ||num >= smax){// second biggest number so far so shift last two
                
               if(num.equals(smax)){
                    continue;
                }
                tmax = smax;
                smax = num;
                
            }
            
           else if(tmax == null ||num >= tmax){// if it crosses over the prevous two if stamtnes and enters this one then this is the third max
                
               if(num.equals(tmax)){
                    continue;
                }
               tmax = num;
                
            }
            
        }
        
        return tmax == null ? fmax : tmax;
        
        
    }
}
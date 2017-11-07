




public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        
        if(n == 0){
            return 0;
        }
        
        int result = 0;
        
        for(int i=0;i<32;i++){
            
            result = result + (n & 1);// take the last bit from n and also add to result,note:for result we already added a dummy zero at the last so as to perform an add operation
            
            n =  n >> 1;// now shift right 1 bit for the next iteration
            
            if(i<31){//  need to shift only 31 because we need add a left dummy zero for the last bit
                
                result = (result << 1);// move to the right and add a zero at last so that in next iteration we can add a bit to that last place
            }
            
            
        }
     return result;   
    }
}


// futher optimized approach

private final Map<Byte, Integer> cache = new HashMap<Byte, Integer>();
public int reverseBits(int n) {
    byte[] bytes = new byte[4];
    for (int i = 0; i < 4; i++) // convert int into 4 bytes
        bytes[i] = (byte)((n >>> 8*i) & 0xFF);
    int result = 0;
    for (int i = 0; i < 4; i++) {
        result += reverseByte(bytes[i]); // reverse per byte
        if (i < 3)
            result <<= 8;
    }
    return result;
}

private int reverseByte(byte b) {
    Integer value = cache.get(b); // first look up from cache
    if (value != null)
        return value;
    value = 0;
    // reverse by bit
    for (int i = 0; i < 8; i++) {
        value += ((b >>> i) & 1);
        if (i < 7)
            value <<= 1;
    }
    cache.put(b, value);
    return value;
}
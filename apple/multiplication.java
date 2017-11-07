result = 0;
while (b != 0)               // Iterate the loop till b == 0
{
     if (b & 01)               // Bitwise & of the value of b with 01
      {
            result = result + a;  // Add a to result if b is odd .
      }
      a<<=1;                    // Left shifting the value contained in 'a' by 1
                                  // Multiplies a by 2 for each loop
      b>>=1;                    // Right shifting the value contained in 'b' by 1.
}

// ex = 6 and 5 
// note that b=5 is odd and it will be odd only 2 time since we are diving by 2 always so b= 5 to b=4 now b will  never be odd as we are always doing b/2 , it will be odd only at last case where where 2/2 is 1. So once b os even we can easily do a*2 and b/2 which will gives us same answer and continously do until b reaches 1 and then add what there in a.
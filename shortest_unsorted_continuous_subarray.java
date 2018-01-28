class Solution {
    public int findUnsortedSubarray(int[] A) {
        
        int n = A.length, beg = -1, end = -2, min = A[n-1], max = A[0];
    for (int i=1;i<n;i++) {// using loop keep tracking the entire loop
     
        max = Math.max(max, A[i]);// keep track of max between current element and previous, since we are going left to right alwasys the current element must be the max element in a corrcectly sorted sequece
      
        min = Math.min(min, A[n-1-i]);// similar to above start from other end keep track of min
     
    if (A[i] < max){
        end = i;// if current element is not max it an anmoly so mark it
    }
     if (A[n-1-i] > min) {// simlilary while coming from right left if current element is not min, then it is an anamoly
          beg = n-1-i;
      }
    }
    return end - beg + 1;// by the time loop ends we have the extreme anamoly points only and ignore the intermediate anamolies
        
    }
}
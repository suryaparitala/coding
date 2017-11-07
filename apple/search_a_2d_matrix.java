class Solution {
    public boolean searchMatrix(int[][] arr, int target) {
        
        if(arr.length == 0 || arr[0].length == 0){
            
            return false;
            
        }
        
        int start = 0;
        int end = (arr.length * arr[0].length ) - 1;
        int n = arr[0].length;// number of elements in each row
        
        while(start <= end){
            
            int mid = start + (end - start)/2;
            System.out.println(" mid is " + mid);
            
            if(arr[mid / n][mid % n] == target){// arr[mid/n][mid%n] since after n elements a new row starts, and for every row the columsn go from 0-(n-1) that is why we do modulus
                
                return true;
                
            }
            
            else if( arr[mid/n][mid%n] < target){
                
                System.out.println("increasing  mid");
                start = mid + 1;
                
            }
            else if( arr[mid/n][mid%n] > target){
                
                System.out.println("reducing mid");
                end = mid -1;
            }
            
        }
        
        return false;
        
    }
}
class Solution {
    public int removeDuplicates(int[] nums) {


//         if(nums.length < 2)
//             return nums.length;

//         int index =0;
//         for(int i=0 ; i< nums.length ; i++){

//             if(nums[index ] != nums[i]){ // if nums[index] and nums[i] are same then do nothing skip duplicates and go to next i;Whenever a uniue elements are found do nums[++index] = nums[i] which menas at index++ position keep nums[i]. We are doing ++index and replacing it with nums[i] because at index we have first element of repeating  elements sequence and at index++ we have second repeating element.Here i is like a fast pointer and index is a slow pointer which always points to first element of a repeating sequence.
//                 nums[++index] = nums[i];
//             }

//         }
//         return index + 1; // since index points to the first element in repeating sequnce by the end of for loop index will be poinintg to the first element in the last repeating sequence.Since index is the position in actuality the number is index+1 as index position starts from zero

        if(nums.length < 2)
              return nums.length;


        int i=0;// i is the slow pointer, it will be pointing to the first element of the repeating sequence
        int j=0;// fast pointer alwasys go ahead and seracehs for new element

        while(i< nums.length  && j< nums.length) {

            if(nums[i] == nums[j]){// increase j so that it can go and find the next different element
                j++;
            }

            else{// i and j are different so copy j to the i+1 position as at i we have first element of the repeating sequence

                nums[++i] = nums[j];
                j++;// also incremnt j so that it can continue with next element


            }


        }

        return i+1;

    }
}

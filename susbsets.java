public class Solution {
    public List<List<Integer>> subsets(int[] nums) {

        ArrayList<List<Integer>> anslist = new ArrayList<List<Integer>>();

        if(nums.length == 0)
            return anslist;
        ArrayList<Integer> list = new ArrayList<Integer>();
        findsubset(nums , list , anslist , 0);

        return anslist;
    }


    public void findsubset(int[] nums , ArrayList<Integer> list , ArrayList<List<Integer>> anslist , int index){

        System.out.println("-----------  ---------  adding to the final list "+  list + " index is " + index);


        anslist.add(new ArrayList<Integer>(list)); // this will add null into ans list and also when index reaches the size makes sure that the list from previous recursice call is added. Note if we keep this after the base case it wont add the list from last recurive call because it returns before adding.

        if(index >= nums.length)
            return;

        for(int i= index ; i<nums.length ; i++ ){
            list.add(nums[i]); // add an element to the list and send it for recursive call



            findsubset(nums , list , anslist ,  i + 1); // do i +1 because we already added element at position i so we need to add the next set of elements. Note dont do index+1 which recursively calling as this will lead to index and int i not being in sync . Also we start from i= index and not from 0 because we already say we are at temp = [2] and again now if we start from i=0 ,1,2 then we end up adding [2,1] which we dont want as it is same as [1,2] which we got when temp = [1] and we addes 2 to it.


            list.remove(list.size() - 1);



        }

        return;

    }
}

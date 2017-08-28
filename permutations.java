public class Solution {
    public List<List<Integer>> permute(int[] nums) {

        ArrayList<List<Integer>> anslist = new ArrayList<List<Integer>>();
        if(nums.length == 0)
            return anslist;
        ArrayList<Integer> temp = new ArrayList<Integer>();
        permute1(nums ,temp , anslist);

        return anslist;
    }


    public void permute1(int[] nums , ArrayList<Integer> temp , ArrayList<List<Integer>> anslist){

    if(nums.length == temp.size()){
        anslist.add(new ArrayList<Integer>(temp));
        return;
    }

    for(int i = 0; i < nums.length ; i++){ // Also we start always from i=0 because because to check all possible combinaiton , unlike powerset sums in which we start at i = start because in that case we want to add a number and unadd number to create list. Also in power set we dont want when temp = [2] we dont want to do again i=0,1,2 and add 0 to make temo [2,1] because we already have [1,2 ] that we got from adding temp = [1] with i=1 i.e 2 to make it [1,2]. But in our case [1,2] and [2,1 ] are different. So start from i=0
            if(temp.contains(nums[i]))// to avoid adding already added number . We dont want some thing like [1,2] and again add 1 or 2. So we check and add.
            continue;

        temp.add(nums[i]);

        permute1(nums , temp , anslist);


        temp.remove(temp.size() - 1 );// to undo changes that are done to the temp. We need to do this because unlike primitive types the non primitive types refernces are passed and used directly. So changes made down in recurison reflect even after coming back.

    }

}
}



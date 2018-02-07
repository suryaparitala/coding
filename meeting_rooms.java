/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public boolean canAttendMeetings(Interval[] intervals) {
        
        if(intervals.length == 0){
            return true;
        }
        Arrays.sort(intervals , new Comparator<Interval>(){ // sort the intervals
            
            public int compare(Interval a , Interval b){
                return a.start - b.start;
            }
            
        });
        
      //   System.out.println(intervals);
        for(int i = 0; i < intervals.length -1 ; i++){// we need not go to the last interval
            
            if(intervals[i].end > intervals[i+1].start){ // comapre if end of previous interval is more than start of next interval
                return false;
            }
            
            
        }
        return true;
        
    }
}
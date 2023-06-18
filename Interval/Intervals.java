import java.util.List;
import java.util.Collections;
import java.util.LinkedList;
     /**
     * Overlaping Intervals Scenario
     * 
     * a and b do not overlap  a------ b------
     * 
     * a and b overlap, b ends after a a------ 
     *                                    b------
     * 
     * a completely overlaps b a-----------
     *                            b------ 
     * 
     * b completely overlaps a both have the same start time
     *                         a------
     *                         b----------
     */

    

public class Intervals{
    
    public static class Interval{
        public int start;
        public int end;
        public Interval(int start,int end){
            this.start = start;
            this.end = end;
        }
    }
    // Merge Intervals
    /**
     * Question
     * Given a list of intervals, merge all the overlapping intervals and return 
     * a list of non-overlapping intervals.
     - Input interval {{2,6},{1,3},{8,10}}
     - Output interval {{1,6},{8,10}}
     */
    public List<Interval> merge(List<Interval> intervals){
        if(intervals.size()<2)return intervals;
        Collections.sort(intervals,(d1,d2)->{return d1.start - d2.start;});
        List<Interval> result= new LinkedList<>();
        Interval first = intervals.get(0);
        int start = first.start;
        int end = first.end;
        for(int i = 1; i<intervals.size(); i++){
            Interval current = intervals.get(i);
            if(current.start <= end){
                end = Math.max(end,current.end);
            }else{
                result.add(new Interval(start,end));
                start = current.start;
                end = current.end;
            }
        }
        result.add(new Interval(start,end));
        return result;
    }
    // Insert Interval
    /**
     * Question
     * Given a list of non-overlapping intervals sorted by their start time,insert a 
     * given interval at the valid position, merge all the overlapping intervals and 
     * return a list of mutually exclusive intervals.
     * Example
     * Input: {{1,3},{5,7},{8,10}}, new Interval {4,9}
     * Output: {{1,3},{4,10}}
     */


    public List<Interval> insert(List<Interval> intervals,Interval newInterval){
        List<Interval> result = new LinkedList<>();
        int i = 0;
        while(i < intervals.size() && intervals.get(i).end<newInterval.start){
            result.add(intervals.get(i));
            i++;
        }

        while(i < intervals.size() && intervals.get(i).start <= newInterval.end){
            newInterval.start = Math.min(newInterval.start,intervals.get(i).start);
            newInterval.end = Math.max(newInterval.end,intervals.get(i).end);
            i++;
        }
        result.add(newInterval);

        while(i<intervals.size()){
            result.add(intervals.get(i));
            i++;
        }
        return result;
    }

    public static void main(String[] args){
        
        List<Interval> intervals = new LinkedList<>();
        /*
        intervals.add(new Interval(1,3));
        intervals.add(new Interval(2,6));
        intervals.add(new Interval(7,9));
        List<Interval> result = new Intervals().merge(intervals);
        */

       intervals.add(new Interval(1,3));
       intervals.add(new Interval(5,7));
       intervals.add(new Interval(8,10));
       List<Interval> result = new Intervals().insert(intervals,new Interval(4,9));
        for(Interval i:result){
            System.out.print(i.start+", "+i.end+" ");
        }
    }
}
/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> merge(List<Interval> intervals) 
    {
        int size = intervals.size();
        List<Interval> result = new ArrayList<Interval>();
        
        if(size == 0)
            return result;
        // List转Array，方便排序
        Interval[] intervalArray = new Interval[size];
        for(int i = 0; i < size; i++)
            intervalArray[i] = intervals.get(i);
        // 按开始时间从前往后排序
        Arrays.sort(intervalArray, comp);
        
        // 归并区间
        Interval current = intervalArray[0];
        Interval next;
        for(int i = 1; i < size; i++)
        {
            next = intervalArray[i];
            if(current.end < next.start)
            {
                result.add(current);
                current = next;
            }
            else if(current.end < next.end)
                current.end = next.end;
        }
        // 最后一个区间
        result.add(new Interval(current.start, current.end));
        return result;
    }
    
    public static Comparator<Interval> comp = new Comparator<Interval>()
    {
        public int compare(Interval i1, Interval i2)
        {
            if(i1.start > i2.start)
                return 1;
            else if(i1.start < i2.start)
                return -1;
            else
                return 0;
        }
    };
}
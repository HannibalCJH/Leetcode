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
        if(size < 1)  
            return result;
        // 把ArrayList转成数组并把新区间加到数组最后，便于排序
        Interval[] intervals_array = new Interval[size];  
        for(int i=0;i<size;i++)  
            intervals_array[i] = intervals.get(i);
        // 根据开始时间排序
        Arrays.sort(intervals_array, comp);
        // 取第一个区间
        Interval current = intervals_array[0];  
        Interval next;  
        for(int i=1;i<size;i++)
        {  
            next = intervals_array[i];
            // 区间不重叠
            if(next.start > current.end)
            {  
            	result.add(new Interval(current.start, current.end));  
            	current = next;  
            }  
            else
            	// 合并区间
            	current.end = current.end > next.end ? current.end : next.end;   
        }
        // 最后一段区间，在之前的循环遍历中要不就是current=next，要不就是合并区间
        // 但是因为它本身是最后一段区间所以没有下一段区间可以比较，所以也就没有机会进入区间不重叠判断并加入结果集中
        result.add(new Interval(current.start, current.end));  
        return result;  
    }  
  
	// 比较器，按区间的开始时间从小到大排序
    public static Comparator<Interval> comp = new Comparator<Interval>() 
    {  
        public int compare(Interval inv1, Interval inv2) 
        {  
            if(inv1.start > inv2.start)  
                return 1;  
            else if(inv1.start == inv2.start)  
                return 0;  
            else  
                return -1;  
        }  
    }; 
}
/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class SummaryRanges {

    private TreeSet<Interval> intervalSet; 
	
	// 构造函数
	public SummaryRanges() 
	{
		intervalSet = new TreeSet<Interval>(new Comparator<Interval>() 
		{
			// 比较器，按左边界从小到大排序
			public int compare(Interval a, Interval b) 
			{
				return a.start - b.start;
			}
		});
	}
	
	public void addNum(int val) 
	{
		// 初始化为一个左右边界相等的区间
		Interval valInterval = new Interval(val, val);
		// 取得小于等于valInterval的最大区间，比较器是比较左边界大小
		Interval floor = intervalSet.floor(valInterval);
		if(floor != null) 
		{
			if(floor.end >= val)
				return;
			else if(floor.end + 1 == val) 
			{
				valInterval.start = floor.start;
				intervalSet.remove(floor);
			}
		}
		// 取得大于valInterval的最小区间，比较器是比较左边界大小
		Interval higher = intervalSet.higher(valInterval);
		if(higher != null && higher.start == val + 1) 
		{
			valInterval.end = higher.end;
			intervalSet.remove(higher);
		}
		intervalSet.add(valInterval);
	}
	
	public List<Interval> getIntervals() 
	{
		return Arrays.asList(intervalSet.toArray(new Interval[0]));
	}
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * List<Interval> param_2 = obj.getIntervals();
 */
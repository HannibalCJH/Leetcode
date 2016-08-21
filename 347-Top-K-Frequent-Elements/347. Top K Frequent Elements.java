public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) 
	{
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int num : nums)
            map.put(num, map.containsKey(num)? map.get(num) + 1 : 1);
        
        PriorityQueue<Map.Entry<Integer, Integer>> pque = new PriorityQueue<Map.Entry<Integer, Integer>>((o1, o2) -> o2.getValue() - o1.getValue());
        pque.addAll(map.entrySet());
        List<Integer> result = new ArrayList<Integer>();
        for(int i = 0; i < k; i++)
        	result.add(pque.poll().getKey());
        return result;
    }
}
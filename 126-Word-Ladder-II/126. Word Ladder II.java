public class Solution {
    public List<List<String>> findLadders(String start, String end, Set<String> dict) 
	{
        List<List<String>> ladders = new ArrayList<List<String>>();
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        Map<String, Integer> distance = new HashMap<String, Integer>();
        
        // 把初始和目标单词也加入词典中
        dict.add(start);
        dict.add(end);
 
        bfs(map, distance, start, end, dict);
        
        List<String> path = new ArrayList<String>();
        
        dfs(ladders, path, end, start, distance, map);

        return ladders;
    }

    private void dfs(List<List<String>> ladders, List<String> path, String cur, String start, 
    		Map<String, Integer> distance, Map<String, List<String>> map) 
    {
        path.add(cur);
        if(cur.equals(start)) 
        {
            Collections.reverse(path);
            ladders.add(new ArrayList<String>(path));
            Collections.reverse(path);
        } 
        else
            for(String next : map.get(cur)) 
                if(distance.containsKey(next) && distance.get(cur) == distance.get(next) + 1)
                    dfs(ladders, path, next, start, distance, map);      
        path.remove(path.size() - 1);
    }

    private void bfs(Map<String, List<String>> map, Map<String, Integer> distance,
            String start, String end, Set<String> dict) 
    {
        Queue<String> queue = new LinkedList<String>();
        queue.offer(start);
        distance.put(start, 0);
        for(String word : dict)
            map.put(word, new ArrayList<String>());
        
        while(!queue.isEmpty()) 
        {
            String cur = queue.poll();

            // 获取cur改变一个字母以后的单词表
            List<String> nextList = expand(cur, dict);
            // 对每个存在于cur改变一个字母以后的单词表中的单词进行判断
            for(String next : nextList) 
            {
            	// 把当前单词加入下一个单词的哈希表中
                map.get(next).add(cur);
                if(!distance.containsKey(next)) 
                {
                    distance.put(next, distance.get(cur) + 1);
                    queue.offer(next);
                }
            }
        }
    }

    // 搜索单词改变一个字母以后的单词
    List<String> expand(String cur, Set<String> dict) 
    {
        List<String> expansion = new ArrayList<String>();
        // 用26个字母对cur中的每个单词尝试改动，寻找在词典中存在的与给定cur差一个字母的单词
        for(int i = 0; i < cur.length(); i++)
            for(char ch = 'a'; ch <= 'z'; ch++) 
            {
                if(ch != cur.charAt(i)) 
                {
                    String expanded = cur.substring(0, i) + ch + cur.substring(i + 1);
                    if(dict.contains(expanded))
                        expansion.add(expanded);
                }
            }

        return expansion;
    }
}
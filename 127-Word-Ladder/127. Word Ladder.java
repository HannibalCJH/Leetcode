public class Solution {
    public int ladderLength(String start, String end, Set<String> dict) 
	{
        if(dict == null)
            return 0;

        if(start.equals(end))
            return 1;
        
        // 把初始和目标单词也加入词典
        dict.add(start);
        dict.add(end);

        HashSet<String> hash = new HashSet<String>();
        Queue<String> queue = new LinkedList<String>();
        queue.offer(start);
        hash.add(start);
        
        int length = 1;
        // 广度优先搜索，从初始单词作为根节点，每次遍历当前单词改变一个字母的单词
        while(!queue.isEmpty()) 
        {
            length++;
            int size = queue.size();
            for(int i = 0; i < size; i++) 
            {
                String word = queue.poll();
                // 对word改变一个字母的单词进行遍历
                for(String nextWord : getNextWords(word, dict)) 
                {
                	// 这个条件是判断nextWord是否已经在转变的序列中
                	// 比如从log->lot->got->get，当前word是got，它的nextWords集合里
                	// 既有向后变化的get也有之前的单词lot，这里是为了以防我们从got变回lot
                    if(hash.contains(nextWord))
                        continue;
                    if(nextWord.equals(end))
                        return length;
                    
                    hash.add(nextWord);
                    queue.offer(nextWord);
                }
            }
        }
        return 0;
    }

    // replace character of a string at given index to a given character
    // return a new string
    private String replace(String s, int index, char ch) 
    {
        char[] chars = s.toCharArray();
        chars[index] = ch;
        return new String(chars);
    }
    
    // get connections with given word.
    // for example, given word = 'hot', dict = {'hot', 'hit', 'hog'}
    // it will return ['hit', 'hog']
    // 搜索word改变一个字母以后的单词
    private ArrayList<String> getNextWords(String word, Set<String> dict) 
    {
        ArrayList<String> nextWords = new ArrayList<String>();
        // 用26个字母对word中的每个单词尝试改动，寻找在词典中存在的与给定word差一个字母的单词
        for(char ch = 'a'; ch <= 'z'; ch++) 
            for(int i = 0; i < word.length(); i++) 
            {
                if(ch == word.charAt(i))
                    continue;
                String nextWord = replace(word, i, ch);
                // 更改后的词在词典里存在加入数组
                if(dict.contains(nextWord))
                    nextWords.add(nextWord);
            }
        return nextWords;
    }
}
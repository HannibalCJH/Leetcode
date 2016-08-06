class TrieNode {
    private TrieNode[] links;
    private boolean isEnd;
    private final int R = 26;
    
    // Initialize your data structure here.
    public TrieNode() 
    {
        links = new TrieNode[R];    
    }
    
    public boolean containsKey(char key)
    {
        return links[key - 'a'] != null;
    }
    
    public TrieNode get(char key)
    {
        return links[key - 'a'];
    }
    
    public void put(char key, TrieNode node)
    {
        links[key - 'a'] = node;
    }
    
    public void setEnd()
    {
        isEnd = true;
    }
    
    public boolean isEnd()
    {
        return isEnd;
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) 
    {
        TrieNode node = root;
        for(int i = 0; i < word.length(); i++)
        {
            char cur = word.charAt(i);
            if(!node.containsKey(cur))
                node.put(cur, new TrieNode());
            node = node.get(cur);
        }
        node.setEnd();
    }

    public TrieNode findPrefix(String word)
    {
        TrieNode node = root;
        for(int i = 0; i < word.length(); i++)
        {
            char cur = word.charAt(i);
            if(node.containsKey(cur))
                node = node.get(cur);
            else
                return null;
        }
        return node;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) 
    {
        TrieNode node = findPrefix(word);
        return node != null && node.isEnd();
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) 
    {
        TrieNode node = findPrefix(prefix);
        return node != null;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");
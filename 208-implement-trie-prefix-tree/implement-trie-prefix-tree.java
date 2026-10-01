class TrieNode{
    HashMap<Character, TrieNode> map = new HashMap<>();
    boolean endOfWord = false;
}

class Trie {

    public TrieNode node;
    public Trie() {
        node = new TrieNode();
    }
    
    public void insert(String word) {

        char[] charArray = word.toCharArray();
        TrieNode cur = node;

        for(char c : charArray){
            if(!cur.map.containsKey(c)){
                cur.map.put(c, new TrieNode());
            } 
            cur = cur.map.get(c);
        }
        cur.endOfWord= true;
        
    }
    
    public boolean search(String word) {
        char[] charArray = word.toCharArray();
        TrieNode cur = node;
        for(char c : charArray){
            if(!cur.map.containsKey(c)){
                return false;
            }
            cur = cur.map.get(c);
        }

        if(!cur.endOfWord){
            return false;
        }
        
        return true;
    }
    
    public boolean startsWith(String prefix) {
        char[] charArray = prefix.toCharArray();
        TrieNode cur = node;
        for(char c : charArray){
            if(!cur.map.containsKey(c)){
                return false;
            }
            cur = cur.map.get(c);
        }

        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
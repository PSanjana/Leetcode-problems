class TrieNode{
    Map<Character, TrieNode> map = new HashMap<>();
    boolean endOfWord = false;
}


class WordDictionary {
    public TrieNode root ;

    public WordDictionary() {

        root = new TrieNode();
    }
    
    public void addWord(String word) {

        char[] charArray = word.toCharArray();
        TrieNode cur = root;
        for(char c : charArray){
            cur.map.putIfAbsent(c, new TrieNode());
            cur = cur.map.get(c);
        }
        cur.endOfWord = true;
        
    }
    
    public boolean search(String word) {

        return dfs(0, root, word);
        
    }

    private boolean dfs(int i, TrieNode node, String word){

        TrieNode cur = node;
        for(int j =i; j<word.length();j++){
            char c = word.charAt(j);

            if(c == '.'){
                for(TrieNode nodeValue :cur.map.values()){
                    if( dfs(j+1, nodeValue, word)){
                        return true;
                    }
                }
                return false;
            } else{
                if(!cur.map.containsKey(c)){
                    return false;
                }
                cur = cur.map.get(c);
            }
        }
        if(!cur.endOfWord){
            return false;
        }
        return true;

    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
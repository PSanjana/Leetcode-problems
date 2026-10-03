class TrieNode{
    public HashMap<Character, TrieNode> children;
    public boolean endOfWord = false;

    public TrieNode(){
        children = new HashMap<>();
    }
}

class Solution {
    public TrieNode root;


    public void addWord(String word){
        TrieNode cur = root;
        char[] chararray = word.toCharArray();
        for(char c : chararray){
            cur.children.putIfAbsent(c, new TrieNode());
            cur = cur.children.get(c);
        }
        cur.endOfWord = true;

    }

    public int ROWS,COLS;
    public Set<Pair<Integer,Integer>> path;
    public Set<String> wordsFound;
    public List<String> findWords(char[][] board, String[] words) {
        root = new TrieNode();

        for(String word: words){
            addWord(word);
        }
        ROWS = board.length; COLS = board[0].length;
        path = new HashSet<>();
        wordsFound = new HashSet<>();

        for(int i =0; i<ROWS;i++){
            for(int j =0; j<COLS;j++){
                dfs(board, "",j,i,root);
            }
        }

        return new ArrayList<>(wordsFound);

        
    }

    public void dfs(char[][] board, String word, int c, int r, TrieNode node){

        
        Pair<Integer,Integer> index = new Pair<>(r,c);

        if(c<0 || r<0 || r>ROWS-1 || c>COLS-1 || !node.children.containsKey(board[r][c]) || path.contains(index)){
            return; 
        }

        word+=board[r][c];

        node = node.children.get(board[r][c]);

        if(node.endOfWord){
            wordsFound.add(word);
        }

        path.add(index);

        dfs(board, word, c+1, r, node);
        dfs(board, word, c-1, r, node);
        dfs(board, word, c, r+1, node);
        dfs(board, word, c, r-1, node);

        path.remove(index);

    } 
}
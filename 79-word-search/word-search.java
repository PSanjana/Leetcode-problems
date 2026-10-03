class Solution {

    public int ROWS, COLS;
    Set<Pair<Integer, Integer>> path;
    public boolean exist(char[][] board, String word) {

        ROWS = board.length;
        COLS = board[0].length;
        path = new HashSet<>();

        for(int i=0;i<ROWS;i++){
            for(int j = 0; j<COLS;j++){
                if(dfs(board, word, 0, i, j)){
                    return true;
                }
            }
        }

        return false;
        
    }

    private boolean dfs(char[][] board, String word, int i, int r, int c){

        

        if(i == word.length()){
            return true;
        }

        Pair<Integer, Integer> index = new Pair<>(r,c);
        if(r < 0 || c<0 || r> ROWS-1 || c>COLS-1 || board[r][c] != word.charAt(i) || path.contains(index)){
            return false;
        }

        path.add(index);

        boolean result = dfs(board, word, i+1, r+1, c) || dfs(board, word, i+1, r-1, c) || dfs(board, word, i+1, r, c+1) || dfs(board, word, i+1, r, c-1);

        path.remove(index);

        return result;
    }
}
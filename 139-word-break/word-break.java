class Solution {
    Map<Integer, Boolean> map;
    public boolean wordBreak(String s, List<String> wordDict) {
        
        //top down approach
        map = new HashMap<>();
        map.put(s.length(), true);
        return dfs(s, wordDict,0);


    }

    private boolean dfs(String s, List<String> wordDict, int i){

        if(map.containsKey(i)){
            return map.get(i);
        }

        for(String word: wordDict){
            System.out.println(word);
            boolean c = false;
            // System.out.println(s.substring(i, i+word.length()));
            if(i+word.length()-1<s.length() && s.substring(i, i+word.length()).equals(word)){
                 c = dfs(s, wordDict, i+word.length());
            }
            if(c){
                return true;
            }
        }
        map.put(i, false);
        return false;
    }
}
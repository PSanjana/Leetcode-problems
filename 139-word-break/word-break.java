class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {

        boolean dp[] = new boolean[s.length()+1];
        dp[s.length()] = true;


        for(int i = s.length()-1; i>=0 ;i--){
            // System.out.println(i);
            for(String word : wordDict){
                // System.out.println(word);
                if(i+word.length()-1 < s.length() && s.substring(i, i+word.length()).equals(word)){
                    dp[i] = dp[i + word.length()];
                    
                }
                if(dp[i]){
                    break;
                }
                
            }

        }
        
        return dp[0];
    }
}
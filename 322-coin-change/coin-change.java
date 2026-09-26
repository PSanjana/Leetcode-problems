class Solution {

    private Map<Integer,Integer> map = new HashMap<>();//store amt,min ways to form amt
    public int coinChange(int[] coins, int amount) {


        int res = dfs(coins, amount);
        return res == Integer.MAX_VALUE? -1 : res;

        
    }

    private int dfs(int[] coins, int amount){
        if(amount == 0){
            return 0;
        }
        if(map.containsKey(amount)){
            return map.get(amount);
        }
        int result = Integer.MAX_VALUE;
        for(int coin: coins){
            if(amount-coin >= 0){
                int res = dfs(coins, amount-coin);
                if(res != Integer.MAX_VALUE){
                    result = Math.min(1+res, result);
                }
            }
            
        }
        map.put(amount, result);
        return result;
    }
}
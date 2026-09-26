class Solution {
    public int numDecodings(String s) {

        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(s.length(), 1);
        return dfs(s, 0, map);
    }

    private int dfs(String s, int i, HashMap<Integer,Integer> map){
        if(map.keySet().contains(i)){
            return map.get(i);
        }

        if(s.charAt(i) == '0'){
            return 0;
        }

        int result = dfs(s,i+1,map);

        if(i+1<s.length() && (s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i+1) < '7'))){
            result+= dfs(s, i+2,map);
        }

        map.put(i,result);
        return result;
    }
}
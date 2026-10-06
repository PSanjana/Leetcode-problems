class Solution {
    public long numberOfWays(String s) {

        long totalZeros = 0, totalOnes =0, totalWays=0;

        for(char c: s.toCharArray()){
            if(c=='0'){
                totalZeros++;
            } else{
                totalOnes++;
            }
        }

        long leftZeros =0 , leftOnes =0;

        for(char c : s.toCharArray()){
            if(c =='0'){

                long rightOnes = totalOnes-leftOnes;

                totalWays +=rightOnes*leftOnes;

                leftZeros++;
            } else{
                long rightZeros = totalZeros-leftZeros;

                totalWays +=rightZeros*leftZeros;

                leftOnes++;
            }
        }

        return totalWays;
        
    }
}
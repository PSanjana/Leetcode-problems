class Solution {
    public int maxProduct(int[] nums) {
        int currMax = 1, currMin = 1, res=nums[0];
        for(int num: nums){
            int temp = currMax*num;
            currMax = Math.max(currMax*num, Math.max(currMin*num, num));
            currMin = Math.min(currMin*num, Math.min(temp, num));
            res = Math.max(res, currMax);
        }
        return res;
        
    }
}
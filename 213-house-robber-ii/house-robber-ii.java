class Solution {
    public int rob(int[] nums) {
        

        return Math.max(Math.max(robHelper(Arrays.copyOfRange(nums, 1, nums.length)), robHelper(Arrays.copyOfRange(nums, 0, nums.length-1))), nums[0]);
        
    }
     
    private int robHelper(int[] nums){
        int rob1 =0, rob2 =0;

        for(int i =0;i<nums.length;i++){

            int temp = Math.max(rob1+nums[i], rob2);
            rob1 = rob2;
            rob2 = temp;

        }

        return rob2;
    }
}
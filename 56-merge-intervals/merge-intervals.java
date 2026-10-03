class Solution {
    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (a,b) ->Integer.compare(a[0],b[0]));

        List<int[]> output = new ArrayList<>();
        output.add(intervals[0]);

        for(int i =1;i<intervals.length;i++){
            int prevEnd = output.get(output.size()-1)[1];
            int currentStart = intervals[i][0];

            if(currentStart<=prevEnd){
                int[] newInterval = new int[]{output.get(output.size()-1)[0], Math.max(prevEnd, intervals[i][1])};
                output.remove(output.size()-1);
                output.add(newInterval);
            } else{
                output.add(intervals[i]);
            }
        }

        return output.toArray(new int[output.size()][]);
        
    }
}
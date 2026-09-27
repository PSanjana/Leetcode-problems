class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> result = new ArrayList<>();

        for (int[] interval : intervals) {

            // Case 1:
            // current interval is before newInterval
            if (interval[1] < newInterval[0]) {

                result.add(interval);

            }

            // Case 2:
            // current interval is after newInterval
            else if (interval[0] > newInterval[1]) {

                result.add(newInterval);

                // newInterval is now this interval
                // so remaining intervals can be processed normally
                newInterval = interval;

            }

            // Case 3:
            // overlap
            else {

                newInterval[0] =
                    Math.min(newInterval[0], interval[0]);

                newInterval[1] =
                    Math.max(newInterval[1], interval[1]);
            }
        }

        result.add(newInterval);

        return result.toArray(new int[result.size()][]);
    }
}
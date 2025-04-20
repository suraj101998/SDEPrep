package CodingInterview;

import java.util.Arrays;
import java.util.List;

/*
 * Amazon
 * 
 * Problem Recap
We are given n retailers, each with an operating region defined by [regionStart[i], regionEnd[i]].
We need to find the minimum number of retailers to relocate such that:
There exists at least one retailer whose region intersects (touches or overlaps) with all other 
remaining retailers.


Approach(Efficient Greedy Method):
For any given interval to intersect all others:
Its [start, end] must overlap with the intersection of all other intervals.

The intersection of all other intervals is:
maxStart = max of all regionStart values
minEnd = min of all regionEnd values

If there's any retailer whose range includes this [maxStart, minEnd], it means:
That retailer already intersects all others.
So, no relocation needed.
If no such interval exists, we try:
For each retailer, remove them and compute the intersection of the rest.
Then check if any of the remaining retailers match that intersection.
The minimum number of removals = n - max number of overlapping intervals.

Time and Space Complexity
Time: O(N log N) due to sorting and binary search.
Space: O(N) for auxiliary arrays.
 */
public class minRetailers {
    public static int minRetailersToRelocate(List<Integer> regionStart, List<Integer> regionEnd) {
        int n = regionStart.size();
        int[][] intervals = new int[n][2];

        for (int i = 0; i < n; i++) {
            intervals[i][0] = regionStart.get(i);
            intervals[i][1] = regionEnd.get(i);
        }

        // Sort intervals by start
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int[] sortedStarts = new int[n];
        for (int i = 0; i < n; i++) {
            sortedStarts[i] = intervals[i][0];
        }

        // Sort ends
        int[] sortedEnds = new int[n];
        for (int i = 0; i < n; i++) {
            sortedEnds[i] = intervals[i][1];
        }
        Arrays.sort(sortedEnds);

        // We'll try to find the max number of intervals overlapping at any point
        // For each interval, we check how many other intervals intersect with it
        int maxOverlap = 0;
        for (int i = 0; i < n; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];

            // Number of intervals whose start <= end
            int left = upperBound(sortedStarts, end);
            // Number of intervals whose end < start
            int right = lowerBound(sortedEnds, start);

            int overlap = left - right;
            maxOverlap = Math.max(maxOverlap, overlap);
        }

        return n - maxOverlap;
    }

    // Returns index of first element > target
    private static int upperBound(int[] arr, int target) {
        int lo = 0, hi = arr.length;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (arr[mid] <= target) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }

    // Returns index of first element >= target
    private static int lowerBound(int[] arr, int target) {
        int lo = 0, hi = arr.length;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (arr[mid] < target) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }
}

package DSA.Advanced.InterviewProblems;

import java.util.ArrayList;
import java.util.Collections;

/*
 * Problem Description

You are given an array B of meeting time intervals where each interval is represented as [start, end] (with start < end). You need to find the minimum number of conference rooms required to host all the meetings.


Problem Constraints

1 <= B.length <= 104
0 <= start < end <= 106


Input Format

The first line contains an integer n, the number of meetings.
The next n lines each contain two space-separated integers start and end representing the start and end times of the meetings.


Output Format

Output a single integer representing the minimum number of conference rooms required.


Example Input

Input 1:
A = 3
B = [ [0, 30],
      [5, 10],
      [15, 20] ]
Input 2:
A = 1
B = [ [0, 1] ]


Example Output

Output 1:
2
Output 2:
1


Example Explanation

Explanation 1:
We need two rooms: 

Room 1: [0, 30] 

Room 2: [5, 10], [15, 20]
Explanation 2:
Since there is only one meeting, we need one room
 */
public class meetingRooms2 {
    public int solve(int A, ArrayList<ArrayList<Integer>> B) {
        ArrayList<Integer> startTimes = new ArrayList<>();
        ArrayList<Integer> endTimes = new ArrayList<>();
        for (ArrayList<Integer> interval : B) {
            startTimes.add(interval.get(0));
            endTimes.add(interval.get(1));
        }
        Collections.sort(startTimes);
        Collections.sort(endTimes);
        int roomsRequired = 0, maxRooms = 0;
        int startPointer = 0, endPointer = 0;
        while (startPointer < A) {
            if (startTimes.get(startPointer) < endTimes.get(endPointer)) {
                roomsRequired++;
                startPointer++;
            } else {
                roomsRequired--;
                endPointer++;
            }
            maxRooms = Math.max(maxRooms, roomsRequired);
        }
        return maxRooms;
    }    
}

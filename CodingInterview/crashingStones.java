package CodingInterview;
/*
 * Crashing Stones problem, which involves repeatedly combining the two heaviest stones until only one or no stones are left, as described below:
You are given a list of stones where each stone has a positive integer weight. At each step, the two heaviest stones are selected:
If their weights are equal, both stones are destroyed.
If their weights differ, the heavier stone is reduced by the weight of the lighter stone, and the result is added back to the list.
Repeat this process until no more than one stone remains.
Your task is to determine the weight of the last remaining stone (or 0 if no stones remain).
 */
import java.util.List;
import java.util.PriorityQueue;
import java.util.Collections;

public class crashingStones {

    // Function to calculate the weight of the last remaining stone
    public static int lastStoneWeight(List<Integer> stones) {
        // Use a max heap to store the stone weights
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        // Add all stones to the max heap
        maxHeap.addAll(stones);

        // Simulate the process of crashing stones
        while (maxHeap.size() > 1) {
            int stone1 = maxHeap.poll(); // Heaviest stone
            int stone2 = maxHeap.poll(); // Second heaviest stone

            // If they are not equal, push the difference back into the heap
            if (stone1 != stone2) {
                maxHeap.add(stone1 - stone2);
            }
        }

        // Return the weight of the last stone, or 0 if no stones remain
        return maxHeap.isEmpty() ? 0 : maxHeap.poll();
    }

    // Main method to test the function
    public static void main(String[] args) {
        List<Integer> stones = List.of(2, 7, 4, 1, 8, 1);
        System.out.println("Last Stone Weight: " + lastStoneWeight(stones));
    }
}

/*
 * Explanation:
Approach:
Use a max heap (priority queue with reverse order) to store the weights of the stones.
Add all stone weights from the List into the max heap.
Repeatedly remove the two heaviest stones:
If their weights are equal, both stones are destroyed.
If their weights are not equal, insert the difference back into the heap.
Stop when there is only one or no stone left in the heap.

Input and Output:
Input: A List of integers representing stone weights.
Output: The weight of the last remaining stone, or 0 if no stones remain.

Example:
Input: stones = List.of(2, 7, 4, 1, 8, 1)

Execution:
Insert all stones into the heap: [8, 7, 4, 2, 1, 1]

Remove 8 and 7: 
8−7=1, insert 1 back: [4, 2, 1, 1, 1]

Remove 4 and 2: 
4−2=2, insert 2 back: [2, 1, 1, 1]

Remove 2 and 1: 
2−1=1, insert 1 back: [1, 1, 1]
Remove 1 and 1: Both are destroyed: [1]
Only 1 remains.
Output: 1

Complexity Analysis:
Time Complexity:
Inserting into and removing from the heap takes O(logn).

Since stones are processed in pairs, there are n−1 iterations.
Total: O(nlogn).

Space Complexity:
The heap requires O(n) space to store the stones.
Total: O(n).
*/
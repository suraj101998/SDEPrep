package CodingInterview;
/*

Problem Recap:
You're allowed to move any character to the end of the string. 
You want to transform a string into its reverse using the minimum number of such operations.

Key Insight:
If you're allowed to move any character to the end, then:

The minimum operations required to convert image to reverse(image) is:
length of image - length of longest prefix of reverse(image) that matches any suffix of image in order.

But the trick is: the characters must match in order, not necessarily contiguous.
So Z-algorithm is not enough here — we must match in order but not necessarily continuously.


 * Approach (Greedy 2-Pointer Matching)
Idea:
Let image = S
Let reversed = reverse(S)

Use 2 pointers:
i for S
j for reversed
Move i through S, and whenever S[i] == reversed[j], increase j.
At the end, j will tell how many characters of the reversed string you matched in order.

Time & Space Complexity:
Time: O(N)
Space: O(N) (for reversed string, or O(1) if done with pointers)
 */
public class findMinimumOperations {
    public static int findMinOperations(String image) {
        String reversed = new StringBuilder(image).reverse().toString();
        int i = 0, j = 0;

        while (i < image.length() && j < reversed.length()) {
            if (image.charAt(i) == reversed.charAt(j)) {
                j++;
            }
            i++;
        }

        return image.length() - j;
    }

    public static void main(String[] args) {
        String image = "00110101";
        System.out.println(findMinOperations(image));  // Output: 3
    }

}

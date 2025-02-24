package DSA.Advanced.BinarySearch;

/* The College library has N books. The ith book has A[i] number of pages.
You have to allocate books to B number of students so that the maximum number of pages 
allocated to a student is minimum. A book will be allocated to exactly one student.
Each student has to be allocated at least one book. Allotment should be in contiguous order, 
for example: A student cannot be allocated book 1 and book 3, skipping book 2.
Calculate and return that minimum possible number.
NOTE: Return -1 if a valid assignment is not possible.

Problem Constraints
1 <= N <= 105
1 <= A[i], B <= 105

Input Format
The first argument given is the integer array A.
The second argument given is the integer B.

Output Format
Return that minimum possible number.

Example Input
Input 1:
A = [12, 34, 67, 90]
B = 2
Input 2:
A = [12, 15, 78] 
B = 4

Example Output
Output 1:
113
Output 2:
-1

Example Explanation

Explanation 1:
There are two students. Books can be distributed in following fashion : 
1)  [12] and [34, 67, 90]
    Max number of pages is allocated to student 2 with 34 + 67 + 90 = 191 pages
2)  [12, 34] and [67, 90]
    Max number of pages is allocated to student 2 with 67 + 90 = 157 pages 
3)  [12, 34, 67] and [90]
    Max number of pages is allocated to student 1 with 12 + 34 + 67 = 113 pages
    Of the 3 cases, Option 3 has the minimum pages = 113.

Explanation 2:
Each student has to be allocated at least one book.  
But the Total number of books is less than the number of students.
Thus each student cannot be allocated to atleast one book.

Therefore, the result is -1.
*/


/*
 * Approach:
1. Check Feasibility:
    If the number of students (B) is greater than the number of books (A.length), 
    return -1 since allocation is not possible.
2. Set Search Range:
        Use the maximum number of pages in a book (getMax(A)) as the lower bound (l).
        Use the total pages (getSum(A)) as the upper bound (r).
3. Binary Search:
        For each midpoint (mid) in the range [l, r], check if it is possible to allocate books such that 
        the maximum pages allocated to any student does not exceed mid (isValid function).
        If valid, update ans to mid and move the search to minimize mid (r = mid - 1). 
        Otherwise, increase mid (l = mid + 1).
4. Validate Allocation:
        In isValid, iterate through the books and allocate pages to students 
        while ensuring the page sum per student does not exceed mid.
        If the number of students required exceeds B, return false.
5. Return Result:
        The smallest mid value for which allocation is valid is returned as ans.

TC = O(N log S)
    Calculating getMax and getSum takes O(N).
    Binary search iterates over log(S) (where S is the sum of all pages). 
    Each feasibility check (isValid) takes O(N).

SC = O(1)
 */
public class allocateBooks {
    public static int books(int[] A, int B) {
        int n = A.length;
        if (B > n) {
            return -1;
        }
        int l = getMax(A);
        int r = getSum(A);
        int ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (isValid(A, B, mid)) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return ans;
    }

    private static boolean isValid(int[] A, int B, int mid) {
        int studentCount = 1;
        int currentPageSum = 0;
        for (int i = 0; i < A.length; i++) {
            int pages = A[i];
            if (currentPageSum + pages > mid) {
                studentCount++;
                currentPageSum = pages;
                if (studentCount > B) {
                    return false;
                }
            } else {
                currentPageSum += pages;
            }
        }
        return true;
    }

    private static int getMax(int[] A) {
        int max = A[0];
        for (int i = 0; i < A.length; i++) {
            int pages = A[i];
            if (pages > max) {
                max = pages;
            }
        }
        return max;
    }

    private static int getSum(int[] A) {
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            int pages = A[i];
            sum += pages;
        }
        return sum;
    }
    
    public static void main(String[] args){
        int[] A= {12, 34, 67, 90};
        int B = 2;
        int result = books(A,B);
        System.out.println("allocate Books: "+result);
    }
}

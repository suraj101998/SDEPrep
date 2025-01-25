package Theory;

import java.util.ArrayList;
import java.util.Comparator;

public class secondmaxThroughStreamAPI {
    public int solve(ArrayList<Integer> A) {
        if (A.size() < 2) {
            return -1; // Return -1 if there are not enough elements
        }

        return A.stream()
                .distinct() // Remove duplicates to ensure unique values
                .sorted(Comparator.reverseOrder()) // Sort in descending order
                .skip(1) // Skip the first (maximum) element
                .findFirst() // Get the second element if it exists
                .orElse(-1); // Return -1 if no second maximum exists
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(4);
        list.add(4);
        list.add(2);

        secondmaxThroughStreamAPI sol = new secondmaxThroughStreamAPI();
        int secondMax = sol.solve(list);
        System.out.println("Second maximum element: " + secondMax);
    }
}

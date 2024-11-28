package CodingInterview;
/*
 * Equal
 * Rotate the string by 180 degree and check if it is same or not
 * input: 181
 * output: same
 * 
 */
public class rotateStringBy180degree {
    public static void main(String[] args) {
        String input = "619"; // Example input
        if (isSameWhenRotatedBy180(input)) {
            System.out.println("The string is the same when rotated by 180 degrees.");
        } else {
            System.out.println("The string is not the same when rotated by 180 degrees.");
        }
    }

    public static boolean isSameWhenRotatedBy180(String str) {
        // Define characters that are valid when rotated 180 degrees
        String validChars = "01869";
        // Create a rotated version of the string
        StringBuilder rotated = new StringBuilder();

        for (int i = str.length() - 1; i >= 0; i--) {
            char c = str.charAt(i);
            if (!validChars.contains(String.valueOf(c))) {
                return false; // Invalid character found
            }
            // Rotate the character
            switch (c) {
                case '6':
                    rotated.append('9');
                    break;
                case '9':
                    rotated.append('6');
                    break;
                default:
                    rotated.append(c);
            }
        }

        // Check if the rotated string matches the original
        return str.equals(rotated.toString());
    }
}

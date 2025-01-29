package CodingInterview;
/*
 * Ford
 * Given a String. count the No of characters and print it like this.
 * input: "Aaabbc"
 * Output: A1a2b2c1
 */
public class runLengthEncoding {
    public class RunLengthEncoding {

        public static String encode(String input) {
            if (input == null || input.length() == 0) {
                return "";
            }   
            StringBuilder encoded = new StringBuilder();
            int count = 1;
    
            for (int i = 1; i < input.length(); i++) {
                if (input.charAt(i) == input.charAt(i - 1)) {
                    count++;
                } else {
                    encoded.append(input.charAt(i - 1)).append(count);
                    count = 1;
                }
            }
    
            // Append the last character and its count
            encoded.append(input.charAt(input.length() - 1)).append(count); 
            return encoded.toString();
        }
        public static void main(String[] args) {
            String input = "Aaabbc";
            String result = encode(input);
            System.out.println(result);  // Output: A1a2b2c1
        }
    }
    
    
}

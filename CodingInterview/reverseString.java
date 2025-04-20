package CodingInterview;
/* Cotiviti
 * Reverse a string not by using any inbuilt functions
TC = O(N/2)
SC = O(1)
 */
public class reverseString {
    public static void main(String[] args){
        String input = "Cotiviti";
        System.out.println("ans: "+reverse(input));
    }

    public static String reverse(String input){
        char[] chars = input.toCharArray();
        int start = 0;
        int end = chars.length -1;

        while(start<end){
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
        return new String(chars);
    }
}

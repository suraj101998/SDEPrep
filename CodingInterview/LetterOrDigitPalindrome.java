package CodingInterview;
public class LetterOrDigitPalindrome {
    public static void main(String[] args) {
        String input = "ab2f_g@f2ba";
        boolean output  = isPalindrome(input);
        System.out.println("ans: "+ output);
    }
  
    public static boolean isPalindrome(String input){
      StringBuilder filteredString = new StringBuilder();
      for(char ch: input.toCharArray()){
        if(Character.isLetterOrDigit(ch)){
          filteredString.append(Character.toLowerCase(ch));
        }
      }
      String filtered = filteredString.toString();
      int left = 0, right = filtered.length() -1;
      while(left<right){
        if(filtered.charAt(left) != filtered.charAt(right)){
          return false;
        }
        left++;
        right--;
      }
      return true;
    }
}

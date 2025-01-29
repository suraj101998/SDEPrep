package CodingInterview;
/* diebold Nixdorf
given with a String "AABBCDEFFFYHG". print all the unique elements and duplicate count.

*/

public class countDuplicatedString {
    public static int duplicates(String str){
      int count=0;
      StringBuilder uniqueString = new StringBuilder();
      for (int i=0; i<str.length(); i++){
        uniqueString.append(str.charAt(i));
        while(i < str.length()-1 && str.charAt(i)==str.charAt(i+1)){
          count++;
          i++;
        }
      }
      System.out.println(uniqueString.toString());
      return count;
    }
    
    public static void main (String[] args){
      String str = "AABBCDEFFFYHG";
      System.out.println(duplicates(str));
    }
}
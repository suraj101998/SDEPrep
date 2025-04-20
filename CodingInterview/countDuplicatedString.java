package CodingInterview;
/* diebold Nixdorf
given with a String "AABBCDEFFFYHG". print all the unique elements and duplicate count.

*/

import java.util.HashMap;
import java.util.Map;

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

    //find duplicate characters
    public static void findDuplicateCharacters(String str) {
        Map<Character, Integer> map = new HashMap<>();

        for (char ch : str.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        System.out.println("Duplicate characters are: ");
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println(entry.getKey() + " => " + entry.getValue());
            }
        }
    }
    public static void main (String[] args){
      String str = "AABBCDEFFFYHG";
      System.out.println(duplicates(str));
      findDuplicateCharacters(str);
    }
}
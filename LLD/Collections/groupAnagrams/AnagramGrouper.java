package LLD.Collections.groupAnagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/*
 * Group Anagrams(Assignment)
Problem Statement
You are given an array of strings, you need to group the anagrams together and store them in a list of strings. Write a function in Java that takes an array of strings as input and returns a List<List<String>> where each inner list contains the strings that are grouped together i.e. the anagrams.

Note: A string s2 is called an anagram of string s1, if the frequency of each character in the string s2 is equal to the frequency of each character in the string s1.

Example
Let us consider the array of strings given as input be ["eat", "tea", "tan"]. Now, if we look at the array we can see that "eat" and "tea" are anagrams because in "eat" the characters are 'e','a' & 't' having frequency of 1 each. Similarly, "tea" also has 'a','e' & 't' characters only and their frequency is also 1 each. Since all the characters have the same frequency and all the characters are common in both strings hence they are anagrams.

We group these anagrams together in a list which will look like ["eat","tea"]. Since "tan" has no anagram therefore the list for anagrams of "tan" has only one string (which is "tan" itself).

Instructions
Implement the groupAnagrams method inside the AnagramGrouper class.
The input array of strings can also be empty or null. In that case you need to return an empty <List<List<String>>.
Hint: Use LinkedHashmap to maintain the ordering of strings, same as input. array of strings as input and returns a List<List<String>> where each inner list contains the strings that are grouped together i.e. the anagrams.
Note: A string s2 is called an anagram of string s1, if the frequency of each character in the string s2 is equal to the frequency of each character in the string s1.

Instructions
Implement the groupAnagrams method inside the AnagramGrouper class.
The input array of strings can also be empty or null. In that case you need to return an empty <List<List<String>>.
Hint: Use LinkedHashmap to maintain the ordering of strings, same as input.
 */
public class AnagramGrouper {
      public static List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null || strs.length==0){
            return new ArrayList<>();
        }
        Map<String, List<String>> map = new LinkedHashMap<>();
        for(String word : strs){
            char[] charArray = word.toCharArray();
            Arrays.sort(charArray);
            String sortedWord = new String(charArray);
            map.putIfAbsent(sortedWord, new ArrayList<>());
            map.get(sortedWord).add(word);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String strs[] = {"eat", "tea", "tan"};
        List<List<String>> result = groupAnagrams(strs);

        for(List<String> ans:result){
            System.out.println(ans);
        }
    }  
}

package Streams;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class findVowels {
    public static void main (String[] args){
        String input = "program";
        Set<Character> vowels = Set.of('a','e','i','o','u','A','E','I','O','U');
        List<Character> vowelList = input.chars().mapToObj(c -> (char) c).filter(vowels :: contains).collect(Collectors.toList());
        System.out.println("Vowels: " +vowelList);
        System.out.println("No. of Vowels: " +vowelList.size());
    }
}
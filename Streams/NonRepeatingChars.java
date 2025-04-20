package Streams;
import java.util.*;
import java.util.stream.*;
public class NonRepeatingChars {
    public static void main(String[] args){
        String input = "ABASDSD";
        String result = input.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(c -> c, 
        LinkedHashMap :: new, Collectors.counting())).entrySet().stream().filter(e -> e.getValue() > 1)
        .map(e -> e.getKey().toString()).collect(Collectors.joining());

        System.out.println(result);;
    }
}

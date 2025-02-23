/*
 * You are given a stream of integers. 
 * Please use the filter method to return all odd numbers in the form of a list. Use only stream methods.
 */
package LLD.StreamsAndLambdas;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class getOdd {
static List<Integer> getOdd(Stream<Integer> stream){
    // write code here
    return stream.filter(num -> num % 2 != 0).collect(Collectors.toList());
}
     
}
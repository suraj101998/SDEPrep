package LLD.StreamsAndLambdas;

import java.util.stream.Stream;

/*
 * You are given a stream of integers. 
 * Please use the allMatch method to confirm if all numbers in the stream are even. Use only stream methods.
 */
public class allEven {
    static boolean areAllEven(Stream<Integer> stream){
        return stream.allMatch(num -> num%2 ==0);
    }
}

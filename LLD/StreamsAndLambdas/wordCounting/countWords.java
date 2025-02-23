package LLD.StreamsAndLambdas.wordCounting;

import java.util.Arrays;
import java.util.List;

/*
 * Count Unique Words
Problem Statement
Given a list of strings representing sentences, write a Java method called countWords that performs the following operations using Java streams:

Filter out sentences that don't contain the word "Java".

Map each filtered sentences to a list of unique words (remove duplicates).

Flatten the list of unique words into a single stream of words. Hint: Use flatMap(Arrays::stream) Method

Count the total number of remaining words.

Return the count of remaining words.

Instructions
Implement the countWords method inside the WordCounter class
You need to use Java Streams for doing the operation.
 */
public class countWords {
        public static long countUniqueWords(List<String> sentences) {
        return sentences.stream()
        .filter(sentence -> !sentence.contains("Java"))
        .map(sentence -> sentence.split("\\s+"))
        .flatMap(Arrays::stream)
        .distinct()
        .count();
    }

    public static void main(String[] args) {
        List<String> sentences = Arrays.asList(
                "Python is a programming language.",
                "JavaScript is used for web development.",
                "Ruby is known for its simplicity."
        );

        long wordCount = countWords.countUniqueWords(sentences);
        System.out.println(wordCount);
    }
}

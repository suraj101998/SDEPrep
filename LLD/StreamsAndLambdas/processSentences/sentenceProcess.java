package LLD.StreamsAndLambdas.processSentences;

import java.util.Arrays;
import java.util.List;

/*
 * Process Sentences
Problem Statement
Given a list of strings representing sentences, write a Java method called processSentences that performs the following operations using Java streams:

Filter out sentences that contain the word "Java".
Map each filtered sentences to its length.
Find the average length of the sentences.
Convert the average length to an integer by rounding down.
Return the rounded average length.
Instructions
Implement the processSentences method inside the SentenceProcessor class
You need to use Java Streams for doing the operation.
 */
public class sentenceProcess {
    public static int processSentences(List<String> sentences) {
        //code here
        return (int) sentences.stream()
        .filter(sentence -> sentence.contains("Java"))
        .mapToInt(String::length)
        .average()
        .orElse(0);
    }

    public static void main(String[] args) {
        List<String> sentences = Arrays.asList(
                "Java is a programming language.",
                "Python is also a good language.",
                "Java stream processing is powerful.",
                "C++ is not as popular as Java."
        );

        int averageLength = sentenceProcess.processSentences(sentences);
        System.out.println(averageLength);

        sentences = Arrays.asList(
                "Python is a programming language.",
                "JS is used for web development.",
                "Ruby is known for its simplicity.",
                "java is good"
        );

        averageLength = sentenceProcess.processSentences(sentences);
        System.out.println(averageLength);
    }
}

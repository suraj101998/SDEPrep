package LLD.executors_and_callables.Threads.callable2;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.Callable;

public class Client {
    public static Node buildTree(Scanner scanner) {
        int value = scanner.nextInt();
        if (value == -1) {
            return null;
        }

        Node node = new Node(value);
        node.left = buildTree(scanner);
        node.right = buildTree(scanner);
        return node;
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Node root = buildTree(scanner);
        scanner.close();

        ExecutorService executor = Executors.newFixedThreadPool(4);
        TreeSizeCalculator calculator = new TreeSizeCalculator(root, executor);
        Future<Integer> future = executor.submit(calculator);
        int treeSize = future.get();
        System.out.println(treeSize);
        executor.shutdown();
    }
}

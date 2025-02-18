package LLD.executors_and_callables.Threads.callable2;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.Callable;

class TreeSizeCalculator implements Callable<Integer> {
    private final Node root;
    private final ExecutorService executor;

    public TreeSizeCalculator(Node root, ExecutorService executor) {
        this.root = root;
        this.executor = executor;
    }

    @Override
    public Integer call() throws Exception {
        if (root == null) {
            return 0;
        }

        Future<Integer> leftSize = null, rightSize = null;

        if (root.left != null) {
            leftSize = executor.submit(new TreeSizeCalculator(root.left, executor));
        }
        if (root.right != null) {
            rightSize = executor.submit(new TreeSizeCalculator(root.right, executor));
        }

        int leftCount = (leftSize != null) ? leftSize.get() : 0;
        int rightCount = (rightSize != null) ? rightSize.get() : 0;

        return 1 + leftCount + rightCount;
    }
}

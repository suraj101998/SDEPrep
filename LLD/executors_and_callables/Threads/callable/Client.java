package LLD.executors_and_callables.Threads.callable;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Client {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        ArrayCreator ac = new ArrayCreator(n);
        ExecutorService exs = Executors.newFixedThreadPool(1);
        Future<ArrayList<Integer>> acf = exs.submit(ac);
        ArrayList<Integer> list = acf.get();
        System.out.println(list);

        exs.shutdown();
    }
}

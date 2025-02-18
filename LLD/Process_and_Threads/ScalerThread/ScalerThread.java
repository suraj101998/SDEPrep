package ScalerThread;

import java.util.HashMap;

public class ScalerThread extends Thread {
    public static HashMap<String, String> map = new HashMap<>();
    private String target;

    ScalerThread(Runnable r){
        super(r);
        target = r.getClass().getName();
    }

    @Override
    public void start() {
        super.start();
        map.put(target, this.getName());
    }
}

class Adder implements Runnable{
    @Override
    public void run(){
        System.out.println("I am the Adder class");
    }
}

class Subtractor implements Runnable{
    @Override
    public void run(){
        System.out.println("I am the Subtractor class");
    }
}

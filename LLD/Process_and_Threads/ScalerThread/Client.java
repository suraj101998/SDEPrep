package ScalerThread;

public class Client {
    public static void main(String[] args) {
        System.out.println("I am the main class");

        // Creating and starting ScalerThread for Adder
        ScalerThread adderThread = new ScalerThread(new Adder());
        adderThread.start();

        // Creating and starting ScalerThread for Subtractor
        ScalerThread subtractorThread = new ScalerThread(new Subtractor());
        subtractorThread.start();
    }
}


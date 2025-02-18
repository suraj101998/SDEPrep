package ScalerThread2;

class Adder implements Runnable {
    private final int num1;
    private final int num2;

    public Adder(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    @Override
    public void run() {
        System.out.println((num1 + num2));
    }
}

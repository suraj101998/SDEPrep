package ScalerThread3;

class TableCreator extends Thread {
    private final int number;

    public TableCreator(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        printMultiplicationTable();
    }

    private void printMultiplicationTable() {
        for (int i = 1; i <= 10; i++) {
            System.out.println(number + " times " + i + " is " + (number * i));
        }
    }
}

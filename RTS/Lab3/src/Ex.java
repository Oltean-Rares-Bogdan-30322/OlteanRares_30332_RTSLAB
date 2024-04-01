class DivisorThread extends Thread {
    private static int sumOfDivisors = 0;
    private int startNumber;
    private int endNumber;

    DivisorThread(String name, int start, int end) {
        super(name);
        this.startNumber = start;
        this.endNumber = end;
    }

    public void run() {
        System.out.println(Thread.currentThread().getName() + " has entered the run() method");
        int divisorSum = calculateDivisors(startNumber, endNumber);
        synchronized (DivisorThread.class) {
            sumOfDivisors += divisorSum;
            System.out.println(Thread.currentThread().getName() + " sum of divisors: " + divisorSum);
            System.out.println("Total sum so far: " + sumOfDivisors);
        }
        System.out.println(Thread.currentThread().getName() + " has terminated.");
    }

    private int calculateDivisors(int start, int end) {
        int sum = 0;
        for (int i = start; i > 0; i--) {
            if (end == 50000 && i <= 1) continue; // Skip 1 for numbers greater than 50000
            if (end == 20000 && i <= 1) continue; // Skip 1 for numbers greater than 20000
            if (end % i == 0) {
                sum += i;
            }
        }
        return sum;
    }

    public static int getSumOfDivisors() {
        return sumOfDivisors;
    }
}

public class Ex {
    public static void main(String[] args) {
        DivisorThread thread1 = new DivisorThread("Thread 1", 50001, Integer.MAX_VALUE);
        DivisorThread thread2 = new DivisorThread("Thread 2", 20001, 50000);

        thread1.run(); // Start the thread by calling run() directly
        thread2.run(); // Start the thread by calling run() directly

        System.out.println("Sum of divisors: " + DivisorThread.getSumOfDivisors());
    }
}
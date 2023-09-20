package ky2lab2eng;
public class bai1 {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new NumberPrinter(1), "Thread 1");
        Thread thread2 = new Thread(new NumberPrinter(2), "Thread 2");
        Thread thread3 = new Thread(new NumberPrinter(3), "Thread 3");
        
        thread1.setPriority(Thread.MAX_PRIORITY);
        thread2.setPriority(Thread.NORM_PRIORITY);
        thread3.setPriority(Thread.MIN_PRIORITY);
        
        thread1.start();
        thread2.start();
        thread3.start();
    }
    
    static class NumberPrinter implements Runnable {
        private int threadNumber;
        
        public NumberPrinter(int threadNumber) {
            this.threadNumber = threadNumber;
        }
        
        public void run() {
            for (int i = 1; i <= 10; i++) {
                System.out.println("Thread " + threadNumber + ": " + i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

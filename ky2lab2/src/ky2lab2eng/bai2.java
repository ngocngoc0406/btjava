package ky2lab2eng;
public class bai2 {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new NumberPrinter("Thread 1"), "Thread 1");
        Thread thread2 = new Thread(new NumberPrinter("Thread 2"), "Thread 2");
        Thread thread3 = new Thread(new NumberPrinter("Thread 3"), "Thread 3");
        
        thread1.setPriority(Thread.MIN_PRIORITY);
        thread2.setPriority(Thread.NORM_PRIORITY);
        thread3.setPriority(Thread.MAX_PRIORITY);
        
        thread1.start();
        thread2.start();
        thread3.start();
    }
    
    private static class NumberPrinter implements Runnable {
        private final String name;
        
        public NumberPrinter(String name) {
            this.name = name;
        }
        
        @Override
        public void run() {
            synchronized (this) {
                for (int i = 1; i <= 10; i++) {
                    System.out.println(name + ": " + i);
                }
            }
        }
    }
}

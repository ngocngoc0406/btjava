package ky2lab2eng;
public class bai3 {

    public static void main(String[] args) {
        
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread " + Thread.currentThread().getName() + " is running...");
            }
        }, "Thread A");
        
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread " + Thread.currentThread().getName() + " is running...");
            }
        });
        
        thread1.start();
        thread2.start();
        
        System.out.println("Thread names are following:");
        System.out.println(thread1.getName());
        System.out.println(thread2.getName());
    }
}

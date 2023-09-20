package ky2lab2;

import java.util.Random;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        // Tạo một mảng 10 luồng
        Thread[] threads = new Thread[10];
        // Tạo một mảng 10 biến để lưu tổng của từng luồng
        int[] sums = new int[10];
        
        // Tạo 10 luồng
        for (int i = 0; i < 10; i++) {
            final int threadNum = i;
            threads[i] = new Thread(new Runnable() {
                public void run() {
                    // Tạo số ngẫu nhiên từ 1 đến 30
                    Random rand = new Random();
                    int num = rand.nextInt(30) + 1;
                    // Lưu tổng của luồng vào mảng sums
                    sums[threadNum] = num;
                }
            });
            // Khởi động luồng
            threads[i].start();
            System.out.println(threads[i].getName());
        }
        
        // Đợi tất cả các luồng kết thúc
        for (int i = 0; i < 10; i++) {
            threads[i].join();
        }
        
        // Tính tổng của tất cả các luồng
        int totalSum = 0;
        for (int i = 0; i < 10; i++) {
            totalSum += sums[i];
        }
        
        System.out.println("Tong cua 10 luong: " + totalSum);
    }
}
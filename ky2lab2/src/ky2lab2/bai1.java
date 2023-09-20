package ky2lab2;


import java.util.Scanner;

public class bai1 {
    public static void main(String[] args) {
   
       
Scanner input = new Scanner(System.in);

        // Tạo thread cho tuyến 1
        Thread tuyen1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Nhap vao 2 canh cua hinh chu nhat:");
                double a = input.nextDouble();
                double b = input.nextDouble();
                // Gửi dữ liệu qua cho thread của tuyến 2 và tuyến 3
                synchronized (this) {
                    notifyAll();
                }
            }
        });

        // Tạo thread cho tuyến 2
        Thread tuyen2 = new Thread(new Runnable() {
            @Override
            public void run() {
                // Chờ nhận dữ liệu từ tuyến 1
                synchronized (tuyen1) {
                    try {
                        tuyen1.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                // Lấy dữ liệu và tính diện tích
                double a = input.nextDouble();
                double b = input.nextDouble();
                double dienTich = a * b;
                System.out.println("Dien tich cua hinh chu nhat la: " + dienTich);
                // Gửi dữ liệu qua cho thread của tuyến 3
                synchronized (this) {
                    notifyAll();
                }
            }
        });

        // Tạo thread cho tuyến 3
        Thread tuyen3 = new Thread(new Runnable() {
            @Override
            public void run() {
                // Chờ nhận dữ liệu từ tuyến 1
                synchronized (tuyen1) {
                    try {
                        tuyen1.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                // Chờ nhận dữ liệu từ tuyến 2
                synchronized (tuyen2) {
                    try {
                        tuyen2.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                // Lấy dữ liệu và tính chu vi
                double a = input.nextDouble();
                double b = input.nextDouble();
                double chuVi = 2 * (a + b);
                System.out.println("Chu vi cua hinh chu nhat la: " + chuVi);
            }
        });

        // Khởi động 3 thread
        tuyen1.start();
        tuyen2.start();
        tuyen3.start();
    }
}
package ky2lab1;

import java.util.Scanner;

public class lab1bai1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so nguyen duong tu 0 den 6: ");
        int n = sc.nextInt();
        sc.close();
        
        switch(n) {
            case 0:
                System.out.println("Chu nhat");
                break;
            case 1:
                System.out.println("Thu Hai");
                break;
            case 2:
                System.out.println("Thu Ba");
                break;
            case 3:
                System.out.println("Thu tu");
                break;
            case 4:
                System.out.println("Thu Nam");
                break;
            case 5:
                System.out.println("Thu Sau");
                break;
            case 6:
                System.out.println("Thu Bay");
                break;
            default:
                System.out.println("F");
        }
    }
}

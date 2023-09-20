package ky2lab1;
import java.util.Scanner;

public class lab1bai2 {
    // Hàm đệ quy tìm ước số chung lớn nhất của a và b
    public static int timUSCLN(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return timUSCLN(b, a % b);
        }
    }

    // Hàm tìm bội số chung nhỏ nhất của a và b
    public static int timBSCNN(int a, int b) {
        return (a * b) / timUSCLN(a, b);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so nguyen a: ");
        int a = sc.nextInt();
        System.out.print("Nhap so nguyen b: ");
        int b = sc.nextInt();
        sc.close();
        
        int uscln = timUSCLN(a, b);
        int bscnn = timBSCNN(a, b);
        
        System.out.println("uoc so chung lon nhat cua " + a + " va " + b + " la: " + uscln);
        System.out.println("Boi so chung nho nhat cua " + a + " va " + b + " la: " + bscnn);
    }
}

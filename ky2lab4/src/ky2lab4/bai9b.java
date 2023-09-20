package ky2lab4;
import java.io.File;

public class bai9b  {
    public static void main(String[] args) {
        String filePath = "ThongTin.txt";
        File file = new File(filePath);

        if (file.exists()) {
            long fileSizeInBytes = file.length();
            double fileSizeInKB = (double) fileSizeInBytes / 1024;
            double fileSizeInMB = (double) fileSizeInBytes / (1024 * 1024);

            System.out.println("Kich thuoc tep " + filePath + " la:");
            System.out.println("- " + fileSizeInBytes + " byte");
            System.out.println("- " + String.format("%.2f", fileSizeInKB) + " KB");
            System.out.println("- " + String.format("%.2f", fileSizeInMB) + " MB");
        } else {
            System.out.println("tep khong ton tai.");
        }
    }
}

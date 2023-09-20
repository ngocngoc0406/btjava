package ky2lab4;
import java.io.File;

public class bai3b {
    public static void main(String[] args) {
        String filePath = "ThongTin.txt";
        String directoryPath = "D:\\\\Java\\\\ky2lab4";

        File file = new File(filePath);
        File directory = new File(directoryPath);

        // Kiểm tra xem tệp hoặc thư mục có tồn tại hay không
        if (file.exists()) {
            System.out.println("Tep " + filePath + " ton tai.");
        } else {
            System.out.println("Tep " + filePath + " khong ton tai.");
        }

        if (directory.exists()) {
            System.out.println("Thu muc " + directoryPath + " ton tai.");
        } else {
            System.out.println("Thu muc " + directoryPath + " khong ton tai.");
        }
    }
}

package ky2lab4;
import java.io.File;

public class bai5b {
    public static void main(String[] args) {
        String filePath = "ThongTin.txt";
        String directoryPath = "D:\\\\\\\\\\\\\\\\Java\\\\\\\\\\\\\\\\ky2lab4";

        File file = new File(filePath);
        File directory = new File(directoryPath);

        // Kiểm tra xem đường dẫn có phải là tệp hay thư mục không
        if (file.isFile()) {
            System.out.println(filePath + " la tep .");
        } else {
            System.out.println(filePath + " la thu muc.");
        }

        if (directory.isDirectory()) {
            System.out.println(directoryPath + " la thu muc.");
        } else {
            System.out.println(directoryPath + "la tep.");
        }
    }
}


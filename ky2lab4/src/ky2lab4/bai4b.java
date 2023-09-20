package ky2lab4;
import java.io.File;

public class bai4b {
    public static void main(String[] args) {
        String filePath = "ThongTin.txt";
        String directoryPath = "D:\\\\\\\\Java\\\\\\\\ky2lab4";

        File file = new File(filePath);
        File directory = new File(directoryPath);

        // Kiểm tra quyền đọc và ghi của tệp và thư mục
        if (file.canRead() && file.canWrite()) {
            System.out.println("Tep " + filePath + " co quyen doc va ghi.");
        } else {
            System.out.println("Tep " + filePath + " khong co quyen doc va ghi.");
        }

        if (directory.canRead() && directory.canWrite()) {
            System.out.println("Thu muc " + directoryPath + " co quyen doc va ghi.");
        } else {
            System.out.println("Thu muc " + directoryPath + " khong co quyen doc va ghi.");
        }
    }
}

package ky2lab4;
import java.io.File;

public class bai1b {
    public static void main(String[] args) {
        String directoryPath = "D:\\Java\\ky2lab4";
        File directory = new File(directoryPath);

        // Lấy danh sách tất cả các tệp/thư mục trong thư mục đã cho
        String[] fileList = directory.list();

        // Hiển thị danh sách tệp/thư mục
        if (fileList != null) {
            for (String fileName : fileList) {
                System.out.println(fileName);
            }
        } else {
            System.out.println("Thư mục không tồn tại hoặc không có tệp/thư mục nào.");
        }
    }
}

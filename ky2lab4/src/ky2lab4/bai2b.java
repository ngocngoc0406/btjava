package ky2lab4;
import java.io.File;

public class bai2b {
    public static void main(String[] args) {
        String directoryPath = "D:\\\\Java\\\\ky2lab4";
        String fileExtension = ".txt";
        File directory = new File(directoryPath);

        // Lấy danh sách tất cả các tệp có phần mở rộng là ".txt"
        File[] fileList = directory.listFiles((dir, name) -> name.toLowerCase().endsWith(fileExtension));

        // Hiển thị danh sách tệp
        if (fileList != null) {
            for (File file : fileList) {
                System.out.println(file.getName());
            }
        } else {
            System.out.println("Thư mục không tồn tại hoặc không có tệp có phần mở rộng là " + fileExtension);
        }
    }
}

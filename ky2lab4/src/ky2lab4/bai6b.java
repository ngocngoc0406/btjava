package ky2lab4;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class bai6b {
    public static void main(String[] args) {
        String sourceFilePath = "ThongTin.txt";
        String destinationFilePath = "ThongTinNew.txt";

        try (FileInputStream inputStream = new FileInputStream(sourceFilePath);
             FileOutputStream outputStream = new FileOutputStream(destinationFilePath)) {

            // Đọc các byte từ tệp nguồn và ghi chúng vào tệp đích
            byte[] buffer = new byte[1024];
            int length;
            while ((length = inputStream.read(buffer)) > 0) {
                outputStream.write(buffer, 0, length);
            }

            System.out.println("Copy tep thanh cong.");
        } catch (IOException e) {
            System.out.println("Loi khi copy tep: " + e.getMessage());
        }
    }
}

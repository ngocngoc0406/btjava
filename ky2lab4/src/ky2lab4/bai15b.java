package ky2lab4;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class bai15b {
    public static void main(String[] args) {
        String filePath = "ThongTin.txt";

        // Ghi nội dung vào tệp
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write("Hello, world!\n");
            writer.write("This is a text file.\n");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Đọc nội dung từ tệp và hiển thị ra màn hình
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

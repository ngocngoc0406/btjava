package ky2lab4;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class bai14b {
    public static void main(String[] args) {
        String filePath = "ThongTin.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            int lineNumber = 0;
            String[] lines = new String[100]; // Khởi tạo mảng với kích thước tối đa là 100 dòng
            while ((line = br.readLine()) != null) {
                lines[lineNumber++] = line;
            }
            // In ra nội dung mảng
            for (int i = 0; i < lineNumber; i++) {
                System.out.println(lines[i]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

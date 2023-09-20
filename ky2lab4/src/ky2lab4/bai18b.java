package ky2lab4;
import java.io.*;
import java.util.Arrays;

public class bai18b {
    public static void main(String[] args) {
        try {
            // Đường dẫn của tệp văn bản
            String filePath = "ThongTin.txt";

            // Đọc nội dung tệp văn bản và lưu vào một chuỗi
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            StringBuilder builder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }
            String content = builder.toString();
            reader.close();

            // Tách chuỗi thành các từ và lưu vào một mảng
            String[] words = content.split("\\s+");

            // Tìm độ dài của từ dài nhất trong mảng
            int maxLength = 0;
            String longestWord = "";
            for (String word : words) {
                int length = word.length();
                if (length > maxLength) {
                    maxLength = length;
                    longestWord = word;
                }
            }

            // In ra từ dài nhất
            System.out.println("tu dai nhat trông tep la: " + longestWord);
        } catch (IOException e) {
            System.out.println("da xay ra loi khi doc tep van ban.");
            e.printStackTrace();
        }
    }
}

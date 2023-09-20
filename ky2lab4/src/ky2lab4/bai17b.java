package ky2lab4;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class  bai17b {
    public static void main(String[] args) {
        String filePath = "ThongTin.txt";
        int lineCount = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null && lineCount < 3) {
                System.out.println(line);
                lineCount++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

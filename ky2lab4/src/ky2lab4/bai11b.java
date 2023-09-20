package ky2lab4;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class bai11b {
    public static void main(String[] args) {
        String filePath = "ThongTin.txt";
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

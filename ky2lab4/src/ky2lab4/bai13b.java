package ky2lab4;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class bai13b {
    public static void main(String[] args) {
        String filePath = "ThongTin.txt";
        StringBuilder fileContent = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                fileContent.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String fileContentAsString = fileContent.toString();
        System.out.println(fileContentAsString);
    }
}

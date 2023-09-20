package ky2lab4;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

public class bai10b {
    public static void main(String[] args) {
        String filePath = "ThongTin.txt";
        File file = new File(filePath);

        if (file.exists()) {
            try (FileInputStream fis = new FileInputStream(file)) {
                byte[] fileContent = new byte[(int) file.length()];
                fis.read(fileContent);
                System.out.println("noi dung tep " + filePath + " la:");
                System.out.println(Arrays.toString(fileContent));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Tep khong ton tai.");
        }
    }
}

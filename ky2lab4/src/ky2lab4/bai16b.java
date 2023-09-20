package ky2lab4;
import java.io.FileWriter;
import java.io.IOException;

public class bai16b {
    public static void main(String[] args) {
        String filePath = "ThongTin.txt";

        // Thêm nội dung vào tệp
        try (FileWriter writer = new FileWriter(filePath, true)) {
            writer.write("This text will be appended to the end of the file.\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

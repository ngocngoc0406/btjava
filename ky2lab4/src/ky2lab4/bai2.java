package ky2lab4;
import java.io.*;

public class bai2 {
    public static void main(String[] args) {
        // Đường dẫn của tệp "ThongTin.txt"
        String sourceFilePath = "ThongTin.txt";

        // Tạo và ghi thông tin vào tệp mới "ThongTinNew.txt"
        try {
            File sourceFile = new File(sourceFilePath);
            File destFile = new File("ThongTinNew.txt");
            BufferedReader reader = new BufferedReader(new FileReader(sourceFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(destFile));

            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }
            writer.write("Noi sinh: Ha Noi"); // Bổ sung thông tin về nơi sinh
            reader.close();
            writer.close();
            System.out.println("da sao chep và bo sung thong tin thanh cong.");

            // Xuất ra thông tin về tệp
            System.out.println("Thong tin ve tep:");
            System.out.println("Ten tep: " + destFile.getName());
            System.out.println("duong dan tuyet doi: " + destFile.getAbsolutePath());
            System.out.println("Kich thuoc : " + destFile.length() + " bytes");
            System.out.println("an/Hien: " + (destFile.isHidden() ? "an" : "Hien"));
        } catch (IOException e) {
            System.out.println("da xay ra loi khi sao chep va bo sung thong tin.");
            e.printStackTrace();
        }
    }
}

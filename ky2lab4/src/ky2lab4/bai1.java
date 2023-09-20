package ky2lab4;
import java.io.FileWriter;
import java.io.IOException;

public class bai1 {
    public static void main(String[] args) {
        // Khởi tạo thông tin cá nhân
        String hoTen = "Nguyễn Văn A";
        String ngaySinh = "01/01/1990";
        int tuoi = 33;

        // Tạo và ghi thông tin vào tệp "ThongTin.txt"
        try {
            FileWriter myWriter = new FileWriter("ThongTin.txt");
            myWriter.write("Họ và tên: " + hoTen + "\n");
            myWriter.write("Ngày tháng năm sinh: " + ngaySinh + "\n");
            myWriter.write("Tuổi: " + tuoi + "\n");
            myWriter.close();
            System.out.println("da ghi thong tin vao tep ThongTin.txt.");
        } catch (IOException e) {
            System.out.println("da xay ra loi khi ghi thông tin vao tep.");
            e.printStackTrace();
        }
    }
}

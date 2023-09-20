package ky2lab4;
import java.io.File;
import java.util.Date;

public class bai7b {
    public static void main(String[] args) {
        String filePath = "ThongTin.txt";
        File file = new File(filePath);

        if (file.exists()) {
            long lastModified = file.lastModified();
            Date date = new Date(lastModified);
            System.out.println("Thoi gian sua doi cuoi cung cua tep " + filePath + " la: " + date);
        } else {
            System.out.println("Tep khong ton tai.");
        }
    }
}

package ky2lab6;

import java.io.*;
import java.net.*;
import java.nio.charset.*;
import java.util.*;
public class bai1 {
    public static void main(String[] args) throws IOException  {
        // ví dụ demo kết nối đến google
        try(var s=new Socket("www.google.com", 80);
        var in=new Scanner(s.getInputStream(), StandardCharsets.UTF_8))
        {
            // Gửi yêu cầu HTTP GET đến server của Google
            PrintWriter out = new PrintWriter(s.getOutputStream(), true);
            out.println("GET / HTTP/1.1");
            out.println("Host: www.google.com");
            out.println("Connection: close");
            out.println();

            // Nhận và in ra phản hồi từ server
            while(in.hasNextLine()) {
                String line=in.nextLine();
                System.out.println(line);
            }
        }
    }
}

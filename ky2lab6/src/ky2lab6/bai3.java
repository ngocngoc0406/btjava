package ky2lab6;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class bai3 {

	public static void main(String[] args) throws IOException {
		URL url=new URL("https://thanhnien.com.vn/");
		URLConnection urlConnection=url.openConnection();
		InputStream inputStream=urlConnection.getInputStream();
		int i=inputStream.read();
		while(i!=-1) {
			System.out.print((char)i);
			i=inputStream.read();
		}
	}
}

package Chuong4;
import java.io.File;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class Vidu2 {

	public static void main(String[] args) {
		// Ví dụ sử dụng Java SAX đọc dữ liệu từ file xml
		//1. Tạo lớp kế thừa lớp DefaultHandler để bắt các sự kiện
		//2. Thực hiện đọc dữ liệu và xuất
		 try {
	         File inputFile = new File("C:\\Users\\thinn\\eclipse-workspace_prod8\\JavaNangCao\\src\\Chuong4\\input.xml");
	         SAXParserFactory factory = SAXParserFactory.newInstance();
	         SAXParser saxParser = factory.newSAXParser();
	         UserHandler userhandler = new UserHandler();
	         saxParser.parse(inputFile, userhandler);     
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	}

}

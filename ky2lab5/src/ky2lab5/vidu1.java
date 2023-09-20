package ky2lab5;
import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
public class vidu1 {

	public static void main(String[] args) {
		// Đọc dữ liệu từ file *.xml và xuất dữ liệu ra màn hình Console 
		      try {
		    	 // Tạo đối tượng Document để lưu dữ liệu từ file *.xml
		         File inputFile = new File("C:\\Users\\thinn\\eclipse-workspace_prod8\\JavaNangCao\\src\\Chuong4\\input.xml");
		         DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		         Document doc = dBuilder.parse(inputFile);
       
		         // In ra thông tin từ file *.xml
		         doc.getDocumentElement().normalize();
		         System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
		         NodeList nList = doc.getElementsByTagName("student");
		         System.out.println("----------------------------");
		         
		         for (int temp = 0; temp < nList.getLength(); temp++) {
		            Node nNode = nList.item(temp);
		            System.out.println("\nCurrent Element :" + nNode.getNodeName());
		            
		            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
		               Element eElement = (Element) nNode;
		               System.out.println("Student roll no : " 
		                  + eElement.getAttribute("rollno"));
		               System.out.println("First Name : " 
		                  + eElement
		                  .getElementsByTagName("firstname")
		                  .item(0)
		                  .getTextContent());
		               System.out.println("Last Name : " 
		                  + eElement
		                  .getElementsByTagName("lastname")
		                  .item(0)
		                  .getTextContent());
		               System.out.println("Nick Name : " 
		                  + eElement
		                  .getElementsByTagName("nickname")
		                  .item(0)
		                  .getTextContent());
		               System.out.println("Marks : " 
		                  + eElement
		                  .getElementsByTagName("marks")
		                  .item(0)
		                  .getTextContent());
		            }
		         }
		      } catch (Exception e) {
		         e.printStackTrace();
		      }
		   }
}

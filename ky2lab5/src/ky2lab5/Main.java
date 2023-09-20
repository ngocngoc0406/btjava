package ky2lab5;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            MyHandler handler = new MyHandler();
            parser.parse("Employees.xml", handler);
            List<Employee2> employees = handler.getEmployees();
            for (Employee2 employee : employees) {
                System.out.println(employee);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

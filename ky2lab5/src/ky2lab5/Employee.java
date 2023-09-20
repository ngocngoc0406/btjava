package ky2lab5;
import java.io.File;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class Employee {
    private int id;
    private String firstName;
    private String lastName;
    private int age;
    private double salary;

    public Employee(int id, String firstName, String lastName, int age, double salary) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.salary = salary;
    }

    // Getters and setters

    public static ArrayList<Employee> readFromXML(String fileName) {
        ArrayList<Employee> employees = new ArrayList<>();
        try {
            File file = new File(fileName);
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(file);
            doc.getDocumentElement().normalize();

            NodeList nodeList = doc.getElementsByTagName("Employee");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Element element = (Element) nodeList.item(i);
                int id = Integer.parseInt(element.getAttribute("ID"));
                String firstName = element.getElementsByTagName("Firstname").item(0).getTextContent();
                String lastName = element.getElementsByTagName("Lastname").item(0).getTextContent();
                int age = Integer.parseInt(element.getElementsByTagName("Age").item(0).getTextContent());
                double salary = Double.parseDouble(element.getElementsByTagName("Salary").item(0).getTextContent());

                Employee employee = new Employee(id, firstName, lastName, age, salary);
                employees.add(employee);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return employees;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", salary="
                + salary + "]";
    }

    public static void main(String[] args) {
        ArrayList<Employee> employees = Employee.readFromXML("Employee.xml");
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
}

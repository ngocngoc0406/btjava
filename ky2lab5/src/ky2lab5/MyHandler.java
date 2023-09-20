package ky2lab5;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class MyHandler extends DefaultHandler {
    private List<Employee2> employees = new ArrayList<>();
    private Employee2 employee;
    private StringBuilder data;

    public List<Employee2> getEmployees() {
        return employees;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("employee")) {
            int id = Integer.parseInt(attributes.getValue("id"));
            employee = new Employee2(id, "", 0, "", "");
        }
        data = new StringBuilder();
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch (qName.toLowerCase()) {
            case "name":
                employee.setName(data.toString());
                break;
            case "age":
                employee.setAge(Integer.parseInt(data.toString()));
                break;
            case "gender":
                employee.setGender(data.toString());
                break;
            case "role":
                employee.setRole(data.toString());
                break;
            case "employee":
                employees.add(employee);
                break;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        data.append(new String(ch, start, length));
    }
}

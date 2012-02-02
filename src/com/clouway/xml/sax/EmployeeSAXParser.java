package com.clouway.xml.sax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Parse an XML file using SAX
 *
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public class EmployeeSAXParser extends DefaultHandler {

    private String tag; // current tag
    private final ObjectMaker objectMaker;

    private Map<String, Object> tagToObject = new HashMap<String, Object>(); // contains tags and objects associated to them
    private Map<String, String> tagAndValue = new HashMap<String, String>(); // contains tags and their values
    
    private List<Employee> employeeList = new ArrayList<Employee>(); // list of Employee objects
    private List<Employer> employerList = new ArrayList<Employer>(); // list of Employer objects
    private List<Address> addressList = new ArrayList<Address>(); // list of Address objects

    /**
     * Constructor sets which ObjectMaker the EmployeeSAXParser will use to create objects
     *
     * @param objectMaker ObjectMaker which we will use to create objects
     */
    public EmployeeSAXParser(ObjectMaker objectMaker) {

        this.objectMaker = objectMaker;
    }

    /**
     * Parse the XML file
     */
    public void parse() {

        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = factory.newSAXParser();
            parser.parse("employee.xml", this);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) {

        Object object = objectMaker.makeObject(qName);
        tagToObject.put(qName, object);
        tag = qName;
    }

    public void characters(char[] chars, int start, int length) {
        
        tagAndValue.put(tag, new String(chars, start, length));
    }

    public void endElement(String uri, String localName, String qName) {

        Object object = tagToObject.get(qName);

        if (object != null) {
            setFieldValuesOf(object, tagAndValue);
            addObjectToList(object);
        }
    }

    /**
     * Set the field values of the given object using reflection
     *
     * @param object object of which we will assign values of its fields
     * @param tagAndValue map from which we will get the values
     */
    private void setFieldValuesOf(Object object, Map<String, String> tagAndValue) {

        Field[] fields = object.getClass().getDeclaredFields();

        for (Field field : fields) {

            field.setAccessible(true);

            try {
                field.set(object, tagAndValue.get(field.getName()));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Adds an object to specified list of objects
     *
     * @param object object to be added
     */
    private void addObjectToList(Object object) {

        if (object instanceof Employee) {
            employeeList.add((Employee) object);
            ((Employee) object).setEmployerList(employerList);
            ((Employee) object).setAddressList(addressList);
            tagAndValue.clear();
        }

        if (object instanceof Employer) {
            employerList.add((Employer) object);
        }

        if (object instanceof Address) {
            addressList.add((Address) object);
        }
    }

    /**
     * Return a list of Employee objects
     *
     * @return list of Employee objects
     */
    public List<Employee> getEmployeeList() {

        return this.employeeList;
    }
}

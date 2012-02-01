package com.clouway.xml.dom;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Parse an XML file using DOM
 * <p/>
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public class XmlDomParser {

  private Document document;
  private List<Employee> employeeList = new ArrayList<Employee>();

  /**
   * Parse the XML file
   */
  public void parse() {

    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

    try {

      DocumentBuilder builder = factory.newDocumentBuilder();
      document = builder.parse("employee.xml");

    } catch (ParserConfigurationException e) {
      e.printStackTrace();
    } catch (SAXException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Returns a List of Employee objects
   *
   * @return List of Employee objects
   */
  public List<Employee> getEmployeeList() {

    walk("employee", new ElementVisitor() {
      public void visitElement(Element element) {
        Employee employee = createEmployee(element);
        employeeList.add(employee);
      }
    });
    return employeeList;
  }

  interface ElementVisitor {
    void visitElement(Element element);
  }


  /**
   * Returns a list of Address objects
   *
   * @return list of Address objects
   */
  private List<Address> getAddressesList() {

    final List<Address> addressList = new ArrayList<Address>();
    walk("address", new ElementVisitor() {
      public void visitElement(Element element) {
        Address address = createAddress(element);
        addressList.add(address);
      }
    });

    return addressList;
  }

  private void walk(String tagName, ElementVisitor visitor) {

    NodeList nodeList = document.getElementsByTagName(tagName);

    if (nodeList != null && nodeList.getLength() > 0) {
      for (int i = 0; i < nodeList.getLength(); i++) {
        Element element = (Element) nodeList.item(i);
        visitor.visitElement(element);
      }
    }

  }

  /**
   * Returns a list of Employer objects
   *
   * @return list of Employer objects
   */
  private List<Employer> getEmployersList() {

    NodeList nodeList = document.getElementsByTagName("employer");
    List<Employer> employerList = new ArrayList<Employer>();

    if (nodeList != null && nodeList.getLength() > 0) {

      for (int i = 0; i < nodeList.getLength(); i++) {

        Element element = (Element) nodeList.item(i);
        Employer employer = createEmployer(element);
        employerList.add(employer);
      }
    }

    return employerList;
  }

  /**
   * Creates a new Employee object
   *
   * @param element element in the XML file
   * @return Employee object
   */
  private Employee createEmployee(Element element) {

    return new Employee(getValue(element, "firstName"), getValue(element, "lastName"), Integer.parseInt(getValue(element, "age")), getValue(element, "position"), getAddressesList(), getEmployersList());
  }

  /**
   * Creates a new Address object
   *
   * @param element element in the XML file
   * @return Address object
   */
  private Address createAddress(Element element) {

    return new Address(getValue(element, "street"), getValue(element, "streetNo"), getValue(element, "section"), getValue(element, "city"));
  }

  /**
   * Creates a new Employer object
   *
   * @param element element in the XML file
   * @return Employer object
   */
  private Employer createEmployer(Element element) {

    return new Employer(getValue(element, "name"), getValue(element, "startDate"), getValue(element, "endDate"));
  }

  /**
   * Get the value of the element
   *
   * @param element element in the XML File
   * @param tagName name of the tag
   * @return value of the element
   */
  private String getValue(Element element, String tagName) {

    String value = null;
    NodeList nodeList = element.getElementsByTagName(tagName);

    if (nodeList != null && nodeList.getLength() > 0) {

      Element e = (Element) nodeList.item(0);
      value = e.getFirstChild().getNodeValue();
    }

    return value;
  }
}

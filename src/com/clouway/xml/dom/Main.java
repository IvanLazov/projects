package com.clouway.xml.dom;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/**
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public class Main {

    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {

        XmlDomParser parser = new XmlDomParser();
        parser.parseDocument();

        System.out.println(parser.getEmployeeList());
    }
}

package com.clouway.xml.sax;

import java.util.HashMap;
import java.util.Map;

/**
 * Creates an Object from Class
 *
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public class ObjectMaker {

    Map<String, Class<?>> tagNameToClass = new HashMap<String, Class<?>>(); // contains the XML tags of the classes

    /**
     * Constructor associates the tags with specific classes
     */
    public ObjectMaker() {

        tagNameToClass.put("employee.xml", Employee.class);
        tagNameToClass.put("employer", Employer.class);
        tagNameToClass.put("address", Address.class);
    }

    /**
     * Creates an object from a Class if the tag is contained in the map
     *
     * @param tagName tag name
     * @return a new Object
     */
    public Object makeObject(String tagName) {

        Class<?> clazz = tagNameToClass.get(tagName);

        try {
            if (clazz != null) {
                return clazz.newInstance();
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return null;
    }
}

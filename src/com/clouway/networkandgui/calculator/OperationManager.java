package com.clouway.networkandgui.calculator;

import java.util.Hashtable;
import java.util.Map;

/**
 * Contains objects that implement Operation interface in a map
 *
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public class OperationManager {

    private Map<String, Operation> operations;

    public OperationManager() {
        operations = new Hashtable<String, Operation>();
    }

    /**
     * Add a new object in the hashtable. The object must implement interface Operation/
     *
     * @param name sign of the operation
     * @param operation object that implement Operation interface
     */
    public void addOperation(String name, Operation operation) {
        operations.put(name, operation);
    }

    /**
     * Return Operation object
     *
     * @param name sign of the operation
     * @return Operation object
     */
    public Operation getOperation(String name) {
        return operations.get(name);
    }
}

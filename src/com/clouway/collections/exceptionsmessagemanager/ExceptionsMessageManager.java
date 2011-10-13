package com.clouway.collections.exceptionsmessagemanager;

import java.util.*;

public class ExceptionsMessageManager {

    private Map<String, String> exceptions;

    public ExceptionsMessageManager() {
        exceptions = new Hashtable<String, String>();
    }

    /**
     * Insert new error message
     *
     * @param messageCode String code of the error message
     * @param message String
     * @throws MessageExistException if the messageCode or message exists in the map
     */
    public void registerErrorMessage(String messageCode, String message) throws MessageExistException {
        if (exceptions.containsKey(messageCode) || exceptions.containsValue(message)) {
            throw new MessageExistException();
        } else {
            exceptions.put(messageCode, message);
        }
    }

    /**
     * Check if the messageCode is registered in the map
     *
     * @param messageCode String
     * @return message for the corresponding messageCode
     * @throws KeyNotFoundExistException if the messageCode do not exists in the map
     */
    public String raiseError(String messageCode) throws KeyNotFoundExistException {
        if (!exceptions.containsKey(messageCode)) {
            throw new KeyNotFoundExistException();
        } else {
            return exceptions.get(messageCode);
        }
    }

    /**
     * Gets all error message codes
     *
     * @return key values of the error messages
     */
    public TreeSet<String> getErrorMessage() {
        Set<String> keys = exceptions.keySet();

        TreeSet<String> keyValues = new TreeSet<String>(keys);

        return keyValues;
    }
}
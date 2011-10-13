package com.clouway.collections.exceptionsmessagemanager;

public class Main {

    public static void main(String[] args) {
        ExceptionsMessageManager exceptions = new ExceptionsMessageManager();
        try {
            exceptions.registerErrorMessage("1", "Invalid Debit Card Number");
            exceptions.registerErrorMessage("2", "Wrong PIN");
            exceptions.registerErrorMessage("3", "Invalid Post Code");

            System.out.println("1:" + exceptions.raiseError("1"));
            System.out.println("2:" + exceptions.raiseError("2"));
            System.out.println("3:" + exceptions.raiseError("3"));
            System.out.println("4:" + exceptions.raiseError("4"));
        } catch (MessageExistException e) {
            System.out.print("Message code/message are already registered.\n");
        } catch (KeyNotFoundExistException e) {
            System.out.print("No such exception code.\n");
        }

        System.out.println("\nAll registered exception message codes:");
        for (String k : exceptions.getErrorMessage()) {
            System.out.print(k + " ");
        }
    }
}
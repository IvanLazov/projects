package com.clouway.networkandgui.calculator;

import javax.swing.*;

/**
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public class Launcher {

    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception unused) {

        }

        OperationManager operationManager = new OperationManager();
        operationManager.addOperation("+", new Addition());
        operationManager.addOperation("-", new Subtraction());
        operationManager.addOperation("/", new Division());
        operationManager.addOperation("*", new Multiplication());

        Calculator calculator = new Calculator(operationManager);
        calculator.createAndShowGUI();
    }
}

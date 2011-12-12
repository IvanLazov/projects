package com.clouway.networkandgui.calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public class Calculator {

    private JFrame frame; // holds all components
    private JTextField textField; // display for calculator
    private JPanel panelOne; // contains button clear and button delete
    private JPanel panelTwo; // contains all number buttons
    private JPanel panelThree; // contains all operationKey buttons
    private JButton buttonClear; // clear text field
    private JButton buttonDelete; // delete last entered number
    private JButton buttonEqual;
    private JButton[] buttonsNumbers;
    private JButton[] buttonsOperations;
    private String[] numbersAndOperations; // contains all numbers and operationKey symbols
    private String operationKey; // current operationKey
    private double firstNumber; // the number which is saved after clicking an operationKey
    private boolean operationClicked; // shows that an operationKey button is clicked
    private OperationManager operationManager;

    /**
     * Constructors sets the Calculator's OperationManager
     * @param operationManager used to set operations
     */
    public Calculator(OperationManager operationManager) {
        this.operationManager = operationManager;
    }

    public void createAndShowGUI() {

        numbersAndOperations = new String[]{"7", "8", "9", "4", "5", "6", "1", "2", "3", "0", ".", "/", "*", "-", "+"};

        // Construct textField
        textField = new JTextField();
        textField.setBounds(5, 5, 265, 35);
        textField.setEditable(false);
        textField.setHorizontalAlignment(JTextField.RIGHT);
        textField.setFont(new Font("Verdana", Font.PLAIN, 20));

        // Construct Panel 1
        panelOne = new JPanel();
        panelOne.setLayout(null);
        panelOne.setBounds(5, 55, 275, 35);

        buttonClear = new JButton("CE");
        buttonClear.setBounds(136, 0, 62, 35);

        // Listener for buttonClear
        ActionListener clearListener = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                textField.setText("");
                operationKey = "";
                operationClicked = false;
            }
        };
        buttonClear.addActionListener(clearListener);

        // buttonDelete
        buttonDelete = new JButton("<");
        buttonDelete.setBounds(204, 0, 60, 35);

        // Listener for buttonDelete
        ActionListener deleteListener = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                if (textField.getText().length() > 0) {
                    textField.setText(textField.getText().substring(0, textField.getText().length() - 1));
                }
            }
        };
        buttonDelete.addActionListener(deleteListener);

        panelOne.add(buttonClear);
        panelOne.add(buttonDelete);

        //Construct panelTwo
        panelTwo = new JPanel();
        panelTwo.setLayout(new GridLayout(4, 3, 5, 5));
        panelTwo.setBounds(5, 95, 200, 150);

        // Listener for buttonEqual
        ActionListener equalListener = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    operationClicked = true;
                    double secondNumber = Double.parseDouble(textField.getText());
                    textField.setText(Double.toString(operationManager.getOperation(operationKey).calculate(firstNumber, secondNumber)));
                } catch (NumberFormatException exception) {
                    textField.setText("Invalid number");
                }
            }
        };

        // buttonEqual
        buttonEqual = new JButton("=");
        buttonEqual.addActionListener(equalListener);

        // Listener for buttonsNumbers
        ActionListener numberListener = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                if (operationClicked) {

                    textField.setText("");
                    operationClicked = false;
                }

                textField.setText(textField.getText() + actionEvent.getActionCommand());
            }
        };

        // buttonsNumbers
        buttonsNumbers = new JButton[11];

        for (int i = 0; i < 11; i++) {
            panelTwo.add(buttonsNumbers[i] = new JButton(numbersAndOperations[i]));
            buttonsNumbers[i].addActionListener(numberListener);
        }
        panelTwo.add(buttonEqual);


        // Construct panelThree
        panelThree = new JPanel();
        panelThree.setLayout(new GridLayout(4, 1, 0, 5));
        panelThree.setBounds(209, 95, 60, 150);

        // Listener for buttonsOperation
        ActionListener operationListener = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    operationClicked = true;
                    operationKey = actionEvent.getActionCommand();
                    firstNumber = Double.parseDouble(textField.getText());
                } catch (NumberFormatException exception) {
                    textField.setText("Invalid number");
                }
            }
        };

        // buttonsOperations
        buttonsOperations = new JButton[4];
        for (int i = 11; i < numbersAndOperations.length; i++) {
            int index = 0;
            panelThree.add(buttonsOperations[index] = new JButton(numbersAndOperations[i]));
            buttonsOperations[index].addActionListener(operationListener);
            index++;
        }

        // Construct frame
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setSize(290, 290);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.add(textField);
        frame.add(panelOne);
        frame.add(panelTwo);
        frame.add(panelThree);
    }
}
package datastructure.stackqueue;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * @version 1.33 2007-06-12
 * @author Cay Horstmann
 */
public class Calculator
{
    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                CalculatorFrame frame = new CalculatorFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}

/**
 * A frame with a calculator panel.
 */
class CalculatorFrame extends JFrame
{
    public CalculatorFrame()
    {
        setTitle("Calculator");
        CalculatorPanel panel = new CalculatorPanel();
        add(panel);
        pack();
    }
}

/**
 * A panel with calculator buttons and a result display.
 */
class CalculatorPanel extends JPanel
{
    private JButton display;

    public CalculatorPanel()
    {
        setLayout(new BorderLayout());

        result = 0;
        lastCommand = "=";
        start = true;

        // add the display

        display = new JButton("0");
        display.setEnabled(false);
        add(display, BorderLayout.NORTH);

        ActionListener insert = new InsertAction();
        ActionListener command = new CommandAction();

        // add the buttons in a 4 x 4 grid

        panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4));

        addButton("7", insert);
        addButton("8", insert);
        addButton("9", insert);
        addButton("/", command);

        addButton("4", insert);
        addButton("5", insert);
        addButton("6", insert);
        addButton("*", command);

        addButton("1", insert);
        addButton("2", insert);
        addButton("3", insert);
        addButton("-", command);

        addButton("0", insert);
        addButton(".", insert);
        addButton("=", command);
        addButton("+", command);

        add(panel, BorderLayout.CENTER);
    }

    /**
     * Adds a button to the center panel.
     * @param label the button label
     * @param listener the button listener
     */
    private void addButton(String label, ActionListener listener)
    {
        JButton button = new JButton(label);
        button.addActionListener(listener);
        panel.add(button);
    }

    /**
     * This action inserts the button action string to the end of the display text.
     */
    private class InsertAction implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            String input = event.getActionCommand();
            if (start)
            {
                display.setText("");
                start = false;
            }
            display.setText(display.getText() + input);
        }
    }

    /**
     * This action executes the command that the button action string denotes.
     */
    private class CommandAction implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            String command = event.getActionCommand();

            if (start)
            {
                if (command.equals("-"))
                {
                    display.setText(command);
                    start = false;
                }
                else lastCommand = command;
            }
            else
            {
                while (true) {
                    operandStack.push(display.getText());
                    if (operatorStack.isEmpty()) {
                        operatorStack.push(command);
                        break;
                    }
                    String topCommand = (String)operatorStack.top();
                    if (comparePriority(topCommand, command) < 0) {
                        operatorStack.push(command);
                        break;
                    } else if (comparePriority(topCommand, command) >= 0) {
                        double operand2 = Double.parseDouble((String)operandStack.pop());
                        double operand1 = Double.parseDouble((String)operandStack.pop());
                        lastCommand = (String)operatorStack.pop();
                        calculate(operand1, operand2);
                    }
                }
                start = true;
            }
        }
    }

    /**
     * Carries out the pending calculation.
     * @param x the value to be accumulated with the prior result.
     */
    public String calculate(double x, double y)
    {
        double calResult = 0.0;
        if (lastCommand.equals("+")) calResult = x + y;
        else if (lastCommand.equals("-")) calResult = x - y;
        else if (lastCommand.equals("*")) calResult = x * y;
        else if (lastCommand.equals("/")) calResult = x / y;
        display.setText("" + calResult);
        return String.valueOf(calResult);
    }


    private int comparePriority(String command1, String command2) {
        return getCommandPriority(command1) - getCommandPriority(command2);
    }

    private int getCommandPriority(String command) {
        if ("+".equals(command) || "-".equals(command)) {
           return PLUS_MINUS_PRIORITY;
        }
        if ("*".equals(command) || "/".equals(command)) {
            return MULTIPLY_DIVIDE_PRIORITY;
        }
        return EQUALS_PRIORITY;
    }

    private Stack operatorStack = new ArrayStack();
    private Stack operandStack = new ArrayStack();

    private JPanel panel;
    private double result;
    private String lastCommand;
    private boolean start;

    private static final int MULTIPLY_DIVIDE_PRIORITY = 2;
    private static final int PLUS_MINUS_PRIORITY = 1;
    private static final int EQUALS_PRIORITY = 0;
}

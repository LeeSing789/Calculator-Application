import javax.swing.*;
import java.awt.event.*;

public class Calculator extends JFrame {
    private JTextField firstNumberField;
    private JTextField secondNumberField;
    private JTextField resultField;

    public Calculator() {
        setTitle("Calculator");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel firstNumberLabel = new JLabel("First Number:");
        firstNumberLabel.setBounds(20, 20, 100, 30);
        add(firstNumberLabel);

        firstNumberField = new JTextField();
        firstNumberField.setBounds(150, 20, 200, 30);
        add(firstNumberField);

        JLabel secondNumberLabel = new JLabel("Second Number:");
        secondNumberLabel.setBounds(20, 60, 100, 30);
        add(secondNumberLabel);

        secondNumberField = new JTextField();
        secondNumberField.setBounds(150, 60, 200, 30);
        add(secondNumberField);

        JLabel resultLabel = new JLabel("Result:");
        resultLabel.setBounds(20, 100, 100, 30);
        add(resultLabel);

        resultField = new JTextField();
        resultField.setBounds(150, 100, 200, 30);
        resultField.setEditable(false);
        add(resultField);

        JButton addButton = new JButton("+");
        addButton.setBounds(20, 150, 50, 30);
        add(addButton);

        JButton subtractButton = new JButton("-");
        subtractButton.setBounds(80, 150, 50, 30);
        add(subtractButton);

        JButton multiplyButton = new JButton("*");
        multiplyButton.setBounds(140, 150, 50, 30);
        add(multiplyButton);

        JButton divideButton = new JButton("/");
        divideButton.setBounds(200, 150, 50, 30);
        add(divideButton);

        JButton modButton = new JButton("%");
        modButton.setBounds(260, 150, 50, 30);
        add(modButton);

        JButton clearButton = new JButton("Clear");
        clearButton.setBounds(320, 150, 70, 30);
        add(clearButton);

        // Add action listeners for buttons
        addButton.addActionListener(e -> calculate('+'));
        subtractButton.addActionListener(e -> calculate('-'));
        multiplyButton.addActionListener(e -> calculate('*'));
        divideButton.addActionListener(e -> calculate('/'));
        modButton.addActionListener(e -> calculate('%'));
        clearButton.addActionListener(e -> clearFields());
    }

    private void calculate(char operator) {
        try {
            double num1 = Double.parseDouble(firstNumberField.getText());
            double num2 = Double.parseDouble(secondNumberField.getText());
            double result = 0;
            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
                case '%':
                    result = num1 % num2;
                    break;
            }
            resultField.setText(String.valueOf(result));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid input", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clearFields() {
        firstNumberField.setText("");
        secondNumberField.setText("");
        resultField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Calculator calculator = new Calculator();
            calculator.setVisible(true);
        });
    }
}

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Calculator implements ActionListener {

  private JFrame frame;
  private JTextField textField;
  private JButton button1, button2, button3, button4, button5, button6, button7, button8, button9, button0,
      addButton, subtractButton, divideButton, decimalButton, equalButton, clearButton;

  private double num1 = 0, num2 = 0;
  private char operator;

  public Calculator() {
    frame = new JFrame("Calculator");
    frame.setLayout(null);
    frame.setSize(300, 400);

    textField = new JTextField();
    textField.setBounds(10, 10, 270, 50);
    textField.setFont(textField.getFont().deriveFont(20f));
    textField.setEditable(false);
    frame.add(textField);

    // Create buttons and set positions
    button1 = new JButton("1");
    button1.setBounds(10, 70, 50, 50);
    button1.addActionListener(this);
    frame.add(button1);

    button2 = new JButton("2");
    button2.setBounds(70, 70, 50, 50);
    button2.addActionListener(this);
    frame.add(button2);

    button3 = new JButton("3");
    button3.setBounds(140, 70, 50, 50);
    button3.addActionListener(this);
    frame.add(button3);

    button4 = new JButton("4");
    button4.setBounds(210, 70, 50, 50);
    button4.addActionListener(this);
    frame.add(button4);

    button5 = new JButton("5");
    button5.setBounds(10, 140, 50, 50);
    button5.addActionListener(this);
    frame.add(button5);

    button6 = new JButton("6");
    button6.setBounds(70, 140, 50, 50);
    button6.addActionListener(this);
    frame.add(button6);

    button7 = new JButton("7");
    button7.setBounds(140, 140, 50, 50);
    button7.addActionListener(this);
    frame.add(button7);

    button8 = new JButton("8");
    button8.setBounds(210, 140, 50, 50);
    button8.addActionListener(this);
    frame.add(button8);

    button9 = new JButton("9");
    button9.setBounds(10, 210, 50, 50);
    button9.addActionListener(this);
    frame.add(button9);

    button0 = new JButton("0");
    button0.setBounds(70, 210, 50, 50);
    button0.addActionListener(this);
    frame.add(button0);

    //create operators button
    addButton = new JButton("+");
    addButton.setBounds(140, 210, 50, 50);
    addButton.addActionListener(this);
    frame.add(addButton);

    subtractButton = new JButton("-");
    subtractButton.setBounds(210, 210, 50, 50);
    subtractButton.addActionListener(this);
    frame.add(subtractButton);

    divideButton = new JButton("/");
    divideButton.setBounds(10, 280, 50, 50);
    divideButton.addActionListener(this);
    frame.add(divideButton);

    decimalButton = new JButton(".");
    decimalButton.setBounds(70, 280, 50, 50);
    decimalButton.addActionListener(this);
    frame.add(decimalButton);



//equal button
    equalButton = new JButton("=");
    equalButton.setBounds(140, 280, 50, 50);
    equalButton.addActionListener(this);
    frame.add(equalButton);

    //clear button
    clearButton = new JButton("C");
    clearButton.setBounds(210, 280, 50, 50);
    clearButton.addActionListener(this);
    frame.add(clearButton);

    frame.setVisible(true);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    String text = e.getActionCommand();

    if (Character.isDigit(text.charAt(0))) {
      textField.setText(textField.getText() + text);
    } else if (text.equals("+")) {
      num1 = Double.parseDouble(textField.getText());
      operator = '+';
      textField.setText("");
    } else if (text.equals("-")) {
      num1 = Double.parseDouble(textField.getText());
      operator = '-';
      textField.setText("");
    } else if (text.equals("*")) {
      num1 = Double.parseDouble(textField.getText());
      operator = '*';
      textField.setText("");
    } else if (text.equals("/")) {
      num1 = Double.parseDouble(textField.getText());
      operator = '/';
      textField.setText("");
    } else if (text.equals(".")) {
      if (!textField.getText().contains(".")) {
        textField.setText(textField.getText() + ".");
      }
    } else if (text.equals("=")) {
      num2 = Double.parseDouble(textField.getText());
      double result = calculate(num1, num2, operator);
      textField.setText(String.valueOf(result));
      num1 = result;
    } else if (text.equals("C")) {
      textField.setText("");
      num1 = 0;
      num2 = 0;
    }
  }

  private double calculate(double num1, double num2, char operator) {
    switch (operator) {
      case '+':
        return num1 + num2;
      case '-':
        return num1 - num2;
      case '*':
        return num1 * num2;
      case '/':
        if (num2 == 0) {
          // Handle division by zero error
          return Double.NaN;
        }
        return num1 / num2;
      default:
        return 0;
    }
  }

  public static void main(String[] args) {
    new Calculator();
  }
}
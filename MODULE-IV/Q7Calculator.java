import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Calculator extends JFrame implements ActionListener {
    JTextField num1, num2, result;
    JButton add, subtract, multiply, divide;

    Calculator() {
        setTitle("Calculator");
        setLayout(new GridLayout(4, 1, 10, 10));

        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel();

        panel1.add(new JLabel("Number 1:"));
        num1 = new JTextField(15);
        panel1.add(num1);

        panel2.add(new JLabel("Number 2:"));
        num2 = new JTextField(15);
        panel2.add(num2);

        add = new JButton("+");
        subtract = new JButton("-");
        multiply = new JButton("*");
        divide = new JButton("/");

        panel3.add(add);
        panel3.add(subtract);
        panel3.add(multiply);
        panel3.add(divide);

        panel4.add(new JLabel("Result:"));
        result = new JTextField(15);
        result.setEditable(false);
        panel4.add(result);

        add(panel1);
        add(panel2);
        add(panel3);
        add(panel4);

        add.addActionListener(this);
        subtract.addActionListener(this);
        multiply.addActionListener(this);
        divide.addActionListener(this);

        setSize(400, 300);
        setLocationRelativeTo(null);
        setVisible(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {
        double a = Double.parseDouble(num1.getText());
        double b = Double.parseDouble(num2.getText());
        double answer = 0;

        if (e.getSource() == add) {
            answer = a + b;
        } 
        else if (e.getSource() == subtract) {
            answer = a - b;
        } 
        else if (e.getSource() == multiply) {
            answer = a * b;
        } 
        else if (e.getSource() == divide) {
            if (b == 0) {
                result.setText("Cannot divide by zero");
                return;
            }

            answer = a / b;
        }

        result.setText(String.valueOf(answer));
    }
}

public class Q7Calculator {
    public static void main(String[] args) {
        new Calculator();
    }
}
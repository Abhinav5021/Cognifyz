// Task: Build a Desktop Application

// Develop a desktop application using
// JavaFX or Swing. The application could
// be a calculator, file manager, or any other
// tool that showcases your user interface
// design skills and event handling.

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class task3 extends JFrame implements ActionListener {
    JTextField display;
    String operator = "";
    double num1 = 0, num2 = 0;

    public task3() {
        setTitle("Simple Calculator");
        setSize(400, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        display = new JTextField();
        display.setFont(new Font("Arial", Font.BOLD, 28));
        display.setEditable(false);
        add(display, BorderLayout.NORTH);

        String[] buttons = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", "C", "=", "+"
        };

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4, 10, 10));

        for (String text : buttons) {
            JButton btn = new JButton(text);
            btn.setFont(new Font("Arial", Font.BOLD, 24));
            btn.addActionListener(this);
            panel.add(btn);
        }

        add(panel, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String btnText = e.getActionCommand();

        if (btnText.matches("\\d")) {
            display.setText(display.getText() + btnText);
        } else if ("/*-+".contains(btnText)) {
            operator = btnText;
            num1 = Double.parseDouble(display.getText());
            display.setText("");
        } else if (btnText.equals("=")) {
            num2 = Double.parseDouble(display.getText());
            double result = calculate(num1, num2, operator);
            display.setText(String.valueOf(result));
        } else if (btnText.equals("C")) {
            display.setText("");
            operator = "";
            num1 = num2 = 0;
        }
    }

    private double calculate(double a, double b, String op) {
        return switch (op) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            case "/" -> (b != 0) ? a / b : 0;
            default -> 0;
        };
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new task3().setVisible(true);
        });
    }
}
// This code creates a simple calculator application using Java Swing.
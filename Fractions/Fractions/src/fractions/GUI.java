/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fractions;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 *
 * @author ldesr5
 */
public class GUI extends JFrame implements ActionListener {

    JPanel leftPanel, rightPanel;
    JLabel num1, num2, deno1, deno2, line1, line2, line3, equalsSign, op;
    JButton next, check;
    JTextField num, deno;
    Fraction f1, f2, input, ans;
    private int min = 1;
    private int max = 4;

    public GUI() {
        f1 = new Fraction();
        f1.random();

        f2 = new Fraction();
        f2.random();

        ans = new Fraction();

        input = new Fraction();

        setBounds(0, 0, 800, 400); /// Size and Location
        setLayout(null); // Chossing Where things go ourselves

        //Right Panel
        rightPanel = new JPanel();
        rightPanel.setLayout(null);
        rightPanel.setBounds(585, 0, 200, 600);
        rightPanel.setBackground(Color.white);

        next = new JButton("Next Question");
        next.addActionListener(this);
        next.setBounds(25, 200, 150, 50);
        rightPanel.add(next);

        check = new JButton("Check my Anwser");
        check.addActionListener(this);
        check.setBounds(25, 260, 150, 50);
        rightPanel.add(check);

        this.add(rightPanel);

        leftPanel = new JPanel();
        leftPanel.setLayout(null);
        leftPanel.setBounds(0, 0, 600, 600);
        leftPanel.setBackground(Color.black);

        num1 = new JLabel("" + f1.getNumerator());
        num1.setFont(new Font("Symbol BOLD", Font.PLAIN, 40));
        num1.setBounds(80, 100, 150, 50);
        num1.setForeground(Color.white);
        leftPanel.add(num1);

        num2 = new JLabel("" + f2.getNumerator());
        num2.setFont(new Font("Symbol BOLD", Font.PLAIN, 40));
        num2.setBounds(280, 100, 150, 50);
        num2.setForeground(Color.white);
        leftPanel.add(num2);

        line1 = new JLabel("____");
        line1.setFont(new Font("Symbol BOLD", Font.PLAIN, 40));
        line1.setBounds(50, 150, 150, 50);
        line1.setForeground(Color.white);
        leftPanel.add(line1);

        line2 = new JLabel("____");
        line2.setFont(new Font("Symbol BOLD", Font.PLAIN, 40));
        line2.setBounds(250, 150, 150, 50);
        line2.setForeground(Color.white);
        leftPanel.add(line2);

        line3 = new JLabel("_____");
        line3.setFont(new Font("Symbol BOLD", Font.PLAIN, 40));
        line3.setBounds(400, 150, 150, 50);
        line3.setForeground(Color.white);
        leftPanel.add(line3);

        equalsSign = new JLabel("=");
        equalsSign.setFont(new Font("Symbol BOLD", Font.PLAIN, 40));
        equalsSign.setBounds(360, 170, 150, 50);
        equalsSign.setForeground(Color.white);
        leftPanel.add(equalsSign);

        op = new JLabel("+");
        op.setFont(new Font("Symbol BOLD", Font.PLAIN, 40));
        op.setBounds(180, 170, 150, 50);
        op.setForeground(Color.white);
        leftPanel.add(op);

        deno1 = new JLabel("" + f1.getDenominator());
        deno1.setFont(new Font("Symbol BOLD", Font.PLAIN, 40));
        deno1.setBounds(80, 250, 150, 50);
        deno1.setForeground(Color.white);
        leftPanel.add(deno1);

        deno2 = new JLabel("" + f2.getDenominator());
        deno2.setFont(new Font("Symbol BOLD", Font.PLAIN, 40));
        deno2.setBounds(280, 250, 150, 50);
        deno2.setForeground(Color.white);
        leftPanel.add(deno2);

        deno = new JTextField("");
        deno.setBounds(400, 210, 100, 100);
        deno.setCaretColor(Color.white);
        deno.setBackground(Color.white);
        deno.setFont(new Font("Symbol BOLD", Font.PLAIN, 40));
        leftPanel.add(deno);

        num = new JTextField("");
        num.setBounds(400, 90, 100, 100);
        num.setCaretColor(Color.white);
        num.setBackground(Color.white);
        num.setFont(new Font("Symbol BOLD", Font.PLAIN, 40));
        leftPanel.add(num);

        this.add(leftPanel);

//No compoents after this
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == next) {
            f1.random();
            f2.random();
            num1.setText("" + f1.getNumerator());
            num2.setText("" + f2.getNumerator());
            deno1.setText("" + f1.getDenominator());
            deno2.setText("" + f2.getDenominator());

            num.setText("");
            deno.setText("");
            Random rand = new Random();
            int randomOp = rand.nextInt((max - min) + 1) + min;
            if (randomOp == 1) {
                op.setText("+");
            } else if (randomOp == 2) {
                op.setText("-");
            } else if (randomOp == 3) {
                op.setText("/");
            } else {
                op.setText("*");
            }

        } else if (e.getSource() == check) {

            try {
//                input.setNumerator(Integer.parseInt(num.getText()));
//                input.setDenominator(Integer.parseInt(deno.getText()));
                input.userInput(Integer.parseInt(num.getText()), Integer.parseInt(deno.getText()));

                if ("+".equals(op.getText())) {
                    f1.add(f2);
                } else if ("-".equals(op.getText())) {
                    f1.subtract(f2);
                } else if ("/".equals(op.getText())) {
                    f1.divide(f2);
                } else {
                    f1.multiply(f2);
                }

                if (input.equals(f1) == true) {
                    JOptionPane.showMessageDialog(null, "Correct!. You may move on to the next question.");
                } else {
                    JOptionPane.showMessageDialog(null, "Nop. Try again.");
                }

            } catch (Exception error) {
                JOptionPane.showMessageDialog(null, "Format Error. Please Try Input Again.");
            }
        }
    }

}

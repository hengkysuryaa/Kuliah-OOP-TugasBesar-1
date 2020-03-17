package oop.tubes1.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;  
import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.AbstractDocument.BranchElement;   


/**
 * App
 */

public class CalculatorApp {
    public void show() {
    }

    //public void getButtonName()
    //public void buttonEvent()

    public static void main(String args[]) {
        final int FRAME_WIDTH=535;
        final int FRAME_HEIGHT=650;  
        final int HEIGHT = 50;
        final int WIDTH  = 75;
        final int H_SPACE=20;
        final int V_SPACE=20;  
        final int TOPX=30;
        final int TOPY=50;  
        final int OFFSET_Y_BUTTON = 150 + V_SPACE; 

        JFrame frame=new JFrame();//creating instance of JFrame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel brand = new JLabel("Call-u-later");
        brand.setBounds((FRAME_WIDTH/2)-(130/2) ,15,130,30);
        brand.setFont(new FontUIResource("Arial",  Font.BOLD + Font.ITALIC , 24));
        brand.setForeground(Color.WHITE);

        JTextField outputArea = new JTextField(20);
        outputArea.setBounds(TOPX,TOPY,460,100);

        Integer[] data = {20, 70, 60, 40};
        JList<Integer> history = new JList<Integer>(data);
        history.setBounds(TOPX,OFFSET_Y_BUTTON,WIDTH, FRAME_HEIGHT-OFFSET_Y_BUTTON-80);
        history.setFont(new FontUIResource("Arial", Font.BOLD, 24));
        DefaultListCellRenderer renderer = (DefaultListCellRenderer) history.getCellRenderer();
        renderer.setHorizontalAlignment(SwingConstants.CENTER);
       
        JButton delete=new JButton("Del");
        delete.setBounds(TOPX+WIDTH+H_SPACE,OFFSET_Y_BUTTON,WIDTH,HEIGHT);

        JButton percent=new JButton("%");
        percent.setBounds(TOPX+2*(WIDTH+H_SPACE),OFFSET_Y_BUTTON,WIDTH,HEIGHT);

        JButton power=new JButton("^");
        power.setBounds(TOPX+3*(WIDTH+H_SPACE),OFFSET_Y_BUTTON,WIDTH,HEIGHT);

        JButton root = new JButton("Sqrt");
        root.setBounds(TOPX+4*(WIDTH+H_SPACE),OFFSET_Y_BUTTON,WIDTH,HEIGHT);

        JButton button7=new JButton("7");
        button7.setBounds(TOPX+WIDTH+H_SPACE,OFFSET_Y_BUTTON+HEIGHT+V_SPACE,WIDTH,HEIGHT);
        
        JButton button8=new JButton("8");
        button8.setBounds(TOPX+2*(WIDTH+H_SPACE),OFFSET_Y_BUTTON+HEIGHT+V_SPACE,WIDTH,HEIGHT);

        JButton button9=new JButton("9");
        button9.setBounds(TOPX+3*(WIDTH+H_SPACE),OFFSET_Y_BUTTON+HEIGHT+V_SPACE,WIDTH,HEIGHT);

        JButton division= new JButton("/");
        division.setBounds(TOPX+4*(WIDTH+H_SPACE),OFFSET_Y_BUTTON+HEIGHT+V_SPACE,WIDTH,HEIGHT);

        JButton button4 = new JButton("4");
        button4.setBounds(TOPX+WIDTH+H_SPACE,OFFSET_Y_BUTTON+2*(HEIGHT+V_SPACE),WIDTH,HEIGHT);

        JButton button5 = new JButton("5");
        button5.setBounds(TOPX+2*(WIDTH+H_SPACE),OFFSET_Y_BUTTON+2*(HEIGHT+V_SPACE),WIDTH,HEIGHT);

        JButton button6 = new JButton("6");
        button6.setBounds(TOPX+3*(WIDTH+H_SPACE),OFFSET_Y_BUTTON+2*(HEIGHT+V_SPACE),WIDTH,HEIGHT);

        JButton multiplication = new JButton("X");
        multiplication.setBounds(TOPX+4*(WIDTH+H_SPACE),OFFSET_Y_BUTTON+2*(HEIGHT+V_SPACE),WIDTH,HEIGHT);

        JButton button1 = new JButton("1");
        button1.setBounds(TOPX+WIDTH+H_SPACE,OFFSET_Y_BUTTON+3*(HEIGHT+V_SPACE),WIDTH,HEIGHT);
        button1.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){
            outputArea.setText("1");
        }});

        JButton button2 = new JButton("2");
        button2.setBounds(TOPX+2*(WIDTH+H_SPACE),OFFSET_Y_BUTTON+3*(HEIGHT+V_SPACE),WIDTH,HEIGHT);

        JButton button3 = new JButton("3");
        button3.setBounds(TOPX+3*(WIDTH+H_SPACE),OFFSET_Y_BUTTON+3*(HEIGHT+V_SPACE),WIDTH,HEIGHT);

        JButton substraction = new JButton("-");
        substraction.setBounds(TOPX+4*(WIDTH+H_SPACE),OFFSET_Y_BUTTON+3*(HEIGHT+V_SPACE),WIDTH,HEIGHT);

        JButton memoryRecall = new JButton("MR");
        memoryRecall.setBounds(TOPX+WIDTH+H_SPACE,OFFSET_Y_BUTTON+4*(HEIGHT+V_SPACE),WIDTH,HEIGHT);

        JButton button0 = new JButton("0");
        button0.setBounds(TOPX+2*(WIDTH+H_SPACE),OFFSET_Y_BUTTON+4*(HEIGHT+V_SPACE),WIDTH,HEIGHT);

        JButton decimal = new JButton(".");
        decimal.setBounds(TOPX+3*(WIDTH+H_SPACE),OFFSET_Y_BUTTON+4*(HEIGHT+V_SPACE),WIDTH,HEIGHT);

        JButton addition = new JButton("+");
        addition.setBounds(TOPX+4*(WIDTH+H_SPACE),OFFSET_Y_BUTTON+4*(HEIGHT+V_SPACE),WIDTH,HEIGHT);

        JButton memoryClear = new JButton("MC");
        memoryClear.setBounds(TOPX+WIDTH+H_SPACE,OFFSET_Y_BUTTON+5*(HEIGHT+V_SPACE),WIDTH,HEIGHT);
        memoryClear.setBackground(new java.awt.Color(190, 10, 40));

        JButton memoryStore = new JButton("MS");
        memoryStore.setBounds(TOPX+2*(WIDTH+H_SPACE),OFFSET_Y_BUTTON+5*(HEIGHT+V_SPACE),WIDTH,HEIGHT);

        JButton ans = new JButton("Ans");
        ans.setBounds(TOPX+3*(WIDTH+H_SPACE),OFFSET_Y_BUTTON+5*(HEIGHT+V_SPACE),WIDTH,HEIGHT);

        
        JButton equation = new JButton("=");
        equation.setBounds(TOPX+4*(WIDTH+H_SPACE),OFFSET_Y_BUTTON+5*(HEIGHT+V_SPACE),WIDTH,HEIGHT);
        
        frame.add(outputArea);
        frame.add(delete);
        frame.add(percent);
        frame.add(power);
        frame.add(root);
        frame.add(button7);
        frame.add(button8);
        frame.add(button9);
        frame.add(division);
        frame.add(button4);
        frame.add(button4);
        frame.add(button5);
        frame.add(button6);
        frame.add(multiplication);
        frame.add(button1);
        frame.add(button2);
        frame.add(button3);
        frame.add(substraction);
        frame.add(memoryRecall);
        frame.add(button0);
        frame.add(decimal);
        frame.add(addition);
        frame.add(memoryClear);
        frame.add(memoryStore);
        frame.add(ans);
        frame.add(equation);
        frame.add(history);
        frame.add(brand);
        frame.setSize(FRAME_WIDTH,FRAME_HEIGHT);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.getContentPane().setBackground(new java.awt.Color(64, 64, 64));
    }
}
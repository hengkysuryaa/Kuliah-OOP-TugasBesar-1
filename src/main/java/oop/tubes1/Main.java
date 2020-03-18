package oop.tubes1;

import javax.swing.JFrame;

import oop.tubes1.gui.CalculatorApp;

/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        CalculatorApp app = new CalculatorApp();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setVisible(true);
    }

}
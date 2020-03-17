package oop.tubes1.gui.button;

import javax.swing.JButton;

import oop.tubes1.gui.CalculatorApp;

/**
 * CalculatorButton
 */
public abstract class CalculatorButton extends JButton implements Clickable {

    private static final long serialVersionUID = -8050319071408324303L;

    public CalculatorButton(CalculatorApp app, String label) {
        super(label);
        this.addActionListener(e -> onClick());
    }

}
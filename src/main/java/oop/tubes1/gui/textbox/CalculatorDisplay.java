package oop.tubes1.gui.textbox;

import javax.swing.JTextField;

/**
 * CalculatorDisplay
 */
public class CalculatorDisplay {

    private JTextField display;

    public CalculatorDisplay(JTextField display) {
        this.display = display;
    }

    public void append(String str) {
        setText(getText() + str);
    }

    public void append(char c) {
        append(String.valueOf(c));
    }

    public void remove() {
        String s = getText();
        if (s.length() > 0) {
            setText(s.substring(s.length() - 1));
        }
    }

    public void clear() {
        setText("");
    }

    public void setTextError(Exception e) {
        setText(e.getMessage());
    }

    public void setText(String text) {
        display.setText(text);
    }

    public String getText() {
        return display.getText();
    }

}
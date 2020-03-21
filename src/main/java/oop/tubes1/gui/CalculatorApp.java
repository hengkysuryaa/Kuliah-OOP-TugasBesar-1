package oop.tubes1.gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.plaf.FontUIResource;

import oop.tubes1.datastructure.MemoryQueue;
import oop.tubes1.gui.button.AnsButton;
import oop.tubes1.gui.button.CalculatorButton;
import oop.tubes1.gui.button.EqualsButton;
import oop.tubes1.gui.button.EraseButton;
import oop.tubes1.gui.button.history.HistoryButton;
import oop.tubes1.gui.button.history.MCButton;
import oop.tubes1.gui.button.history.MRButton;
import oop.tubes1.gui.button.history.MSButton;
import oop.tubes1.gui.button.operand.Comma;
import oop.tubes1.gui.button.operand.Number0;
import oop.tubes1.gui.button.operand.Number1;
import oop.tubes1.gui.button.operand.Number2;
import oop.tubes1.gui.button.operand.Number3;
import oop.tubes1.gui.button.operand.Number4;
import oop.tubes1.gui.button.operand.Number5;
import oop.tubes1.gui.button.operand.Number6;
import oop.tubes1.gui.button.operand.Number7;
import oop.tubes1.gui.button.operand.Number8;
import oop.tubes1.gui.button.operand.Number9;
import oop.tubes1.gui.button.operand.OperandButton;
import oop.tubes1.gui.button.operator.AddButton;
import oop.tubes1.gui.button.operator.DivisionButton;
import oop.tubes1.gui.button.operator.MultButton;
import oop.tubes1.gui.button.operator.OperatorButton;
import oop.tubes1.gui.button.operator.PercentButton;
import oop.tubes1.gui.button.operator.PowerButton;
import oop.tubes1.gui.button.operator.SqrtButton;
import oop.tubes1.gui.button.operator.SubstractButton;

/**
 * App
 */
public class CalculatorApp extends JFrame {

    private static final long serialVersionUID = 3051646471902776406L;
    private static final int FRAME_WIDTH = 535;
    private static final int FRAME_HEIGHT = 650;
    private static final int HEIGHT = 50;
    private static final int WIDTH = 75;
    private static final int H_SPACE = 20;
    private static final int V_SPACE = 20;
    private static final int TOPX = 30;
    private static final int TOPY = 50;
    private static final int OFFSET_Y_BUTTON = 150 + V_SPACE;

    private JTextField textArea;
    private CalculatorButton delete, ans, equation;
    private OperatorButton percent, power, root, division, multiplication, substraction, addition;
    private HistoryButton memoryRecall, memoryClear, memoryStore;
    private OperandButton button0, button1, button2, button3, button4, button5, button6, button7, button8, button9,
            decimal;
    public Double ansValue;
    public MemoryQueue<Double> data;

    public CalculatorApp() {
        init();
    }

    public MemoryQueue<Double> getMemQueue() {
        return data;
    }

    public Double getAnsValue() {
        return ansValue;
    }

    public void setAnsValue(double val) {
        this.ansValue = val;
    }

    public CalculatorButton getEquationButton() {
        return this.equation;
    }

    public JTextField getCalculatorDisplay() {
        return textArea;
    }

    public void init() {
        ansValue = 0.0;
        JLabel brand = new JLabel("Call-u-later");
        brand.setBounds((FRAME_WIDTH / 2) - (130 / 2), 15, 130, 30);
        brand.setFont(new FontUIResource("Arial", Font.BOLD + Font.ITALIC, 24));
        brand.setForeground(Color.WHITE);

        textArea = new JTextField(20);
        textArea.setBounds(TOPX, TOPY, 460, 100);

        Integer[] data = { 20, 70, 60, 40 };
        JList<Integer> history = new JList<Integer>(data);
        history.setBounds(TOPX, OFFSET_Y_BUTTON, WIDTH, FRAME_HEIGHT - OFFSET_Y_BUTTON - 80);
        history.setFont(new FontUIResource("Arial", Font.BOLD, 24));
        DefaultListCellRenderer renderer = (DefaultListCellRenderer) history.getCellRenderer();
        renderer.setHorizontalAlignment(SwingConstants.CENTER);

        delete = new EraseButton(this);
        delete.setBounds(TOPX + WIDTH + H_SPACE, OFFSET_Y_BUTTON, WIDTH, HEIGHT);

        percent = new PercentButton(this);
        percent.setBounds(TOPX + 2 * (WIDTH + H_SPACE), OFFSET_Y_BUTTON, WIDTH, HEIGHT);

        power = new PowerButton(this);
        power.setBounds(TOPX + 3 * (WIDTH + H_SPACE), OFFSET_Y_BUTTON, WIDTH, HEIGHT);

        root = new SqrtButton(this);
        root.setBounds(TOPX + 4 * (WIDTH + H_SPACE), OFFSET_Y_BUTTON, WIDTH, HEIGHT);

        button7 = new Number7(this);
        button7.setBounds(TOPX + WIDTH + H_SPACE, OFFSET_Y_BUTTON + HEIGHT + V_SPACE, WIDTH, HEIGHT);

        button8 = new Number8(this);
        button8.setBounds(TOPX + 2 * (WIDTH + H_SPACE), OFFSET_Y_BUTTON + HEIGHT + V_SPACE, WIDTH, HEIGHT);

        button9 = new Number9(this);
        button9.setBounds(TOPX + 3 * (WIDTH + H_SPACE), OFFSET_Y_BUTTON + HEIGHT + V_SPACE, WIDTH, HEIGHT);

        division = new DivisionButton(this);
        division.setBounds(TOPX + 4 * (WIDTH + H_SPACE), OFFSET_Y_BUTTON + HEIGHT + V_SPACE, WIDTH, HEIGHT);

        button4 = new Number4(this);
        button4.setBounds(TOPX + WIDTH + H_SPACE, OFFSET_Y_BUTTON + 2 * (HEIGHT + V_SPACE), WIDTH, HEIGHT);

        button5 = new Number5(this);
        button5.setBounds(TOPX + 2 * (WIDTH + H_SPACE), OFFSET_Y_BUTTON + 2 * (HEIGHT + V_SPACE), WIDTH, HEIGHT);

        button6 = new Number6(this);
        button6.setBounds(TOPX + 3 * (WIDTH + H_SPACE), OFFSET_Y_BUTTON + 2 * (HEIGHT + V_SPACE), WIDTH, HEIGHT);

        multiplication = new MultButton(this);
        multiplication.setBounds(TOPX + 4 * (WIDTH + H_SPACE), OFFSET_Y_BUTTON + 2 * (HEIGHT + V_SPACE), WIDTH, HEIGHT);

        button1 = new Number1(this);
        button1.setBounds(TOPX + WIDTH + H_SPACE, OFFSET_Y_BUTTON + 3 * (HEIGHT + V_SPACE), WIDTH, HEIGHT);

        button2 = new Number2(this);
        button2.setBounds(TOPX + 2 * (WIDTH + H_SPACE), OFFSET_Y_BUTTON + 3 * (HEIGHT + V_SPACE), WIDTH, HEIGHT);

        button3 = new Number3(this);
        button3.setBounds(TOPX + 3 * (WIDTH + H_SPACE), OFFSET_Y_BUTTON + 3 * (HEIGHT + V_SPACE), WIDTH, HEIGHT);

        substraction = new SubstractButton(this);
        substraction.setBounds(TOPX + 4 * (WIDTH + H_SPACE), OFFSET_Y_BUTTON + 3 * (HEIGHT + V_SPACE), WIDTH, HEIGHT);

        memoryRecall = new MRButton(this);
        memoryRecall.setBounds(TOPX + WIDTH + H_SPACE, OFFSET_Y_BUTTON + 4 * (HEIGHT + V_SPACE), WIDTH, HEIGHT);

        button0 = new Number0(this);
        button0.setBounds(TOPX + 2 * (WIDTH + H_SPACE), OFFSET_Y_BUTTON + 4 * (HEIGHT + V_SPACE), WIDTH, HEIGHT);

        decimal = new Comma(this);
        decimal.setBounds(TOPX + 3 * (WIDTH + H_SPACE), OFFSET_Y_BUTTON + 4 * (HEIGHT + V_SPACE), WIDTH, HEIGHT);

        addition = new AddButton(this);
        addition.setBounds(TOPX + 4 * (WIDTH + H_SPACE), OFFSET_Y_BUTTON + 4 * (HEIGHT + V_SPACE), WIDTH, HEIGHT);

        memoryClear = new MCButton(this);
        memoryClear.setBounds(TOPX + WIDTH + H_SPACE, OFFSET_Y_BUTTON + 5 * (HEIGHT + V_SPACE), WIDTH, HEIGHT);
        memoryClear.setBackground(new Color(190, 10, 40));

        memoryStore = new MSButton(this);
        memoryStore.setBounds(TOPX + 2 * (WIDTH + H_SPACE), OFFSET_Y_BUTTON + 5 * (HEIGHT + V_SPACE), WIDTH, HEIGHT);

        ans = new AnsButton(this);
        ans.setBounds(TOPX + 3 * (WIDTH + H_SPACE), OFFSET_Y_BUTTON + 5 * (HEIGHT + V_SPACE), WIDTH, HEIGHT);

        equation = new EqualsButton(this);
        equation.setBounds(TOPX + 4 * (WIDTH + H_SPACE), OFFSET_Y_BUTTON + 5 * (HEIGHT + V_SPACE), WIDTH, HEIGHT);

        add(textArea);
        add(delete);
        add(percent);
        add(power);
        add(root);
        add(button7);
        add(button8);
        add(button9);
        add(division);
        add(button4);
        add(button4);
        add(button5);
        add(button6);
        add(multiplication);
        add(button1);
        add(button2);
        add(button3);
        add(substraction);
        add(memoryRecall);
        add(button0);
        add(decimal);
        add(addition);
        add(memoryClear);
        add(memoryStore);
        add(ans);
        add(equation);
        add(history);
        add(brand);
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(new Color(64, 64, 64));
    }

}
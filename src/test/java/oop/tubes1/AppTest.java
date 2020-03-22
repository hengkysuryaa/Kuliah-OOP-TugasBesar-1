package oop.tubes1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Field;

import org.junit.Before;
import org.junit.Test;

import oop.tubes1.exception.input.OperatorInputException;
import oop.tubes1.gui.CalculatorApp;
import oop.tubes1.gui.button.Clickable;
import oop.tubes1.utils.MathEvaluator;

public class AppTest {

    private CalculatorApp app;

    @Before
    public void init() {
        app = new CalculatorApp();
    }

    @Test
    public void _1() {
        error("%", OperatorInputException.class, "The operator is invalid! Found on: %");
    }

    @Test
    public void _2() {
        test("5%", 0.05);
    }

    private void test(String exp, double res) {
        calculateInput(exp);
        assertEquals(Double.parseDouble(app.getCalculatorDisplay().getText()), res, 0.01);
    }

    private void error(String exp, Class<?> errorClass, String message) {
        try {
            calculateInput(exp);
            new MathEvaluator(exp).getExpression().solve();
        } catch (Exception e) {
            assertEquals(e.getMessage(), message);
            assertTrue(errorClass.isInstance(e));
        } finally {
            assertEquals(app.getCalculatorDisplay().getText(), message);
        }
    }

    private void calculateInput(String exp) {
        app.getMemoryDisplay().clear();
        app.getCalculatorDisplay().clear();
        for (char c : exp.toCharArray()) {
            press(c);
        }
        press('=');
    }

    private void press(char c) {
        press(String.valueOf(c));
    }

    private void press(String s) {
        Class<?> cl = CalculatorApp.class;
        String fn = "";
        if (s.length() == 1) {
            char c = s.charAt(0);
            if (c >= '0' && c <= '9') {
                fn = "button" + c;
            } else {
                switch (c) {
                    case '%':
                        fn = "percent";
                    case '^':
                        fn = "power";
                    case '√':
                        fn = "root";
                    case '/':
                        fn = "division";
                    case '*':
                        fn = "multiplication";
                    case '-':
                        fn = "substraction";
                    case '+':
                        fn = "addition";
                    case '.':
                        fn = "decimal";
                    case '=':
                        fn = "equation";
                }
            }
        } else {
            switch (s) {
                case "MS":
                    fn = "memoryStore";
                case "MC":
                    fn = "memoryClear";
                case "MR":
                    fn = "memoryRecall";
                case "Del":
                    fn = "delete";
                case "Ans":
                    fn = "ans";
            }
        }
        Clickable clickable = null;
        try {
            Field f = cl.getDeclaredField(fn);
            f.setAccessible(true);
            clickable = (Clickable) f.get(app);
        } catch (Exception e) {
            e.printStackTrace();
        }
        clickable.onClick();
    }

}

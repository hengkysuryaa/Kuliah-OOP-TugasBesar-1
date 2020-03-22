package oop.tubes1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Field;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import oop.tubes1.exception.expression.DivisionByZeroExpressionException;
import oop.tubes1.exception.expression.ExpressionException;
import oop.tubes1.exception.expression.NegativeRootExpressionException;
import oop.tubes1.exception.input.CommaInputException;
import oop.tubes1.exception.input.InputException;
import oop.tubes1.exception.input.OperatorInputException;
import oop.tubes1.gui.CalculatorApp;
import oop.tubes1.gui.button.Clickable;
import oop.tubes1.utils.MathEvaluator;

public class AppTest {

    private static final double PRECISION = 0.001;
    private CalculatorApp app;

    @Before
    public void init() {
        app = new CalculatorApp();
    }

    @BeforeEach
    public void reset() {
        app.getMemoryDisplay().clear();
        app.getCalculatorDisplay().clear();
    }

    @Test
    public void _1() {
        error("%=", OperatorInputException.class, "%");
    }

    @Test
    public void _2() {
        test("5%=", 0.05);
    }

    @Test
    public void _3() {
        test(".5=", 0.5);
    }

    @Test
    public void _4() {
        test("2x-5=", -10.0);
    }

    @Test
    public void _5() {
        error("√-5=", NegativeRootExpressionException.class, -5d);
    }

    @Test
    public void _6() {
        error("2+5-7x8/0=", DivisionByZeroExpressionException.class, 56d);
    }

    @Test
    public void _7() {
        error("√0/0=", DivisionByZeroExpressionException.class, 0d);
    }

    @Test
    public void _8() {
        test("5/5=", 1.0);
    }

    @Test
    public void _9() {
        test("5+-5=", 0);
    }

    @Test
    public void _10() {
        test("10-5=", 5.0);
    }

    @Test
    public void _11() {
        test("5x5/10=", 2.5);
    }

    @Test
    public void _12() {
        test("√25=", 5);
    }

    @Test
    public void _13() {
        test("00002.01x2=", 4.02);
    }

    @Test
    public void _14() {
        error("--12=", OperatorInputException.class, "--");
    }

    @Test
    public void _15() {
        error("5.1.2+2=", CommaInputException.class, "5.1.2");
    }

    @Test
    public void _16() {
        // test("7x5xAns=", 0);
        reset();
        input("7x5x");
        press("Ans");
        press('=');
        checkRes(0);
    }

    @Test
    public void _17() {
        // test("7x5xAns=", 0);
        reset();
        input("2+3");
        press('=');
        app.getCalculatorDisplay().clear();
        input("7x");
        press("Ans");
        press('=');
        checkRes(35.0);
    }

    @Test
    public void _18() {
        // test("7x5xAns=", 0);
        reset();
        input("5x5");
        press("MS");
        checkRes(25.0);
    }

    @Test
    public void _19() {
        // test("7x5xAns=", 0);
        input("5x5");
        press("MS");
        app.getCalculatorDisplay().clear();
        input("5x");
        press("MR");
        press("=");
        checkRes(125.0);
    }

    @Test
    public void _20() {
        test("√√5=", 1.4953487812212205);
    }

    @Test
    public void _21() {
        test("5x√2=", 7.0710678118654755);
    }

    @Test
    public void _22() {
        error("5√2=", OperatorInputException.class, "5√");
    }

    @Test
    public void _23() {
        test("5.", 5);
    }

    private void test(String exp, double res) {
        reset();
        input(exp);
        checkRes(res);
    }

    private void checkRes(double res) {
        assertEquals(Double.parseDouble(app.getCalculatorDisplay().getText()), res, PRECISION);
    }

    private void error(String exp, Class<?> errorClass, Object message) {
        boolean errorFound = false;
        try {
            input(exp);
            new MathEvaluator(exp.endsWith("=") ? exp.substring(0, exp.length() - 1) : exp).getExpression().solve();
        } catch (InputException e) {
            assertEquals(e.getExpression(), message);
            assertTrue(errorClass.isInstance(e));
            errorFound = true;
        } catch (ExpressionException e) {
            assertEquals(e.getNumber(), (Double) message, PRECISION);
            assertTrue(errorClass.isInstance(e));
            errorFound = true;
        } catch (Exception e) {
            assertEquals(e.getMessage(), message);
            assertTrue(errorClass.isInstance(e));
            errorFound = true;
        }
        assertTrue(errorFound);
    }

    private void input(String exp) {
        for (char c : exp.toCharArray()) {
            press(c);
        }
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
                        break;
                    case '^':
                        fn = "power";
                        break;
                    case '√':
                        fn = "root";
                        break;
                    case '/':
                        fn = "division";
                        break;
                    case 'x':
                        fn = "multiplication";
                        break;
                    case '-':
                        fn = "substraction";
                        break;
                    case '+':
                        fn = "addition";
                        break;
                    case '.':
                        fn = "decimal";
                        break;
                    case '=':
                        fn = "equation";
                }
            }
        } else {
            switch (s) {
                case "MS":
                    fn = "memoryStore";
                    break;
                case "MC":
                    fn = "memoryClear";
                    break;
                case "MR":
                    fn = "memoryRecall";
                    break;
                case "Del":
                    fn = "delete";
                    break;
                case "Ans":
                    fn = "ans";
            }
        }
        Clickable clickable = null;
        System.err.println(fn);
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

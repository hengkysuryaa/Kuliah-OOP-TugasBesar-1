package oop.tubes1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Field;

import org.junit.Before;
import org.junit.Test;

import oop.tubes1.exception.expression.ExpressionException;
import oop.tubes1.exception.expression.DivisionByZeroExpressionException;
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

    @Test
    public void _1() {
        error("%", OperatorInputException.class, "%");
    }

    @Test
    public void _2() {
        test("5%", 0.05);
    }

    @Test
    public void _3() {
        error(".5", CommaInputException.class, ".5");
    }

    @Test
    public void _4() {
        test("2x-5=", -10.0);
    }

    @Test
    public void _5() {
        error("√-5", NegativeRootExpressionException.class, "-5");
    }

    @Test
    public void _6() {
        error("2+5-7x8/0=", DivisionByZeroExpressionException.class, "/0");
    }
    
    @Test
    public void _7() {
        error("√0/0", DivisionByZeroExpressionException.class, "/0");
    }

    @Test
    public void _8() {
        test("5/5=", 1.0);
    }

    @Test
    public void _9() {
        error("5+-=", InputException.class, "+-");
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
        test("√25", 5);
    }

    @Test
    public void _13() {
        test("00002.01x2=", 4.02);
    }

    @Test
    public void _14() {
        error("--12", OperatorInputException.class, "--12");
    }


    private void test(String exp, double res) {
        calculateInput(exp);
        assertEquals(Double.parseDouble(app.getCalculatorDisplay().getText()), res, PRECISION);
    }

    private void error(String exp, Class<?> errorClass, Object message) {
        try {
            calculateInput(exp);
            new MathEvaluator(exp).getExpression().solve();
        } catch (InputException e) {
            assertEquals(e.getExpression(), message);
            assertTrue(errorClass.isInstance(e));
        } catch (ExpressionException e) {
            assertEquals(e.getNumber(), (Double) message, PRECISION);
            assertTrue(errorClass.isInstance(e));
        } catch (Exception e) {
            assertEquals(e.getMessage(), message);
            assertTrue(errorClass.isInstance(e));
        }
    }

    private void calculateInput(String exp) {
        app.getMemoryDisplay().clear();
        app.getCalculatorDisplay().clear();
        for (char c : exp.toCharArray()) {
            press(c);
        }
        if (exp.charAt(exp.length() - 1) != '=') {
            press('=');
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

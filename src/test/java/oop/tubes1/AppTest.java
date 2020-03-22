package oop.tubes1;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.Field;

import org.junit.Test;

import oop.tubes1.gui.CalculatorApp;
import oop.tubes1.gui.button.Clickable;

public class AppTest {

    private CalculatorApp app;

    @Test
    public void expressionTests() throws Exception {
        app = new CalculatorApp();

    }

    private void test(String exp, String res) throws Exception {
        app.getMemoryDisplay().clear();
        app.getCalculatorDisplay().clear();
        for (char c : exp.toCharArray()) {
            press(String.valueOf(c));
        }
        assertEquals(app.getCalculatorDisplay().getText(), res);
    }

    private void press(String s) throws Exception {
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
                case "<=":
                    fn = "delete";
                case "Ans":
                    fn = "ans";
            }
        }
        Field f = cl.getField(fn);
        f.setAccessible(true);
        Clickable clickable = (Clickable) f.get(app);
        clickable.onClick();
    }

}

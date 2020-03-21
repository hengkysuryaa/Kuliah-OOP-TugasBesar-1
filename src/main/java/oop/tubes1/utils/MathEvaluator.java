package oop.tubes1.utils;

import java.util.ArrayList;
import java.util.Set;

import oop.tubes1.exception.input.CommaInputException;
import oop.tubes1.exception.input.InputException;
import oop.tubes1.exception.input.OperatorInputException;
import oop.tubes1.expression.Expression;

/**
 * MathEvaluator
 */
public class MathEvaluator extends ExpressionConverter<Expression<Double>> {
	private static final Set<Character> number = Set.of('1', '2', '3', '4', '5', '6', '7', '8', '9', '0');

	public MathEvaluator(String input) {
		super(input);
	}

	@Override
	public Expression<Double> getExpression() throws InputException {
		if (this.checkValidExpression()) {
			ArrayList<String> input = new ArrayList<String>(this.input.length());
			String temp = "";
			for (int i = 0; i < this.input.length(); i++) {
				char c = this.input.charAt(i);
				if (number.contains(c) || c == '.') {
					temp += Character.toString(c);
				} else {
					input.add(temp);
					temp = "";
					input.add(Character.toString(c));
				}

			}
			// Beresin Unary
			ArrayList<Integer> akar = new ArrayList<Integer>(this.input.length());
			ArrayList<Integer> minus = new ArrayList<Integer>(this.input.length());
			ArrayList<Integer> persen = new ArrayList<Integer>(this.input.length());
			for (int i = 0; i < this.input.length(); i++) {
				char c = this.input.charAt(i);
				if (c == '√') {
					akar.add(i);
				} else if (c == '%') {
					persen.add(i);
				} else if (c == '-') {
					minus.add(i);
				}
			}
		}
		// Unreachable code
		return null;
	}

	private boolean checkValidExpression() throws InputException {
		Set<Character> op = Set.of('*', '/', '-', '+', '^', '√', '%');
		Set<Character> opFront = Set.of('-', '√');
		Set<String> op2 = Set.of("--", "*-", "√-", "-√", "√√", "%%");
		String operatorFound = "";
		// Check operator dan angka nya bener ga
		int countMinus = 0;
		int countTitik = 0;
		for (int i = 0; i < this.input.length(); i++) {
			char c = this.input.charAt(i);
			if (i == 0) {
				if (!opFront.contains(c) && !number.contains(c)) {
					throw new OperatorInputException(this.input);
				} else {
					if (opFront.contains(c)) {
						operatorFound += Character.toString(c);
						if (c == '-') {
							countMinus++;
						}
						if (c == '.') {
							countTitik++;
						}
					}
				}
			} else if (i == this.input.length() - 1 && !number.contains(c) && c != '%') {
				throw new OperatorInputException(this.input);
			} else {
				if (op.contains(c)) {
					countTitik = 0;
					if (c == '-') {
						countMinus++;
						if (countMinus > 2) {
							throw new OperatorInputException(this.input);
						}
					} else {
						countMinus = 0;
					}
					operatorFound += Character.toString(c);
					if (operatorFound.length() == 2 && !op2.contains(operatorFound)) {
						throw new OperatorInputException(this.input);
					}
					if (operatorFound.length() == 2) {
						operatorFound = "";
					}
				} else if (c == '.') {
					if (countTitik > 1) {
						throw new CommaInputException(this.input);
					} else {
						countTitik++;
					}

				} else if (number.contains(c)) {
					operatorFound = "";
				}
			}
		}
		return true;
	}

}
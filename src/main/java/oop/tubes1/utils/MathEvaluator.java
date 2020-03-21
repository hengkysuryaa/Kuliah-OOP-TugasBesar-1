package oop.tubes1.utils;

import java.util.ArrayList;
import java.util.Set;
import java.util.Iterator;

import oop.tubes1.exception.input.CommaInputException;
import oop.tubes1.exception.input.InputException;
import oop.tubes1.exception.input.OperatorInputException;
import oop.tubes1.expression.Expression;
import oop.tubes1.expression.TerminalExpression;
import oop.tubes1.expression.BinaryExpression;
import oop.tubes1.expression.PercentExpression;
import oop.tubes1.expression.SqrtExpression;
import oop.tubes1.expression.PowerExpression;

/**
 * MathEvaluator
 */
public class MathEvaluator extends ExpressionConverter<Expression<Double>> {
	private static final Set<Character> number = Set.of('1', '2', '3', '4', '5', '6', '7', '8', '9', '0');
	private static final Set<Character> op = Set.of('*', '/', '-', '+', '^', '√', '%');
	public MathEvaluator(String input) {
		super(input);
	}

	@Override
	public Expression<Double> getExpression() throws InputException {
		if (this.checkValidExpression()) {
			ArrayList<String> inputS = new ArrayList<String>(this.input.length());
			String temp = "";
			for (int i = 0; i < this.input.length(); i++) {
				char c = this.input.charAt(i);
				if (number.contains(c) || c == '.') {
					temp += Character.toString(c);
				} else {
					inputS.add(temp);
					temp = "";
					inputS.add(Character.toString(c));
				}

			}
			// Beresin Unary
			ArrayList<Integer> akar = new ArrayList<Integer>();
			ArrayList<Integer> minus = new ArrayList<Integer>();
			ArrayList<Integer> persen = new ArrayList<Integer>();
			for (int i = 0; i < inputS.size(); i++) {
				String c = inputS.get(i);
				if(i!=0){
					if(c.length()==1){
						if (c.equals("-") && inputS.get(i-1).length()==1 && op.contains(inputS.get(i-1).charAt(0)) && inputS.get(i-1).charAt(0)!='%') {
							minus.add(i);
						}
					}
				}
				else{
					if(c.length()==1){
						if(c.equals('-')){
						minus.add(i);
						}
					}
				}
			}
			int count=0;
			if(!minus.isEmpty()){
				//Beresin Minus
				
				for(int i=0;i<minus.size();i++){
					int pos = minus.get(i);
					temp = inputS.get(pos-count+1);
					inputS.remove(pos-count+1);
					inputS.set(pos-count,inputS.get(pos-count)+temp);
					count++;
				}
			}
			for(int i=0;i<inputS.size();i++){
				String c = inputS.get(i);
				if(c.length()==1){
					if (c.equals("√")) {
						akar.add(i);
					}
				}
			}
			if(!akar.isEmpty()){
				//Beresin akar
				for(int i=akar.size()-1;i<=0;i--){
					int pos = akar.get(i);
					temp = inputS.get(pos+1);
					inputS.remove(pos+1);
					SqrtExpression s = new SqrtExpression(new TerminalExpression<Double>(Double.parseDouble(temp)));
					inputS.set(pos,""+s.solve());

				}
			}

			
			for(int i=0;i<inputS.size();i++){
				String c = inputS.get(i);
				if(c.length()==1){
					if (c.equals("%")) {
						persen.add(i);
					}
				}
			}
			count = 0;
			if(!persen.isEmpty()){
				//Beresin Persen
				for(int i=0;i<persen.size();i++){
					int pos = persen.get(i);
					temp = inputS.get(pos-count-1);
					inputS.remove(pos-count-1);
					PercentExpression p = new PercentExpression(new TerminalExpression<Double>(Double.parseDouble(temp)));
					inputS.set(pos-count-1,""+p.solve());
					count++;
				}
			}

			//Binary Operator
			ArrayList<Integer> pgkt = new ArrayList<Integer>();
			ArrayList<Integer> kali = new ArrayList<Integer>();
			ArrayList<Integer> bagi = new ArrayList<Integer>();
			ArrayList<Integer> tambah = new ArrayList<Integer>();
			ArrayList<Integer> kurang = new ArrayList<Integer>();
			Expression x;
			Expression y;
			Expression res;
			String operan1="";
			Boolean negative1 = false;
			String operan2="";
			Boolean negative2 = false;
			//Beresin Pangkat
			for(int i=0;i<inputS.size();i++){
				String c = inputS.get(i);
				if(c.length()==1){
					if(c.equals("^")){
						pangkat.add(i);
					}
				}
			}
			count = 0;
			if(!pangkat.isEmpty()){
				for(int i=0;i<pangkat.size();i++){
					int pos = pangkat.get(i);
					operan1=inputS.get(pos-count-1);
					operan2=inputS.get(pos-count+1);
					inputS.remove(pos-count+1);
					inputS.remove(pos-count-1);
					if(operan1.charAt(0)=='-' && operan2.charAt(0)=='-'){
						x = new NegativeExpression(new TerminalExpression<Double>(Double.parseDouble(operan1.substring(1))));
						y = new NegativeExpression(new TerminalExpression<Double>(Double.parseDouble(operan2.substring(1))));
						res = new PowerExpression(x,y);
					}
					else if(operan1.charAt(0)=='-'){
						x = new NegativeExpression(new TerminalExpression<Double>(Double.parseDouble(operan1.substring(1))));
						y = new TerminalExpression<Double>(Double.parseDouble(operan2));
						res = new PowerExpression(x,y);
					}
					else{
						x = new TerminalExpression<Double>(Double.parseDouble(operan1));
						y = new NegativeExpression(new TerminalExpression<Double>(Double.parseDouble(operan2.substring(1))));
						res = new PowerExpression(x,y);
					}
					inputS.set(pos-count-1,""+res.solve());
					count +=2;
				}
			}
			//Beresin Kali
			for(int i=0;i<inputS.size();i++){
				String c = inputS.get(i);
				if(c.length()==1){
					if(c.equals("*")){
						kali.add(i);
					}
				}
			}
			count = 0;
			if(!kali.isEmpty()){
				for(int i=0;i<kali.size();i++){
					int pos = kali.get(i);
					operan1=inputS.get(pos-count-1);
					operan2=inputS.get(pos-count+1);
					inputS.remove(pos-count+1);
					inputS.remove(pos-count-1);
					if(operan1.charAt(0)=='-' && operan2.charAt(0)=='-'){
						x = new NegativeExpression(new TerminalExpression<Double>(Double.parseDouble(operan1.substring(1))));
						y = new NegativeExpression(new TerminalExpression<Double>(Double.parseDouble(operan2.substring(1))));
						res = new MultiplicationExpression(x,y);
					}
					else if(operan1.charAt(0)=='-'){
						x = new NegativeExpression(new TerminalExpression<Double>(Double.parseDouble(operan1.substring(1))));
						y = new TerminalExpression<Double>(Double.parseDouble(operan2));
						res = new MultiplicationExpressionExpression(x,y);
					}
					else{
						x = new TerminalExpression<Double>(Double.parseDouble(operan1));
						y = new NegativeExpression(new TerminalExpression<Double>(Double.parseDouble(operan2.substring(1))));
						res = new MultiplicationExpression(x,y);
					}
					inputS.set(pos-count-1,""+res.solve());
					count +=2;
				}
			}
			//Beresin Bagi
			for(int i=0;i<inputS.size();i++){
				String c = inputS.get(i);
				if(c.length()==1){
					if(c.equals("/")){
						bagi.add(i);
					}
				}
			}
			count = 0;
			if(!bagi.isEmpty()){
				for(int i=0;i<bagi.size();i++){
					int pos = bagi.get(i);
					operan1=inputS.get(pos-count-1);
					operan2=inputS.get(pos-count+1);
					inputS.remove(pos-count+1);
					inputS.remove(pos-count-1);
					if(operan1.charAt(0)=='-' && operan2.charAt(0)=='-'){
						x = new NegativeExpression(new TerminalExpression<Double>(Double.parseDouble(operan1.substring(1))));
						y = new NegativeExpression(new TerminalExpression<Double>(Double.parseDouble(operan2.substring(1))));
						res = new DivisionExpression(x,y);
					}
					else if(operan1.charAt(0)=='-'){
						x = new NegativeExpression(new TerminalExpression<Double>(Double.parseDouble(operan1.substring(1))));
						y = new TerminalExpression<Double>(Double.parseDouble(operan2));
						res = new DivisionExpressionExpression(x,y);
					}
					else{
						x = new TerminalExpression<Double>(Double.parseDouble(operan1));
						y = new NegativeExpression(new TerminalExpression<Double>(Double.parseDouble(operan2.substring(1))));
						res = new DivisionExpression(x,y);
					}
					inputS.set(pos-count-1,""+res.solve());
					count +=2;
				}
			}
			//Beresin Tambah
			for(int i=0;i<inputS.size();i++){
				String c = inputS.get(i);
				if(c.length()==1){
					if(c.equals("+")){
						tambah.add(i);
					}
				}
			}
			count = 0;
			if(!tambah.isEmpty()){
				for(int i=0;i<tambah.size();i++){
					int pos = tambah.get(i);
					operan1=inputS.get(pos-count-1);
					operan2=inputS.get(pos-count+1);
					inputS.remove(pos-count+1);
					inputS.remove(pos-count-1);
					if(operan1.charAt(0)=='-' && operan2.charAt(0)=='-'){
						x = new NegativeExpression(new TerminalExpression<Double>(Double.parseDouble(operan1.substring(1))));
						y = new NegativeExpression(new TerminalExpression<Double>(Double.parseDouble(operan2.substring(1))));
						res = new AdditionExpression(x,y);
					}
					else if(operan1.charAt(0)=='-'){
						x = new NegativeExpression(new TerminalExpression<Double>(Double.parseDouble(operan1.substring(1))));
						y = new TerminalExpression<Double>(Double.parseDouble(operan2));
						res = new AdditionExpressionExpression(x,y);
					}
					else{
						x = new TerminalExpression<Double>(Double.parseDouble(operan1));
						y = new NegativeExpression(new TerminalExpression<Double>(Double.parseDouble(operan2.substring(1))));
						res = new AdditionExpression(x,y);
					}
					inputS.set(pos-count-1,""+res.solve());
					count +=2;
				}
			}
			//Beresin Kurang
			for(int i=0;i<inputS.size();i++){
				String c = inputS.get(i);
				if(c.length()==1){
					if(c.equals("-")){
						kurang.add(i);
					}
				}
			}
			count = 0;
			if(!kurang.isEmpty()){
				for(int i=0;i<kurang.size();i++){
					int pos = kurang.get(i);
					operan1=inputS.get(pos-count-1);
					operan2=inputS.get(pos-count+1);
					inputS.remove(pos-count+1);
					inputS.remove(pos-count-1);
					if(operan1.charAt(0)=='-' && operan2.charAt(0)=='-'){
						x = new NegativeExpression(new TerminalExpression<Double>(Double.parseDouble(operan1.substring(1))));
						y = new NegativeExpression(new TerminalExpression<Double>(Double.parseDouble(operan2.substring(1))));
						res = new SubstractExpression(x,y);
					}
					else if(operan1.charAt(0)=='-'){
						x = new NegativeExpression(new TerminalExpression<Double>(Double.parseDouble(operan1.substring(1))));
						y = new TerminalExpression<Double>(Double.parseDouble(operan2));
						res = new SubstractExpressionExpression(x,y);
					}
					else{
						x = new TerminalExpression<Double>(Double.parseDouble(operan1));
						y = new NegativeExpression(new TerminalExpression<Double>(Double.parseDouble(operan2.substring(1))));
						res = new SubstractExpression(x,y);
					}
					inputS.set(pos-count-1,""+res.solve());
					count +=2;
				}
			}

			return new TerminalExpression<Double>(5.0);
		}
		return new TerminalExpression<Double>(0.0);
		// Unreachable code
		
	}

	private boolean checkValidExpression() throws InputException {
		Set<Character> opFront = Set.of('-', '√');
		Set<String> op2 = Set.of("--", "*-", "√-", "-√", "√√", "%%","%+","%-","%*","%/");
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
							if(c=='-' && this.input.charAt(i+1)=='-')
								throw new OperatorInputException(this.input);
							else
							countMinus++;
						}
						if (c == '.') {
							countTitik++;
						}
					}
				}
			} else if (i == this.input.length() - 1 && !number.contains(c) && c != '%') {
				throw new OperatorInputException(this.input);
			} else{
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
						throw new OperatorInputException(operatorFound);
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
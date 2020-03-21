package oop.tubes1.utils;

import oop.tubes1.exception.input.InputException;
import oop.tubes1.expression.Expression;

/**
 * MathEvaluator
 */
public class MathEvaluator extends ExpressionConverter<Expression<Double>> {
	Set<Char> number = Set.of('1','2','3','4','5','6','7','8','9','0');
    public MathEvaluator(String input) {
        super(input);
    }

    @Override
    public Expression<Double> getExpression() throws InputException {
    	if(this.checkValidExpression()){
    		ArrayList<String> input = new ArrayList<String>(this.input.length());
    		String temp="";
    		for(int i=0;i<this.input.length();i++){
    			if(number.contains(this.input.charAt(i)) || this.input.charAt(i)=='.'){
    			   temp += Character.toString(this.input.charAt(i));	
    			}
    			else{
    				input.add(temp);
    				temp = "";
    				input.add(Character.toString(this.input.charAt(i)));
    			}
    			
    		}
    		//Beresin Unary
    		ArrayList<Int> akar = new ArrayList<Int>(this.input.length());
    		ArrayList<Int> minus = new ArrayList<Int>(this.input.length());
    		ArrayList<Int> persen = new ArrayList<Int>(this.input.length());
    		for(int i=0;i<this.input.length();i++){
    			if(this.input.charAt(i)=='√'){
    				akar.add(i);
    			}
    			else if(this.input.charAt(i)=='%'){
    				persen.add(i);
    			}
    			else if(this.input.charAt(i)=='-'){
    				minus.add(i);
    			}
    		}
    	}
    }

    public boolean checkValidExpression() throws InputException{
    	Set<Char> op = Set.of('*','/','-','+','^','√','%');
        Set<Char> opFront = Set.of('-','√');
        Set<String> op2 = Set.of("--","*-","√-","-√","√√","%%");
        String operatorFound="";
        //Check operator dan angka nya bener ga
        int countMinus = 0;
        int countTitik = 0;
        for(int i=0;i<this.input.length();i++){
        	if(i==0){
        		if(!opFront.contains(this.input.charAt(i))&&!number.contains(this.input.charAt(i))){
        			throw new OperatorInputException(this.input);
        		}
        		else{
        			if(opFront.contains(this.input.charAt(i))){
        				operatorFound+=Character.toString(this.input.charAt(i));
        				if(this.input.charAt(i)=='-'){
        					countMinus++;
        				}
        				if(this.input.charAt(i)=='.'){
        					countTitik++;
        				}	
        			}
        		}
        	}
        	else if(i==this.input.length-1 && !number.contains(this.input.charAt(i)) && this.input.charAt(i)!='%'){
        		throw new OperatorInputException(this.input);
        	}
        	else{
        		if(	op.contains(this.input.charAt(i))){
        			countTitik = 0;
        			if(this.input.charAt(i)=='-'){
        				countMinus++;
        				if(countMinus>2){
        					throw new OperatorInputException(this.input);
        				}
        			}
        			else{
        				countMinus=0;
        			}
        			operatorFound += Character.toString(this.input.charAt(i));
        			if(operatorFound.length==2 && !op2.contains(operatorFound)){
        				throw new OperatorInputException(this.input);
        			}
        			if(operatorFound.length==2){
        				operatorFound ="";
        			}
        		}
        		else if(this.input.charAt(i)=='.'){
        			if(countTitik>1){
        				throw new CommaInputException(this.input);
        			}
        			else{
        				countTitik++;	
        			}
        			
        		}
        		else if(number.contains(this.input.charAt(i))){
        			operatorFound="";
        		}
        	}
        }
        return true;
    }


}
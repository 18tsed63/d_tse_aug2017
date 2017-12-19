/* Darius Tse
 * 12.18.17
 * fraction calculator
 */
package fracCalc;
import java.util.Arrays;
import java.util.Scanner;

public class FracCalc {

    public static void main(String[] args) 
    {
        boolean done = false;
        while(!done == true) {
    	Scanner userInput = new Scanner (System.in);
        System.out.println("Enter expression: ");
        String expression = userInput.nextLine();
        System.out.println(produceAnswer(expression));
        
        System.out.println("Do you want to quit?");
        String quit = userInput.next();
        int n = quit.indexOf("q");
		if(n == 0) {
			done = true;
		}else {
			done = false;
		}
    }
    }
    // ** IMPORTANT ** DO NOT DELETE THIS FUNCTION.  This function will be used to test your code
    // This function takes a String 'input' and produces the result
    //
    // input is a fraction string that needs to be evaluated.  For your program, this will be the user input.
    //      e.g. input ==> "1/2 + 3/4"
    //        
    // The function should return the result of the fraction after it has been calculated
    //      e.g. return ==> "1_1/4"
    public static String produceAnswer(String input)
    { 
    	String[] expression = input.split(" ");
    	Fraction operand1 = new Fraction(expression[0]);
    	Fraction operand2 = new Fraction(expression[2]);
        String operator = expression[1];
        int[] op1 = operand1.getArr();
        int[] op2 = operand2.getArr();
        
        int[] result = new int [2];
        String answer = "";
        if(operator.equals("+")) {        	
        	//common denominator
    		op1[0] *= op2[1];
        	op2[0] *= op1[1];        	
        	int denominator = op1[1] * op2[1];
        	
        	result = operand1.addFrac(op1[0], op2[0], denominator);
        	answer = operand1.toMixedNum(result);
        }
        else if(operator.equals("-")) {
        	//common denominator
        	op1[0] *= op2[1];
        	op2[0] *= op1[1];
        	
        	int denominator = op1[1] * op2[1];
        	result = operand1.subtractFrac(op1[0], op2[0], denominator);
        	answer = operand1.toMixedNum(result);
        }
       else if(operator.equals("*")) {       	    		
    	   	result = operand1.multiplyFrac(op1[0], op1[1], op2[0], op2[1]);        	
       		answer = operand1.toMixedNum(result);   			
	
        }
        else if(operator.equals("/")) {        	
        	result = operand1.divideFrac(op1[0], op1[1], op2[0], op2[1]);
        	answer = operand1.toMixedNum(result);

        }        
        return answer;  
    }

}









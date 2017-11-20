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
        String operand1 = expression[0];
        String operator = expression[1];
        String operand2 = expression[2];
        operand1 = splitOp(operand1);
        operand2 = splitOp(operand2);
        
        return operand2;
        
    }
    public static String splitOp(String equation) {
    	String[] expression = new String [3];
    //mixedNum
    if(equation.indexOf("/") >= 0 && equation.indexOf("_") >= 0) {
    	//String[] expression = new String [3];
		String[] arr = equation.split("_");	
		expression[0] = arr[0];
		String[] frac = arr[1].split("/");
		expression[1] = frac[0];
		expression[2] = frac[1];
		}
    //wholeNum
    else if(!(equation.indexOf("/") >= 0 && equation.indexOf("_") >= 0)) {
    	expression[0] = equation;
    	expression[1] = "0";
    	expression[2] = "1";
    }
    //fracNum
    else if(equation.indexOf("/") >= 0 && !(equation.indexOf("_") >= 0)) {
    	String[] arr = equation.split("/");
    	expression[0] = "0";
    	expression[1] = arr[0];
    	expression[2] = arr[1];
    }
    return Arrays.toString(expression);
    }
    
}
